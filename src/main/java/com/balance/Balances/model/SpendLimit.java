package com.balance.Balances.model;

import com.balance.Balances.subs.Details;
import lombok.Data;

@Data
public class SpendLimit {

    private BalanceTypes balancetype;
    private Details details;

}
