create table sexe(
    id SERIAL PRIMARY KEY,
    designation VARCHAR(20)
);

create table employe(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(200),
    id_sexe INT,
    FOREIGN KEY(id_sexe) REFERENCES sexe(id)
);