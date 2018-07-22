package com.persistent.bankapp.domain;

import javax.persistence.*;

@Entity
@Table(name="user_banks")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bank_id", nullable = false, updatable = false)
    private Long bankId;
    private String bankName;


    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
