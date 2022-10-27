package tn.kadem.kadem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import tn.kadem.kadem.Services.Contrat.ContratServiceImp;

@SpringBootApplication
@EnableScheduling
public class KademApplication {


    public static void main(String[] args) {
        SpringApplication.run(KademApplication.class, args);

    }

}
