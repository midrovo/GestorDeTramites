package com.sptmf.GestorTramite.interfaces;

import com.sptmf.GestorTramite.model.Cliente;

import java.util.List;

public interface ClienteInterface {
    List<Cliente> getClients();
    Cliente createClient(Cliente cliente);

}
