--liquibase formatted sql

--changeset AndreyPechterev:create-twitter-schema
--comment create new schema
create schema twitter;
--rollback drop table schema twitter;

