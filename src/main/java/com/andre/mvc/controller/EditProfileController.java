package com.andre.mvc.controller;

import com.andre.mvc.database.crm.entity.Client;
import com.andre.mvc.manager.ClientService;
import com.andre.mvc.security.CustomUserDetailsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 1 on 21.05.2015.
 */

@Controller
public class EditProfileController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "client/editProfile")
    public ModelAndView editProfilePage(){
        ModelAndView modelAndView = new ModelAndView("client/edit-profile");

        CustomUserDetailsUser user = (CustomUserDetailsUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Client client = clientService.loadByPhone(user.getPhone());

        modelAndView.addObject("username", client.getName());
        modelAndView.addObject("phone", client.getPhone());
        return modelAndView;
    }
}
