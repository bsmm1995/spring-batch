package com.bsmm.springbatch.batch.listener;

import com.bsmm.springbatch.domain.entities.CreditCardEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemReadListener;

@Slf4j
public class CreditCardIItemReaderListener implements ItemReadListener<CreditCardEntity> {

    @Override
    public void beforeRead() {
        log.info("beforeRead");
    }

    @Override
    public void afterRead(CreditCardEntity creditCard) {
        log.info("afterRead: " + creditCard.toString());
    }

    @Override
    public void onReadError(Exception e) {
        log.info("onReadError");
    }
}
