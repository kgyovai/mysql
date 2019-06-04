create table test
(
    created_on datetime(6) null,
    id         char(36)    null
);

alter table test
    add constraint test_pk
        primary key (id);