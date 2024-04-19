package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.dto.EmpleadoCreateDTO;
import com.sptmf.GestorTramite.interfaces.EmpleadoInterface;
import com.sptmf.GestorTramite.mapper.DepartamentoModelMapper;
import com.sptmf.GestorTramite.mapper.EmployeeModelMapper;
import com.sptmf.GestorTramite.model.*;
import com.sptmf.GestorTramite.repository.EmpleadoRepository;
import com.sptmf.GestorTramite.repository.RolRepository;
import com.sptmf.GestorTramite.util.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmpleadoService implements EmpleadoInterface {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeeModelMapper employeeModelMapper;

    @Autowired
    private DepartamentoModelMapper departamentoModelMapper;

    @Override
    public List<Empleado> getAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> getById(Long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public Optional<Empleado> getByCedula(String cedula) {
        return empleadoRepository.findByCedula(cedula);
    }

    @Override
    public Optional<Empleado> getByUsername(String username) {
        return empleadoRepository.findByUsername(username);
    }

    @Override
    public Empleado create(EmpleadoCreateDTO empleadoCreateDTO) {
        String username = empleadoCreateDTO.getUsername();
        String password = empleadoCreateDTO.getCedula();
        Set<RoleEnum> roles = empleadoCreateDTO.getRoles();

        User user = setUserAndRol(username, password, roles);

        Departamento departamento = departamentoModelMapper.toDepartamento(empleadoCreateDTO.getDepartamento());
        Empleado empleado = employeeModelMapper.toEmpleado(empleadoCreateDTO);
        empleado.setDepartamento(departamento);
        empleado.setUser(user);

        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado update(Empleado empleado) {
        return getById(empleado.getId()).isPresent() ? empleadoRepository.save(empleado) : null;
    }

    @Override
    public Empleado delete(Long id) {
        Optional<Empleado> empleadoOptional = getById(id);

        if(empleadoOptional.isPresent()) {
            Empleado empleado = empleadoOptional.get();
            empleadoRepository.delete(empleado);
            return empleado;
        }

        return null;
    }

    private User setUserAndRol(String username, String password, Set<RoleEnum> roles) {
        Set<Role> roleSet = new HashSet<>();
        roles.forEach(rol -> roleSet.add(rolRepository.findByName(rol).orElse(null)));

        User user = new User(username, passwordEncoder.encode(password));
        user.setRoles(roleSet);
        user.setEnabled(true);
        user.setAccountNoExpired(true);
        user.setAccountNoLocked(true);
        user.setCredentialNoExpired(true);

        return user;
    }

}
