create table usuario(
  id bigint(20) not null auto_increment,
  nombre varchar(100) not null,
  email varchar(100) unique not null,
  passwd varchar(300) not null,
  primary key (id)
)