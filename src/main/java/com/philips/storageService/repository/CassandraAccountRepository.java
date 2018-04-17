package com.philips.storageservice.repository;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.*;
import com.philips.storageservice.connector.CassandraConnector;
import com.philips.storageservice.model.Account;

public class CassandraAccountRepository implements IAccountRepository{

	static final String KEYSPACE_NAME = "storageservice";
	static final String TABLE_NAME = "account";

	private Session session;

	public CassandraAccountRepository(String KEYSPACE_NAME) {
		this.session = CassandraConnector.GetSession();
		session.execute("USE " + KEYSPACE_NAME);
	}

	/**
     * Select all accounts from account
     * 
     * @return
     */
	@Override
	public List<Account> findAll() {
		StringBuilder sb = 
		new StringBuilder("SELECT * FROM ").append(TABLE_NAME);
   
	  String query = sb.toString();
	  ResultSet rs = session.execute(query);
   
	  List<Account> accounts = new ArrayList<Account>();
   
	  for (Row r : rs) {
		  accounts.add(new Account(
			r.getUUID("accountid").toString(), 
			r.getString("email"),  
			r.getString("firstname"),
			r.getString("lastname")));
	  };
	  return accounts;
	}

	@Override
	public Account findById(String id) {
		return null;
	}

	@Override
	public void save(Account customer) {
		
	}

	@Override
	public void remove(Account customer) {
		
	}

}

/*
@Repository
public interface AccountRepository extends CassandraRepository<Account, MapId>  {
    @Query("select * from account")
    List<Account> findAll();
}*/