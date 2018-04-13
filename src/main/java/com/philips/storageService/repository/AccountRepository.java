package com.philips.storageservice.repository;

import java.util.List;

import com.philips.storageservice.model.Account;

import org.springframework.data.cassandra.core.mapping.MapId;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CassandraRepository<Account, MapId>  {
    //@Override


    @Query("select * from account")
    List<Account> findAll();

    //@Override
    //void delete(Account deleted);
}