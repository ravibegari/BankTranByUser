package com.persistent.bankmetadata.domain;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="account_tran_details")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tran_id", nullable = false, updatable = false)
    private Long transactionId;
    private Long userId;
    private Long accountId;
    private Long bankId;
    private String accountType;
    private BigDecimal account_balance;

    public Long getTranId() {
        return transactionId;
    }

    public void setTranId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(BigDecimal account_balance) {
        this.account_balance = account_balance;
    }
}

