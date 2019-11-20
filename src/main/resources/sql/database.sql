CREATE SCHEMA IF NOT EXISTS crm DEFAULT CHARACTER SET utf8;
USE crm;

create table customers
(
    id            int auto_increment comment 'Klucz główny tabeli.'
        primary key,
    first_name    varchar(245) null comment 'Imię',
    last_name     varchar(245) null comment 'Nazwisko',
    date_of_birth date         null
)
    comment 'Tabela zawierająca dane klientów';

create table employees
(
    id            int auto_increment comment 'Klucz główny tabeli.'
        primary key,
    first_name    varchar(245)  null comment 'Imię',
    last_name     varchar(245)  null comment 'Nazwisko',
    address       text          null comment 'Dane adresowe',
    telephone     varchar(15)   null comment 'Numer telefonu',
    note          text          null comment 'Notatka',
    man_hour_cost decimal(5, 2) null comment 'Koszt roboczogodziny.'
)
    comment 'Tabela zawierająca dane pracowników';

create table statuses
(
    id   int auto_increment comment 'Klucz główny tabeli.'
        primary key,
    name varchar(245) null comment 'Imię'
)
    comment 'Tabela zawierająca status naprawy';

create table vehicles
(
    id                  int auto_increment comment 'Klucz główny tabeli.'
        primary key,
    model               varchar(245) null comment 'Model',
    brand               varchar(245) null comment 'Marka',
    year_of_production  year         null,
    registration_number varchar(7)   null comment 'Numer rejestracyjny',
    next_service        date         null,
    customer_id         int          not null,
    constraint vehicles_ibfk_1
        foreign key (customer_id) references customers (id)
)
    comment 'Tabela zawierająca dane pojazdów';

create table orders
(
    id                     int auto_increment comment 'Klucz główny tabeli.'
        primary key,
    repair_acceptance_date date          null,
    planned_repair_start   date          null,
    repair_start           date          null,
    problem_description    text          null comment 'Opis problemu',
    repair_description     text          null comment 'Opis naprawy',
    customer_cost          decimal(7, 2) null comment 'Koszt dla klienta.',
    spareparts_cost        decimal(7, 2) null comment 'Koszt wykorzystanych części',
    man_hour_cost          decimal(5, 2) null,
    man_hour_amount        int           null,
    customer_id            int           not null,
    employee_id            int           null,
    vehicle_id             int           null,
    status_id              int           null,
    constraint orders_ibfk_1
        foreign key (customer_id) references customers (id),
    constraint orders_ibfk_2
        foreign key (employee_id) references employees (id),
    constraint orders_ibfk_3
        foreign key (vehicle_id) references vehicles (id),
    constraint orders_ibfk_4
        foreign key (status_id) references statuses (id)
)
    comment 'Tabela zawierająca dane zleceń';

create index customer_id
    on orders (customer_id);

create index employee_id
    on orders (employee_id);

create index status_id
    on orders (status_id);

create index vehicle_id
    on orders (vehicle_id);

create index customer_id
    on vehicles (customer_id);

