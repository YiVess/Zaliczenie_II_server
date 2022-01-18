drop schema tasty;

create schema if not exists tasty;

use tasty;

create table if not exists `profile`(
id varchar(45) not null,
`password` varchar(45) not null,
Primary key(id));

create table if not exists `profile_data`(
id varchar(45) not null,
`description` text default null,
path_to_profile_photo text default null,
Primary key(id));

create table if not exists `followed_following`(
followed varchar(45) not null,
`following` varchar(45) not null,
Foreign key(followed) references `profile_data`(id),
Foreign key(`following`) references `profile_data`(id));