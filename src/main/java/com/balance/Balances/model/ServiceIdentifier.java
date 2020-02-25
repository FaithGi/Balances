package com.balance.Balances.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class ServiceIdentifier {

    private String msisdn;


    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }
}
