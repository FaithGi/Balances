package com.balance.Balances.model;

import com.balance.Balances.subs.Details;
import com.balance.Balances.subs.ValidityPeriod;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class Mpesa
{
        private String type;
        private String name;
        private String desc;
        ValidityPeriod ValidityPeriodObject;
        Details DetailsObject;

}
