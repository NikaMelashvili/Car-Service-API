create table car (
    car_id bigint primary key auto_increment,
    make varchar(255),
    model varchar(255),
    year int,
    licence_plate varchar(255),
    last_modified_date datetime,
    record_state int,
    create_date datetime,
    latest_service_id bigint,
    latest_provided_service_id bigint
);

create table service (
    service_id bigint primary key auto_increment,
    service_name varchar(255),
    service_description varchar(255),
    price decimal(10, 2),
    latest_car_serviced bigint
);

create table provided_services (
    provided_service_id bigint primary key auto_increment,
    car_id bigint,
    service_id bigint,
    create_date datetime,
    last_modified_date datetime,
    record_state int
);

create table user (
    user_id bigint primary key auto_increment,
    firstName varchar(255),
    lastName varchar(255),
    email varchar(255),
    password varchar(255),
    role varchar(100),
    car_id bigint,
    foreign key (car_id) references car(car_id)
);

-- Adding foreign key constraints after table creation
alter table car
add constraint fk_car_latest_service
foreign key (latest_service_id) references service(service_id),
add constraint fk_car_latest_provided_service
foreign key (latest_provided_service_id) references provided_services(provided_service_id);

alter table service
add constraint fk_service_latest_car_serviced
foreign key (latest_car_serviced) references car(car_id);

alter table provided_services
add constraint fk_provided_services_car
foreign key (car_id) references car(car_id),
add constraint fk_provided_services_service
foreign key (service_id) references service(service_id);
