package com.balance.Balances.resources;

import com.balance.Balances.model.*;
import com.balance.Balances.subs.*;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Service-Balances")
public class ServiceBalance{





    @Autowired()
     Bundle bundle; Mpesa mpesa; ;

    @GetMapping ("/getAirtimeBalance")
    @ApiParam(required = true)
    public List AirtimeBalances(@RequestParam("Msisdn") @Min(value = 12 ,message = "Enter Full Tanzanian(+256) PhoneNumber") @Max(value = 12 , message = "Enter Full Tanzanian(+256) PhoneNumber") String msisdn ) {

        Id id = new Id();
        ServiceIdentifier serviceIdentifier = new ServiceIdentifier();
        List returnBalance = new ArrayList<Airtime>();
        ValidityPeriod validityPeriod = new ValidityPeriod();

        Airtime airtime = new Airtime();

        serviceIdentifier.setMsisdn(msisdn);
        id.setBalanceType(BalanceTypes.valueOf("Airtime"));

        if(serviceIdentifier.getMsisdn().matches("^[0-9]*$")){

            if(serviceIdentifier.getMsisdn().length() == 12){

                Date date = new Date();
                Details details = new Details();
                details.setAllowances(constructResponse());
                details.setBalanceAmount (consctructResponse(id.getBalanceType(),"200"));
                ToDate toDate = new ToDate ();
                toDate.setDateString(date);
                airtime.setMsisdn(serviceIdentifier.getMsisdn());
                airtime.setName("MainAccount");
                airtime.setType(id.getBalanceType());
                validityPeriod.setToDate(toDate);
                airtime.setValidityPeriod(validityPeriod);
                airtime.setDetails(details);

                returnBalance.add(airtime);

            }else {

                    System.out.println("Please Enter Correct Tanzanian PhoneNumber with Length of 12 " + serviceIdentifier.getMsisdn());
                }
            } else {

             System.out.println("Please use digits/numbers");
           }


        return returnBalance;
     }

    @GetMapping ("/getMpesaBalance")
    @ApiParam(required = true)
    public List MpesaBalance(@RequestParam BundleTypes balanceTypes ,@RequestParam("Msisdn") @Min(value = 12 ,message = "Enter Full Tanzanian(+256) PhoneNumber") @Max(value = 12 , message = "Enter Full Tanzanian(+256) PhoneNumber") String msisdn) {

        List returnBalance = new ArrayList<Airtime>();

        Id id = new Id();

           if(balanceTypes.name().equalsIgnoreCase("bundlesConsolidated")) {

               Bundle bundle = new Bundle();
               Details details = new Details();

                        bundle.setType(balanceTypes.name());
                       // bundle.setBalanceAmount(consctructResponse(id.getBalanceType(),"200"));
                        returnBalance.add(bundle);

            }
             else if(balanceTypes.name().equalsIgnoreCase("bundlesDetailed"))
            {

            }
            else if(balanceTypes.name().equalsIgnoreCase("bundlesConsolidatedType")){

            }
            else if(balanceTypes.name().equalsIgnoreCase("mpesa") ) {

           }

              returnBalance.add(mpesa);

        return returnBalance;
    }

    @GetMapping ("/getSpendLimitBalance")
    public List SpendListBalance(@RequestParam("Msisdn") @Min(value = 12 ,message = "Enter Full Tanzanian(+256) PhoneNumber") @Max(value = 12 , message = "Enter Full Tanzanian(+256) PhoneNumber") String msisdn ){

             Id id = new Id();
             ServiceIdentifier serviceIdentifier = new ServiceIdentifier();
             List returnBalance = new ArrayList<SpendLimit>();

            serviceIdentifier.setMsisdn(msisdn);
            id.setBalanceType(BalanceTypes.valueOf("SpendLimit"));

            SpendLimit spendLimit = new SpendLimit();

            Details details = new Details();
            details.setBalanceAmount(consctructResponse(id.getBalanceType(),"97531"));
            spendLimit.setBalancetype(id.getBalanceType());
            spendLimit.setDetails(details);

            returnBalance.add(spendLimit);

             return returnBalance;
        }

    private List<BalanceAmount> consctructResponse(BalanceTypes type , String amount)
    {
        BalanceAmount balanceAmount = new BalanceAmount ();
        balanceAmount.setType (type);
        balanceAmount.setAmount (amount);
        List<BalanceAmount> balanceAmounts = new ArrayList<> ();
        balanceAmounts.add (balanceAmount);

        return balanceAmounts;
    }

    private List<BalanceAmountString> consctructResponseBundle(String type , String amount)
    {
        BalanceAmountString balanceAmount = new BalanceAmountString ();
        balanceAmount.setType(type);
        balanceAmount.setAmount (amount);
        List<BalanceAmountString> balanceAmounts = new ArrayList<> ();
        balanceAmounts.add (balanceAmount);
        return balanceAmounts;
    }
    private Allowance constructResponse()
    {
        Allowance allowance = new Allowance ();
        allowance.setUsedAllowance("150");
        allowance.setAvailableAllowance ("1");
        return allowance;
    }


}
