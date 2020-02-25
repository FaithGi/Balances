package com.balance.Balances.subs;

import com.balance.Balances.model.BalanceTypes;
import lombok.Data;

@Data
public class BalanceAmount {

    private BalanceTypes type;
    private String amount;
}
