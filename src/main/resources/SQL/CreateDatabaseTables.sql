drop schema tasty;

create schema if not exists tasty;

use tasty;

create table if not exists `profile`(
id varchar(45) not null,
`password` varchar(45) not null,
`description` text default null,
path_to_profile_photo text default null,
Primary key(id));

create table if not exists `followed_following`(
followed varchar(45) not null,
`following` varchar(45) not null,
Foreign key(followed) references `profile`(id),
Foreign key(`following`) references `profile`(id));

create table if not exists `post`(
id int not null auto_increment,
`description` text not null,
`ingredients` text not null,
`steps` text not null,
`tags` text not null,
`images` text default null,
`added` datetime default null,
`author` varchar(45) not null,
Primary key(`id`));


