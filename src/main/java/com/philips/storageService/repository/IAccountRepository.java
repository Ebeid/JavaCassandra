package com.philips.storageservice.repository;

import java.util.List;

import com.philips.storageservice.model.Account;

public interface IAccountRepository
{
    List<Account> findAll();
    Account findById(String id);
    void save(Account customer);
    void remove(Account customer);
}