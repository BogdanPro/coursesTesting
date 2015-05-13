package com.andre.mvc.service;

import com.andre.mvc.database.entity.Client;
import com.andre.mvc.database.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.Override;import java.lang.String;import java.util.List;

/**
 * Created by 1 on 12.05.2015.
 */
@Component("clientService")
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> loadClientByConditions(String name, String surname, String phone, String email, String tags) {
        return clientRepository.findByNameLikeAndSurnameLikeAndPhoneLikeAndEmailLikeAndTagsLike(name, surname, phone, email, tags);
    }

    @Override
    public Client loadByPhone(String phone) {
        return clientRepository.findByPhone(phone);
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> loadAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client loadById(Long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        clientRepository.delete(id);
    }
}
