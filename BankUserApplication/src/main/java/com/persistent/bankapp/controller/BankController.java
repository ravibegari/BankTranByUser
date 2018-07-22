package com.persistent.bankapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.persistent.bankapp.domain.Bank;
import com.persistent.bankapp.domain.BankMetaData;
import com.persistent.bankapp.service.BankMetaDataService;
import com.persistent.bankapp.service.BankService;
import com.persistent.bankapp.service.UserService;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private UserService userService;

    @Autowired
    private BankService bankService;
    
    @Autowired
    private BankMetaDataService bankMetaDataService;

    @RequestMapping(value = "/listOfBanks", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Bank> getListOfBanks(@RequestHeader(value="username") String sUserName) {

        List<Bank> listOfBanks = new ArrayList<Bank>();
        if (userService.checkUsernameExists(sUserName)) {

                listOfBanks = bankService.findAllBanks();
                return listOfBanks;
        }
        return listOfBanks;

    }

    @RequestMapping(value = "/getMetadataOfBank", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BankMetaData> getMetadataOfBanks(@RequestHeader(value="userName") String sUserName) {

    	List<BankMetaData> bankMetaData = new ArrayList<BankMetaData>();
        if (userService.checkUsernameExists(sUserName)) {
        	
        	bankMetaData = bankMetaDataService.getMetaData();
     }
        return bankMetaData;

    }

    @RequestMapping(value = "/getAccount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAccounts(@RequestHeader(value="userName") String sUserName,
                              @RequestBody HashMap<String,String> bankMetaData
                              ) throws RestClientException, IOException {

        if (userService.checkUsernameExists(sUserName)) {
            String baseUrl = "http://localhost:8070/bank/getAccount";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response=null;
            try{
                response=restTemplate.exchange(baseUrl,HttpMethod.POST, getHeaders(bankMetaData.get("bankId"),bankMetaData.get("Username"),bankMetaData.get("password")),String.class);
            }catch (Exception ex)
            {
                System.out.println(ex);
            }
            return response.getBody();
        }
        return null;

    }

    private static HttpEntity<?> getHeaders(String bankId, String userName, String password) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("bankId", bankId);
        headers.set("userName", userName);
        String plainClientCredentials=userName+":"+password;
        String base64ClientCredentials = new String(Base64.getEncoder().encodeToString(plainClientCredentials.getBytes()));
        headers.add("Authorization", "Basic " + base64ClientCredentials);
        return new HttpEntity<>(headers);
    }
}