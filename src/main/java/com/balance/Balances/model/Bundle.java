package com.balance.Balances.model;

import com.balance.Balances.subs.BalanceAmount;
import org.springframework.stereotype.Component;

@Component
public class Bundle {

    private  String msisdn;
    private String name;
    private String type;
    private String desc;
    private String availableBalance;
    private BalanceAmount balanceAmount;

    public Bundle() {
    }

    public Bundle(String type , BalanceAmount balanceAmount) {
        this.type = type;
        this.balanceAmount = balanceAmount;
    }

    public Bundle(String msisdn, String name, String type, String desc, String availableBalance) {
        this.msisdn = msisdn;
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.availableBalance = availableBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

}
