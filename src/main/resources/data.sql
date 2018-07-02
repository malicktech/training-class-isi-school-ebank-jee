INSERT INTO role(name) VALUES
  ('ROLE_ADMIN'),
  ('ROLE_USER');
  
  INSERT INTO user(id, activated, email, first_name, last_name, password) VALUES
  (1, 1, 'test@test.com', 'MALICK', 'DIOP', '$2a$10$b8jR.blm5dQt1HGHr0DVm.3xGP3zkzbcVtDg/PKz0UK9/tg8f6bVe'),
  (2, 1, 'mounasdiop@gmail.com', 'MAIMOUNA', 'DIOP', '$2a$10$b8jR.blm5dQt1HGHr0DVm.3xGP3zkzbcVtDg/PKz0UK9/tg8f6bVe');
  
 INSERT INTO user_role(	user_id, role_name) VALUES
  (1, 'ROLE_ADMIN'); 
  
  INSERT INTO agence(id, num_agence, region) VALUES
  (1, 'A1', 'Dakar'),
   (2, 'A2', 'St Louis'),
    (3, 'A3', 'Thies');
    
    INSERT INTO client(adresse, employeur, num_cin, profession, raison_social_employe, salaire, telephone, users_id)
    VALUES ('Cité des enseignants','Dia S',230120071993,'Dev/CQ','DG Commercial',800000,776256295,1);
    
    INSERT INTO employe(code, poste, users_id) VALUES ('E1001', 'Responsable compte', 2);
    /*INSERT INTO compte(type_cpte, id, date_ouverture, etat, numero_compte, solde_compte, frais_ouvcb, agios, frais_ouv_ep, numero_agence, code_client, code_employe) 
    VALUES ('CC',1,02/07/2018,'1','C14568888',10,0,0,0,1,1,1);*/
    
    INSERT INTO compte(type_cpte, id, date_ouverture, etat, numero_compte, solde_compte, frais_ouvcb, agios, frais_ouv_ep, numero_agence, code_client, code_employe)
    VALUES ('CompteC', '3', '2018-07-02 00:00:00', b'1', 'A1C10207SN2018', '10', '0', '0', '0', '1', '1', '2');