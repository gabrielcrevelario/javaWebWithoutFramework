create database crud;
use crud;
create database `usuario` (
`id` int primary key  AUTO_INCREMENT,
`nome` varchar(50) not null,
`sobrenome` varchar(50) not null,
`email` varchar(150) not null,
`senha` varchar(20) not null
)ENGINE=InnoDB 