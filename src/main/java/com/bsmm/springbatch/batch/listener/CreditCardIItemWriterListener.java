package com.bsmm.springbatch.batch.listener;

import com.bsmm.springbatch.domain.entities.CreditCardRiskEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

@Slf4j
public class CreditCardIItemWriterListener implements ItemWriteListener<CreditCardRiskEntity> {
    @Override
    public void beforeWrite(List<? extends CreditCardRiskEntity> list) {
        log.info("beforeWrite");
    }


    @Override
    public void afterWrite(List<? extends CreditCardRiskEntity> list) {
        for (CreditCardRiskEntity creditCardRisk : list) {
            log.info("afterWrite :" + creditCardRisk.toString());
        }
    }

    @Override
    public void onWriteError(Exception e, List<? extends CreditCardRiskEntity> list) {
        log.info("onWriteError");
    }
}
