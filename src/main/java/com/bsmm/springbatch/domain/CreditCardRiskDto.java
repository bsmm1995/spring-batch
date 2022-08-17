package com.bsmm.springbatch.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CreditCardRiskDto {
    private Long id;
    private Date date;
    private int risk;
}
