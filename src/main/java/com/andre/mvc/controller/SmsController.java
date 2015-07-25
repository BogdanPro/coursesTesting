package com.andre.mvc.controller;

import com.andre.mvc.controller.response.JsonResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.andre.mvc.database.sms.entity.*;
import com.andre.mvc.database.sms.repository.*;
import com.andre.mvc.manager.SmsManagerImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * Created by Bogdan on 26.06.2015.
 */
@Controller
public class SmsController {

    private final static int MAX_SMS_LENGTH = 1530;

    @Autowired
    SmsManagerImpl smsManager;
    @RequestMapping(value = "/sendSMS", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
        public JsonResponse sendSMS( @RequestParam String textVal, @RequestParam String [] phones) {

        if(textVal.length() > MAX_SMS_LENGTH)
            return new JsonResponse("Text length should be less than 1530 symbols", JsonResponse.ERROR);

        if(textVal.equals(""))
            return new JsonResponse("Please, type your SmS", JsonResponse.ERROR);

        if(phones[0].equals("[]"))
            return new JsonResponse("You have to choose atleast one phone number", JsonResponse.ERROR);

        return new JsonResponse(smsManager.sendSms(phones, textVal) , JsonResponse.SUCCESS);
    }
}
