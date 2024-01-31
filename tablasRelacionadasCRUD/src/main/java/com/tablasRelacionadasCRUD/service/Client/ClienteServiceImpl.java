package com.tablasRelacionadasCRUD.service.Client;

import com.tablasRelacionadasCRUD.entity.Cliente;
import com.tablasRelacionadasCRUD.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClientRepository clientRepository;
    @Override
    public Cliente createClient(Cliente cLiente) {
       return clientRepository.save(cLiente);
    }
}
