DROP SCHEMA if exists deltagere cascade;
create schema deltagere;
set search_path to deltagere;


create table deltagere (
    mobil integer primary key,
    passord integer not null,
    fornavn varchar(30),
    etternavn varchar(30),
    kjonn varchar(5)
);