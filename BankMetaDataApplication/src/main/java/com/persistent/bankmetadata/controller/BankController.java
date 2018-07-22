package com.persistent.bankmetadata.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.persistent.bankmetadata.domain.Bank;
import com.persistent.bankmetadata.domain.User;
import com.persistent.bankmetadata.service.BankService;
import com.persistent.bankmetadata.service.UserService;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private UserService userService;

    @Autowired
    private BankService bankService;

    @RequestMapping(value = "/getAccount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Bank> getListOfTransactions(@RequestHeader(value="bankId") String bankId,
                                     @RequestHeader(value="userName") String userName) {

        List<Bank> listOfTransactions = new ArrayList<Bank>();
        if (userService.checkUsernameExists(userName)) {
            User user = userService.findByUsername(userName);

            listOfTransactions = bankService.findAll().stream()
                    .filter(bank -> bank.getBankId().toString().equals(bankId))
                    .filter(bank -> bank.getUserId().toString().equals(user.getUserId().toString()))
                    .collect(Collectors.toList());

            return listOfTransactions;
        }
        return listOfTransactions;
    }


}

