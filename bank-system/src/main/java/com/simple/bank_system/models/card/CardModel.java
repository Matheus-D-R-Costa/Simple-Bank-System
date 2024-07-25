package com.simple.bank_system.models.card;

import com.simple.bank_system.models.account.AccountModel;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "cards")
public class CardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String number;

    @Column(precision = 13, scale = 2)
    private BigDecimal CardLimit;

    @ManyToOne
    @JoinColumn(name = "AccountId")
    private AccountModel account;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getCardLimit() {
        return CardLimit;
    }

    public void setCardLimit(BigDecimal CardLimit) {
        this.CardLimit = CardLimit;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }
}
