package com.balance.Balances.model;


import com.balance.Balances.subs.Allowance;
import com.balance.Balances.subs.Details;
import com.balance.Balances.subs.ValidityPeriod;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class Airtime {


    private String msisdn;
    private String name;
    private BalanceTypes type;
    private ValidityPeriod validityPeriod;
    private Details details;


}
