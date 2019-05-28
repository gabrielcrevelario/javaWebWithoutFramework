Para usar bastar clonar o projeto em uma pasta local pelo cmd digite git clone e o endereço do projeto
as bibliotecas estão no arquivo zipado, elas são o jstl e o mysql connector lembrando que para fazer o projeto funcionar deve-se criar 
create database crud;
use crud;
create database `usuario` (
`id` int primary key  AUTO_INCREMENT,
`nome` varchar(50) not null,
`sobrenome` varchar(50) not null,
`email` varchar(150) not null,
`senha` varchar(20) not null
)ENGINE=InnoDB 

o servidor que eu ultizei foi o tomcat mas vai da preferencia de cada um.
