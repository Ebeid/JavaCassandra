package com.philips.storageservice.controller;

import com.philips.storageservice.model.Account;
import com.philips.storageservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @RequestMapping(method=RequestMethod.GET, value="/accounts")
    public Iterable<Account> product() {             
        return accountRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/accounts")
    public String save(@RequestBody Account product) {
        return "DONE";
        //accountRepository.save(product);
        //return product.getId();
    }

    @RequestMapping(method=RequestMethod.GET, value="/accounts/{id}")
    public Account show(@PathVariable String id) {
        return new Account("accountid", "email", "firstName", "lastName");
        //Optional<Account> account = accountRepository.findById(id);
        //return account.isPresent() ? account.get() : null;
    }

    @RequestMapping(method=RequestMethod.PUT, value="/accounts/{id}")
    public Account update(@PathVariable String id, @RequestBody Account account) {
        return new Account("accountid", "email", "firstName", "lastName");
        /*
        Optional<Account> acc = accountRepository.findById(id);
        Account modified = acc.get();
        if(account.getEmail() != null) modified.setEmail(account.getEmail());
        if(account.getFirstname() != null) modified.setFirstname(account.getFirstname());
        if(account.getLastname() != null) modified.setLastname(account.getLastname());

        accountRepository.save(modified);
        return modified;
        */
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/accounts/{id}")
    public String delete(@PathVariable String id) {
        //Optional<Account> acc = accountRepository.findById(id);
        //accountRepository.delete(acc.get());

        return "account deleted";
    }
}