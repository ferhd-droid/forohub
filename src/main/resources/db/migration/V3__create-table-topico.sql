create table topico (
  id bigint(20) NOT NULL auto_increment,
  titulo varchar(100) not null,
  mensaje varchar(100) not null,
  idUsuario bigint(20) NOT NULL,
  fechaCreacion datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  status varchar(20) not null DEFAULT 'OK',
  nombreCurso varchar(100) not null,
  primary key (id),
  constraint fk_topico_usuario_id foreign key (idUsuario) references usuario (id)
)