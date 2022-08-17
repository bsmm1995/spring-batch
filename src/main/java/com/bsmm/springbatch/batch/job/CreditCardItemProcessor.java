package com.bsmm.springbatch.batch.job;

import com.bsmm.springbatch.domain.entities.CreditCardEntity;
import com.bsmm.springbatch.domain.entities.CreditCardRiskEntity;
import com.bsmm.springbatch.util.Constants;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class CreditCardItemProcessor implements ItemProcessor<CreditCardEntity, CreditCardRiskEntity> {

    @Override
    public CreditCardRiskEntity process(CreditCardEntity item) {

        LocalDate today = LocalDate.now();
        LocalDate lastDate = item.getLastPay().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long daysBetween = DAYS.between(today, lastDate);

        int risk;
        if (daysBetween >= 20) {
            risk = Constants.HIGH;
        } else if (daysBetween > 10) {
            risk = Constants.LOW;
        } else {
            risk = Constants.NORMAL;
        }

        return new CreditCardRiskEntity(item, new Date(), risk);
    }
}
