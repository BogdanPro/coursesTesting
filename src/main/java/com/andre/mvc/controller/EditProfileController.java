package com.andre.mvc.controller;

import com.andre.mvc.controller.requestClasses.EditNameRequest;
import com.andre.mvc.controller.response.JsonResponse;
import com.andre.mvc.database.crm.entity.Client;
import com.andre.mvc.database.forum.entity.Member;
import com.andre.mvc.manager.ClientService;
import com.andre.mvc.manager.ForumManagerImpl;
import com.andre.mvc.security.CustomUserDetailsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by 1 on 21.05.2015.
 */

@Controller
@RequestMapping(value = "/client/**")
public class EditProfileController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ForumManagerImpl forumManager;
    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @RequestMapping(value = "editProfile")
    public ModelAndView editProfilePage() {
        ModelAndView modelAndView = new ModelAndView("/client/edit-profile");

        CustomUserDetailsUser user = (CustomUserDetailsUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Client client = clientService.loadByPhone(user.getPhone());

        modelAndView.addObject("username", client.getName());
        modelAndView.addObject("phone", client.getPhone());
        return modelAndView;
    }

    @RequestMapping(value = "cabinet")
    public ModelAndView cabinet() {
        return new ModelAndView("/client/cabinet");
    }

    @RequestMapping(value = "editProfile/changeName", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public JsonResponse editName(@RequestBody EditNameRequest request) {

        CustomUserDetailsUser user = (CustomUserDetailsUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String phone = user.getPhone();
        String currentUsername = user.getUsername();
        String newUsername = request.getUsername();

        Member member = forumManager.loadByName(newUsername);

        // this username isn't used
        if (member == null) {
            // we should search client by phone, because it's required field in registration
            // so it's unique and in's guaranteed not null
            Client client = clientService.loadByPhone(phone);
            System.out.println(client);
            client.setUsername(newUsername);
            client.setName(request.getFirstName());
            client.setSurname(request.getLastName());
            clientService.save(client);

//            //reinit. Old object is useless now
//            member = forumManager.loadByName(currentUsername);
//            //it means, that client wasn't registered in forum
//            if(member == null) {
//                if(client.getEmail() != null) {
//                    //registration
//                    member = new Member();
//                    member.setName(client.getUsername());
//                    member.setEmail(client.getEmail());
//
//                    String password = passwordEncoder.encodePassword(client.getUsername().toLowerCase()
//                        + client.getUsername(), null);
//                    member.setPassword(password);
//                    member.setGroup(0);
//
//                    forumManager.save(member);
//                }
//            } else {
//                member.setName(newUsername);
//                forumManager.save(member);
//            }

            //maybe dangerous!!!!
            user.setUsername(newUsername);

            return new JsonResponse("Changes accepted", JsonResponse.SUCCESS);
        } else {
            return new JsonResponse("This username is already in use or just you can't change it now",
                    JsonResponse.ERROR);
        }
    }
}
