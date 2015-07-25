package com.andre.mvc.database.sms.repository;

import com.andre.mvc.database.sms.entity.Sms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Bogdan on 25.06.2015.
 */
public interface SmsRepository  extends JpaRepository<Sms, Long> {
    public Sms findByStatus(String status);
    public List<Sms> findByStatusLike(String statusPattern);
    public Sms findByNumber(String number);
    public List<Sms> findByNumberLike(String numberPattern);
    public Sms findByMessage(String message);
    public List<Sms> findByMessageLike(String messagePattern);
    public Sms findByMessageAndNumber(String message, String number);

    //?
//    public Sms findBySended(Timestamp sended);
//    public List<Sms> findBySendedLike(Timestamp sendedPattern);

    public Sms findTop1ByNumber(String number);

//    @Query(value = "insert into gazlow (number, message, sign) VALUES (?0, ?1, ?2)", nativeQuery = true)
//    public void insertTobogdanp(String number, String message, String sign);
//

}
