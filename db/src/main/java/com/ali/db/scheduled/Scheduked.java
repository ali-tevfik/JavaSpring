package com.ali.db.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduked {

    @Scheduled(cron = "0 00 10 * * *")
    public void writeOneToTen(){
        for (int i = 1; i <= 10;i++){
            System.out.println(i + " ");
        }
    }
}
