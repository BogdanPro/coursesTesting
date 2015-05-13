package com.andre.mvc.service;

import com.andre.mvc.database.entity.Client;

import java.lang.String;import java.util.List;

/**
 * Created by 1 on 12.05.2015.
 */
public interface ClientService {
    public List<Client> loadClientByConditions(String name, String surname, String phone, String email, String tags);

    public Client loadByPhone(String phone);

    public void save(Client client);

    public List<Client> loadAll();

    public Client loadById(Long id);

    public void delete(Long id);
}
