create table log (id  bigserial not null, description varchar(255), event_date timestamp, log_event varchar(255), origin varchar(255), title varchar(255), id_user int8, primary key (id))
create table user (id  bigserial not null, email varchar(255) not null, name varchar(100) not null, password varchar(255) not null, token_access varchar(255) not null, primary key (id))
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table log add constraint FK5gubxorqcveqb7xjcc7xkbwv3 foreign key (id_user) references user
create table log (id  bigserial not null, description varchar(255), event_date timestamp, log_event varchar(255), origin varchar(255), title varchar(255), id_user int8, primary key (id))
create table user (id  bigserial not null, email varchar(255) not null, name varchar(100) not null, password varchar(255) not null, token_access varchar(255) not null, primary key (id))
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table log add constraint FK5gubxorqcveqb7xjcc7xkbwv3 foreign key (id_user) references user
create table log (id  bigserial not null, description varchar(255), event_date timestamp, log_event varchar(255), origin varchar(255), title varchar(255), id_user int8, primary key (id))
create table user (id  bigserial not null, email varchar(255) not null, name varchar(100) not null, password varchar(255) not null, token_access varchar(255) not null, primary key (id))
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table log add constraint FK5gubxorqcveqb7xjcc7xkbwv3 foreign key (id_user) references user
