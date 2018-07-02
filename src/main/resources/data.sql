INSERT INTO role(name) 
  VALUES
  ('ROLE_ADMIN'),
  ('ROLE_USER');
  ('ROLE_EMPLOYEE');
  
INSERT INTO user(id, aftif, email, prenom, nom, mot_de_passe) 
  VALUES
  (1, 1, 'test@test.com', 'Prénom Test', 'Nom Test', '$2a$10$b8jR.blm5dQt1HGHr0DVm.3xGP3zkzbcVtDg/PKz0UK9/tg8f6bVe'),
  (2, 1, 'mounasdiop@gmail.com', 'MAIMOUNA', 'DIOP', '$2a$10$b8jR.blm5dQt1HGHr0DVm.3xGP3zkzbcVtDg/PKz0UK9/tg8f6bVe');
  (3, 1, 'mdiop.sne@gmail.com', 'Malick', 'DIOP', '$2a$10$b8jR.blm5dQt1HGHr0DVm.3xGP3zkzbcVtDg/PKz0UK9/tg8f6bVe');
  
INSERT INTO user_role(	user_id, role_name) 
  VALUES
  (1, 'ROLE_ADMIN'),
  (2, 'ROLE_USER'),
  (3, 'ROLE_EMPLOYEE'); 
  
INSERT INTO agence(id, num_agence, region) 
  VALUES
  (1, 'A1', 'Dakar'),
  (2, 'A2', 'St Louis'),
  (3, 'A3', 'Thies');
    
INSERT INTO client(id, adresse, employeur, num_cin, profession, raison_social_employe, salaire, telephone, users_id)
  VALUES (2, 'Dakar, Cité des enseignants', 'Dia S', '230120071993',' Dev/CQ', 'DG Commercial', 800000,'776256295' , 2);
    
INSERT INTO employe(id, code, poste, users_id) 
  VALUES 
    (3, 'E1001', 'Responsable compte', 3);

    
INSERT INTO compte(type_cpte, id, date_ouverture, etat, numero_compte, solde_compte, frais_ouvcb, agios, frais_ouv_ep, numero_agence, code_client, code_employe)
  VALUES 
    ('CC', '3', '2018-07-02 00:00:00', b'1', 'A1C10207SN2018', '10', '0', '0', '0', '1', '1', '2');