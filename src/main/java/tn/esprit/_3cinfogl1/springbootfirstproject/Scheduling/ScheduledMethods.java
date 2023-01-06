package tn.esprit._3cinfogl1.springbootfirstproject.Scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit._3cinfogl1.springbootfirstproject.Services.IContratService;

@Slf4j
@Component
public class ScheduledMethods {
@Autowired
    IContratService iContractService;
    @Scheduled(cron = "10 * * * * *")
    void verifContratsExpires(){

        String msg=iContractService.retrieveAndUpdateStatusContrat();
        log.warn(msg);

    }

}
