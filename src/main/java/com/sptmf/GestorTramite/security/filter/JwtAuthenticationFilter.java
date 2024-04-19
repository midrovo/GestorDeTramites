package com.sptmf.GestorTramite.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sptmf.GestorTramite.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.sptmf.GestorTramite.security.TokenJwtConfig.*;

@Getter
@Setter
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        User user = new ObjectMapper().readValue(request.getInputStream(), User.class);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword()
        );

        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) throws IOException, ServletException {

        org.springframework.security.core.userdetails.User user =
                (org.springframework.security.core.userdetails.User) authResult.getPrincipal();

        Collection<? extends GrantedAuthority> roles = user.getAuthorities();

        Claims claims = Jwts.claims().add("authorities", new ObjectMapper().writeValueAsString(roles)).build();

        String token = Jwts.builder()
                .subject(user.getUsername())
                .claims(claims)
                .expiration(new Date(System.currentTimeMillis() + 3600000))
                .issuedAt(new Date())
                .signWith(SECRET_KEY).compact();

        response.addHeader(HEADER_AUTHORIZATION, PREFIX_TOKEN + token);

        Map<String, String> json = new HashMap<>();
        json.put("token", token);
        json.put("username", user.getUsername());
        json.put("message", String.format("Hola %s has iniciado sesion con exito", user.getUsername()));

        response.getWriter().write(new ObjectMapper().writeValueAsString(json));
        response.setContentType(CONTENT_TYPE);
        response.setStatus(HttpStatus.OK.value());
    }

    @Override
    protected void unsuccessfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {
        Map<String, String> json = new HashMap<>();
        json.put("message", "Error en la autenticacion username o password incorrectos");
        json.put("error", failed.getMessage());

        response.getWriter().write(new ObjectMapper().writeValueAsString(json));
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(CONTENT_TYPE);
    }
}
