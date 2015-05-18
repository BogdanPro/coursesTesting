package com.andre.mvc.manager;

import com.andre.mvc.database.crm.entity.Client;
import org.springframework.transaction.annotation.Transactional;

import java.lang.String;import java.util.List;

/**
 * Created by 1 on 12.05.2015.
 */
public interface ClientService {
    public List<Client> loadClientByConditions(String name, String surname, String phone, String email, String tags);

    public Client loadByPhone(String phone);

    public void save(Client client);

    void clientFlush();

    public List<Client> loadAll();

    public Client loadById(Long id);

    public void delete(Long id);

    public Client loadByName(String name);
}
