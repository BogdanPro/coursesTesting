package com.andre.mvc.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by 1 on 18.05.2015.
 */
public class SaltSource extends ReflectionSaltSource{

    @Autowired
    private ClientService clientService;

    @Override
    public Object getSalt(UserDetails user) {
        return clientService.loadByName(user.getUsername()).getSalt();
    }
}
