package com.sptmf.GestorTramite.service;

import com.sptmf.GestorTramite.dto.EmpleadoCreateDTO;
import com.sptmf.GestorTramite.interfaces.EmpleadoInterface;
import com.sptmf.GestorTramite.mapper.DepartamentoModelMapper;
import com.sptmf.GestorTramite.mapper.EmployeeModelMapper;
import com.sptmf.GestorTramite.model.Departamento;
import com.sptmf.GestorTramite.model.Empleado;
import com.sptmf.GestorTramite.model.Role;
import com.sptmf.GestorTramite.model.User;
import com.sptmf.GestorTramite.repository.EmpleadoRepository;
import com.sptmf.GestorTramite.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements EmpleadoInterface {
    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmployeeModelMapper employeeModelMapper;

    @Autowired
    DepartamentoModelMapper departamentoModelMapper;

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
    public Empleado create(EmpleadoCreateDTO empleadoCreateDTO) {
        User user = setUserAndRol(
                empleadoCreateDTO.getName(),
                empleadoCreateDTO.getLastname(),
                empleadoCreateDTO.getCedula(),
                empleadoCreateDTO.getNameRol()
                );

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

    public String createUsername(String name, String lastname) {
        int PRIMERA_POSICION = 0;
        String username = name.charAt(PRIMERA_POSICION) + lastname.split(" ")[PRIMERA_POSICION];
        return username.toLowerCase();
    }

    public User setUserAndRol(String name, String lastname, String password, String ROLE_NAME) {
        Optional<Role> roleOptional = rolRepository.findByName(ROLE_NAME);
        Role role = roleOptional.orElse(null);
        User user = new User();
        String username = createUsername(name, lastname);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);

        return user;
    }


}
