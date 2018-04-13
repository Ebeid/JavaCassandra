CREATE KEYSPACE IF NOT EXISTS storageservice WITH replication = {'class': 'NetworkTopologyStrategy', 'datacenter1': '1'}  AND durable_writes = true;

CREATE TABLE IF NOT EXISTS storageservice.accounts (
    accountrid UUID,
    email varchar,
    firstname varchar,
    lastname varchar,
    primary key((accountrid))
);

CREATE TABLE IF NOT EXISTS storageservice.buckets (
    bucketid UUID,
    accountid varchar,
    containername varchar,
    primary key((bucketid))
);

CREATE TABLE IF NOT EXISTS storageservice.objects (
    objectid UUID,
    bucketid varchar,
    objectlocation varchar,
    objectname varchar,
    primary key((objectid))
);