INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
              
                            
INSERT INTO reprezentacija (naziv, skraceni_naziv) VALUES ('Serbia', 'SRB');
INSERT INTO reprezentacija (naziv, skraceni_naziv) VALUES ('Croatia', 'CRO');
INSERT INTO reprezentacija (naziv, skraceni_naziv) VALUES ('United State of America', 'USA');
INSERT INTO reprezentacija (naziv, skraceni_naziv) VALUES ('Canada', 'CAN');
INSERT INTO reprezentacija (naziv, skraceni_naziv) VALUES ('Montenegro', 'MNE');
INSERT INTO reprezentacija (naziv, skraceni_naziv) VALUES ('Great Britan', 'GBR');

INSERT INTO igrac (ime, prezime, postignuti_golovi, reprezentacija_id) VALUES ('Goran', 'Goranovic', '2', 2);
INSERT INTO igrac (ime, prezime, postignuti_golovi, reprezentacija_id) VALUES ('Milan', 'Goranovic', '1', 2);
INSERT INTO igrac (ime, prezime, postignuti_golovi, reprezentacija_id) VALUES ('Dragan', 'Goranovic', '2', 1);
INSERT INTO igrac (ime, prezime, postignuti_golovi, reprezentacija_id) VALUES ('Marko', 'Goranovic', '7', 4);
INSERT INTO igrac (ime, prezime, postignuti_golovi, reprezentacija_id) VALUES ('Milutin', 'Goranovic', '2', 3);
INSERT INTO igrac (ime, prezime, postignuti_golovi, reprezentacija_id) VALUES ('Dejan', 'Goranovic', '3', 5);
INSERT INTO igrac (ime, prezime, postignuti_golovi, reprezentacija_id) VALUES ('Miodrag', 'Goranovic', '2', 6);
INSERT INTO igrac (ime, prezime, postignuti_golovi, reprezentacija_id) VALUES ('Pavle', 'Goranovic', '2', 3);

INSERT INTO utakmica (golovia, golovib, reprezentacijaa_id, reprezentacijab_id) VALUES ('3', '2', 1, 2);
INSERT INTO utakmica (golovia, golovib, reprezentacijaa_id, reprezentacijab_id) VALUES ('1', '2', 3, 4);
INSERT INTO utakmica (golovia, golovib, reprezentacijaa_id, reprezentacijab_id) VALUES ('4', '2', 6, 5);

