package com.andre.mvc.security;

import com.andre.mvc.database.crm.entity.Client;
import com.andre.mvc.database.crm.entity.Group;
import com.andre.mvc.database.crm.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;import java.lang.Override;import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by 1 on 12.05.2015.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Client client = clientRepository.findByPhone(username);

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        CustomUserDetailsUser customUserDetailsUser = new CustomUserDetailsUser(
                client.getUsername(),
                client.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAutorities(client.getGroup()),
                client.getSalt(),
                client.getPhone()
        );

        return customUserDetailsUser;
    }

    public Collection<? extends GrantedAuthority> getAutorities(Group group) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(group));
        return authList;
    }

    public List<String> getRoles(Group group) {
        List<String> roles = new ArrayList<String>();

        if(group != null && group.getName().equals("Admins")) {
            roles.add("ROLE_ADMIN");
            roles.add("ROLE_USER");
        } else {
            roles.add("ROLE_USER");
        }

        return roles;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return authorities;
    }
}
