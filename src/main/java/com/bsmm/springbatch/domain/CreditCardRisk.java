package com.bsmm.springbatch.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class CreditCardRisk {
    public static final int HIGH = 3;
    public static final int LOW = 2;
    public static final int NORMAL = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private int risk;

    @OneToOne(optional = false)
    private CreditCard creditCard;

    public CreditCardRisk() {
    }

    public CreditCardRisk(CreditCard creditCard, Date date, int risk) {
        this.creditCard = creditCard;
        this.date = date;
        this.risk = risk;
    }

    @Override
    public String toString() {
        return "CreditCardRisk{" +
                "id=" + id +
                ", date=" + date +
                ", risk=" + risk +
                '}';
    }
}
