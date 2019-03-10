package br.com.livecoding.service;

import br.com.livecoding.model.Cliente;
import br.com.livecoding.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends AbstractService<Cliente, Long> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    protected JpaRepository<Cliente, Long> getRepository() {

        return clienteRepository;
    }
}
