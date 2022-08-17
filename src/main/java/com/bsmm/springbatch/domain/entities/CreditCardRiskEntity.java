package com.bsmm.springbatch.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class CreditCardRiskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private int risk;

    @OneToOne(optional = false)
    private CreditCardEntity creditCard;

    public CreditCardRiskEntity() {
    }

    public CreditCardRiskEntity(CreditCardEntity creditCard, Date date, int risk) {
        this.creditCard = creditCard;
        this.date = date;
        this.risk = risk;
    }

    @Override
    public String toString() {
        return "CreditCardRiskEntity{" +
                "id=" + id +
                ", date=" + date +
                ", risk=" + risk +
                '}';
    }
}
