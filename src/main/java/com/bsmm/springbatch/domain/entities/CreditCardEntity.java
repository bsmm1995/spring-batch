package com.bsmm.springbatch.domain.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "credit_card")
@Data
public class CreditCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cardNumber;
    private Date lastPay;

    @Override
    public String toString() {
        return "CreditCardService{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", lastPay=" + lastPay +
                '}';
    }
}
