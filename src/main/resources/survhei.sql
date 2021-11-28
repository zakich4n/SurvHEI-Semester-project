create table survhei_user (
                              IDUser int AUTO_INCREMENT not null PRIMARY key,
                              User varchar(80) not null,
                              Password text not null,
                              DateCreation date not null default CURRENT_DATE,
                              Email varchar(80) not null,
                              Nom varchar(80) not null,
                              Prenom varchar(80) not null,
                              DateNaissance datetime not null,
                              Sexe varchar(80) not null,
                              IsAdmin boolean default null) engine=innodb;



create table formulaire (
                            id_formulaire  int auto_increment primary key not null,
                            nom_formulaire varchar(80) not null,
                            nombre_de_question int not null,
                            temps_moyen int not null,
                            actif boolean not null,
                            anonyme boolean not null,
                            id_user_createur int not null, foreign key (id_user_createur) references survhei_user(IDUser))engine=innodb;


create table Question (
                          id_question int auto_increment primary key not null,
                          question varchar(80) not null,
                          obligatoire boolean not null,
                          id_formulaire_correspondant int not null, foreign key (id_formulaire_correspondant) references formulaire( 	id_formulaire))engine=innodb;


create table Reponse (
                         id_question int not null,
                         id_user int not null,
                         reponse_oui_non boolean not null,
                         primary key (id_question, id_user),
                         foreign key (id_question) references question(id_question),
                         foreign key (id_user) references survhei_user(IDUser))engine=innodb;