--liquibase formatted sql

--changeset AndreyPechterev:create-twitter-subscriptions-table
--comment create twitter.subscriptions table
create table twitter.subscriptions
(
    id serial primary key ,
    follower_id integer not null,
    followed_id integer not null,
    created_timestamp timestamp not null
);
--rollback drop table schema subscriptions;


--changeset AndreyPechterev:add-twitter-subscriptions-table-constraints
--comment add constraints twitter.subscriptions table
alter table twitter.subscriptions
    add constraint subscriptions__follower__fk
        foreign key (follower_id) references twitter.user_profiles (id);

alter table twitter.subscriptions
    add constraint subscriptions__followed__fk
        foreign key (followed_id) references twitter.user_profiles (id);

alter table twitter.subscriptions
    add constraint subscriptions__relationship__unique
        unique (follower_id,followed_id);
--rollback alter table twitter.subscriptions drop constraint subscriptions__follower__fk;
--rollback alter table twitter.subscriptions drop constraint subscriptions__followed__fk;
--rollback alter table twitter.subscriptions drop constraint subscriptions__relationship__unique;