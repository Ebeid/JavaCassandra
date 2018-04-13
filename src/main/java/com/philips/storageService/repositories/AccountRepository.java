package com.philips.storageService.repositories;

import java.util.Optional;

import com.philips.storageService.models.Account;

import org.springframework.data.repository.CrudRepository;
 
public interface AccountRepository extends CrudRepository<Account, String> {
    @Override
    Optional<Account> findById(String id) ;

    @Override
    Iterable<Account> findAll();

    @Override
    void delete(Account deleted);
}