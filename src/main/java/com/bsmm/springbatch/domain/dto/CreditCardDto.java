package com.bsmm.springbatch.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CreditCardDto {
    private Long id;
    private Long cardNumber;
    private Date lastPay;
}
