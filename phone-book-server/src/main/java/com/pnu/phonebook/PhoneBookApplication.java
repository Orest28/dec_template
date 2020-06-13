package com.pnu.phonebook;

import com.pnu.phonebook.Model.Record;
import com.pnu.phonebook.Repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhoneBookApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(PhoneBookApplication.class, args);
    }

}
