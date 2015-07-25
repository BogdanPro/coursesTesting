package com.andre.mvc.manager;

import com.andre.mvc.database.sms.entity.Sms;
import com.andre.mvc.database.sms.repository.SmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * Created by Bogdan on 25.06.2015.
 */
@Component("SmsManager")
public class SmsManagerImpl implements SmsManager {

    @Autowired
    private SmsRepository smsRepository;

//    @Override
//    public boolean sendSms(Sms sms) {
//        Connection conn = getDBConnection();
//        if (conn == null) return false;
//
//        try {
//            //            smsRepository.saveAndFlush(sms);
////            return true;
//            PreparedStatement ps = conn.prepareStatement("INSERT INTO bogdanp (message, number, sign) VALUES(?, ?, ?)");
//            ps.setString(1, sms.getMessage());
//            ps.setString(2, sms.getNumber());
//            ps.setString(3, sms.getSign());
//            ps.executeUpdate();
//            ps.close();
//            conn.close();
//            return true;
//        } catch (Exception e) {
//            try {
//                conn.close();
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
//            e.printStackTrace();
//            return false;
//        }
//    }

//    public void sendSpringDataSms(String msg, String number, String sign) {
//        smsRepository.insertTobogdanp(number, msg, sign);
//    }

    @Override
    public String sendSms(String [] phones, String text) {
        Connection conn = getDBConnection();
        if (conn == null) return "Cannot connect to database";
        StringBuilder result=new StringBuilder();
        PreparedStatement ps=null;
        for (String phone :phones)
            try {
                phone=phone.replaceAll("\\[|\\]|\"", "");
                ps = conn.prepareStatement("INSERT INTO gazlow (message, number, sign) VALUES(?, ?, ?)");
                ps.setString(1, text);
                ps.setString(2, phone);
                ps.setString(3, "Abateur");
                ps.executeUpdate();
                ps.close();
                result.append(phone + " ok \r\n");
            } catch (Exception e) {
                result.append(phone + " err \r\n");
                e.printStackTrace();
            }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.toString();
    }



    @Override
    public Double checkBalance() {
        Sms sms = smsRepository.findTop1ByNumber("");
        return sms == null ? 0 : sms.getBalance();
//        return null;
    }

    @Override
    public String checkStatusOfSmsToNumber(String message, String number) {
        return smsRepository.findByMessageAndNumber(message, number).getStatus();
//        return null;
    }


    //for sms sending

    private static Connection getDBConnection() {
        Connection dbConnection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://94.249.146.189:3306/users", "gazlow", "password");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return dbConnection;
    }
}
