package com.philips.storageservice.factory;

import com.philips.storageservice.repository.IAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public abstract class MetaDataStoreFactory
{
    @Autowired
    private static Environment env;

    public IAccountRepository accountRepository;

    public static MetaDataStoreFactory NewInstance(String metadataStoreType)
    {
        if(metadataStoreType.isEmpty()) { metadataStoreType = env.getProperty("metadataProviderType"); }
        
        switch(metadataStoreType){
            case "Cassandra":{
                return CassandraMetaDataStoreFactory.NewInstance();
            }
            case "PostgreSQL":{
                return null;
                //return PostgreSQLMetaDataStoreFactory.NewInstance();
            }
            default:{
                return null;
            }
        }

    }
}