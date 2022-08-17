package com.bsmm.springbatch.batch.listener;

import com.bsmm.springbatch.domain.entities.CreditCardEntity;
import com.bsmm.springbatch.domain.entities.CreditCardRiskEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemProcessListener;

@Slf4j
public class CreditCardItemProcessListener implements ItemProcessListener<CreditCardEntity, CreditCardRiskEntity> {
    @Override
    public void beforeProcess(CreditCardEntity creditCard) {
        log.info("beforeProcess");
    }

    @Override
    public void afterProcess(CreditCardEntity creditCard, CreditCardRiskEntity creditCardRisk) {
        log.info("afterProcess: " + creditCard + " ---> " + creditCardRisk);
    }

    @Override
    public void onProcessError(CreditCardEntity creditCard, Exception e) {
        log.info("onProcessError");
    }
}
