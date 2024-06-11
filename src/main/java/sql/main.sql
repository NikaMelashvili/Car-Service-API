create database car_service;

use car_service;

create table car(
    car_id bigint primary key auto_increment,
    make varchar(255),
    model varchar(255),
    year int,
    licence_plate varchar(255),
    service_id bigint,
    foreign key (service_id) references service(service_id)
);

create table service(
    service_id bigint primary key auto_increment,
    service_name varchar(255),
    service_description varchar(255),
    price decimal
);

create table provided_services(
    provided_service_id bigint primary key auto_increment,
    car bigint,
    service bigint,
    create_date datetime,
    last_modified_date datetime,
    record_state int,
    foreign key (car) references car(car_id),
    foreign key (service) references service(service_id)
);

alter table car
    add created_date datetime after licence_plate;

alter table car
    add last_modified_date datetime after created_date;

alter table car
    add record_state int after last_modified_date;

UPDATE car SET created_date = CURRENT_TIMESTAMP WHERE created_date IS NOT NULL;

alter table service
add constraint fk_car_id
foreign key (latest_car_serviced) references car(car_id);

UPDATE car
SET record_state = 1
WHERE car_id = 4;

alter table car
    add constraint fk_provided_service_id
        foreign key (latest_provided_service_id) references provided_services (provided_service_id);