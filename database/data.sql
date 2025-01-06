insert into sexe (designation) values 
    ('Homme'),
    ('Femme');

insert into employe (nom, id_sexe) values
    ('Rakoto', '1'),
    ('Ravao', '2'),
    ('Rasoa', '2');

ALTER SEQUENCE sexe_id_seq RESTART WITH 1;
ALTER SEQUENCE employe_id_seq RESTART WITH 1;
