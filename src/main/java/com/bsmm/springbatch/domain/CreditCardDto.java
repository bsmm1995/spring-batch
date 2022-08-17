package com.bsmm.springbatch.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CreditCardDto {
    private Long id;
    private Long cardNumber;
    private Date lastPay;
}
