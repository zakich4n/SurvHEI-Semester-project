 
create table survhei_user (
    IDUser int AUTO_INCREMENT not null PRIMARY key, User varchar(80) not null, Password text not null, DateCreation date not null default CURRENT_DATE, Email varchar(80) not null, Nom varchar(80) not null, Prenom varchar(80) not null, DateNaissance date not null, Sexe varchar(80) not null, IsAdmin boolean not null) engine=innodb;

create table formulaire (
    IDFormulaire int AUTO_INCREMENT not null primary key, NomFormulaire varchar(80) not null, NombreDeQuestion int not null, TempsMoyen int not null, Desactive boolean not null, QuestionBrut text not null, Anonyme boolean not null, IDUserCreator int not null, foreign key (IDUserCreator) references survhei_user(IDUser)) engine=innodb;

create table completer (
    IDUser int not null, IDFormulaire int not null, DateReponse date not null default CURRENT_DATE, primary key (IDUSer, IDFormulaire)) engine=innodb;

create table editer (
    IDUser int not null, IDFormulaire int not null, DateEdit date not null default CURRENT_DATE, primary key (IDUser, IDFormulaire)) engine = innodb;

create table supprimer (
    IDUser int not null, IDFormulaire int not null, DateDelete date not null default CURRENT_DATE, primary key (IDUser, IDFormulaire)) engine = innodb;

insert into survhei_user (User, Password, Email, Nom, Prenom, DateNaissance, Sexe, IsAdmin) values ('user', 'password', 'prenom.nom@student.junia.com','Nom', 'Prenom',  str_to_date('2000-00-00','%Y-%m-%d'), 'm', true);

insert into formulaire (NomFormulaire, NombreDeQuestion, TempsMoyen, Desactive, QuestionBrut, Anonyme, IDUserCreator) values ('Survhei', 3, 1, false, 'Quel est ton domaine HEI?; Quel est ton futur métier?; Est-ce que tu y crois ?;', true, 1);

insert into completer (IDUser, IDFormulaire) values (1,1);
insert into editer (IDUser, IDFormulaire) values (1,1);
insert into supprimer (IDUser, IDFormulaire) values (1,1);


insert into survhei_user (User, Password, Email, Nom,Prenom, DateNaissance, Sexe, IsAdmin) values ('User2', '$argon2i$v=19$m=65536,t=5,p=1$NPcCW/vkmQBZXAmJIW4osHPM1hPGkOtOD4xfGdEDyvh5bXculrXy+uk+niwsOI23y7gD1f31AzBaTzaF5PL6I9kaOe993pN332x6fUhF115heSoadb6ApUj+mMwCqCSmbo7D0lZEW1UVam1PO26+gkz3d6CVnfTJFZcPtwqmHhE$HTlOdExiw4ndF5+rCoa9PLqV859kzwEG3nNKAPWy+wFEehOQC6X8JwLGOJ0QcAAqUXPsobNTxnp02l4/VHI3q/x481wo0l4V2mTb1KOulbZkZmPLdASGaknZ950VHkajzNfMouiyqBhDR/PeqWgVsggyT/nxDhMbSAq0n1cn4iY', 'user.nom@student.junia.com', 'Nom', 'Prenom', str_to_date('2000-00-00','%Y-%m-%d'), 'm', true);