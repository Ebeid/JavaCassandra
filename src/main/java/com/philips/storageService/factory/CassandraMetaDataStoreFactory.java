package com.philips.storageservice.factory;

import com.philips.storageservice.repository.CassandraAccountRepository;


public class CassandraMetaDataStoreFactory extends MetaDataStoreFactory{

    private static CassandraMetaDataStoreFactory cassandraMetaDataStoreInstance = null;

    protected CassandraMetaDataStoreFactory(){
    }

	public static CassandraMetaDataStoreFactory NewInstance() {
        if(cassandraMetaDataStoreInstance == null){ 
            cassandraMetaDataStoreInstance = new CassandraMetaDataStoreFactory();
        }

        // TODO: KEYSPACE_NAME should be config driven
        cassandraMetaDataStoreInstance.accountRepository = new CassandraAccountRepository("storageservice");
		return cassandraMetaDataStoreInstance;
	}
}