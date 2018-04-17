package com.philips.storageservice.connector;

import com.datastax.driver.core.*;
import com.datastax.driver.core.Cluster.Builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class CassandraConnector {
 
    private static Cluster cluster = null; 
    private static Session session = null;
    
    @Autowired
    private static Environment env;


    private CassandraConnector(){}
 
    private static void connect(String node, Integer port) {
        Builder b = Cluster.builder().addContactPoint(node);
        if (port != null) {
            b.withPort(port);
        }
        cluster = b.build();
 
        session = cluster.connect();
    }
 
    public void close() {
        session.close();
        cluster.close();
    }

	public static Session GetSession(String node, Integer port) {
        if(cluster == null)
            connect(node, port);
		return session;
    }
    
    public static Session GetSession() {
        return GetSession(
            "localhost", //env.getProperty("cassandra.contact-points"), 
            9042); //Integer.getInteger(env.getProperty("cassandra.port")));
	}
}