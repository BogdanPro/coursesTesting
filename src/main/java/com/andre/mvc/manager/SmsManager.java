package com.andre.mvc.manager;

import com.andre.mvc.database.sms.entity.Sms;

/**
 * Created by Bogdan on 25.06.2015.
 */
public interface SmsManager {
//    public boolean sendSms(Sms sms);
    public String sendSms(String [] phones, String text);
    public Double checkBalance();
    public String checkStatusOfSmsToNumber(String message, String number);
}
