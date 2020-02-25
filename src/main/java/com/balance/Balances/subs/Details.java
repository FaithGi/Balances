package com.balance.Balances.subs;

import lombok.Data;

import java.util.List;

@Data
public class Details {

    Allowance allowances;
    List<BalanceAmount> balanceAmount;
}
