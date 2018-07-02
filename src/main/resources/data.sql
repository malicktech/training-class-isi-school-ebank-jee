INSERT INTO role(name) 
  VALUES
  ('ROLE_ADMIN'),
  ('ROLE_USER'),
  ('ROLE_EMPLOYEE');
  
INSERT INTO user(id, actif, email, prenom, nom, mot_de_passe) 
  VALUES
  (1, 1, 'test@test.com', 'Prénom Test', 'Nom Test', '$2a$10$b8jR.blm5dQt1HGHr0DVm.3xGP3zkzbcVtDg/PKz0UK9/tg8f6bVe'),
  (2, 1, 'mounasdiop@gmail.com', 'MAIMOUNA', 'DIOP', '$2a$10$b8jR.blm5dQt1HGHr0DVm.3xGP3zkzbcVtDg/PKz0UK9/tg8f6bVe'),
  (3, 1, 'mdiop.sne@gmail.com', 'Malick', 'DIOP', '$2a$10$b8jR.blm5dQt1HGHr0DVm.3xGP3zkzbcVtDg/PKz0UK9/tg8f6bVe');
  
INSERT INTO user_role(user_id, role_name) 
  VALUES
  (1, 'ROLE_ADMIN'),
  (2, 'ROLE_USER'),
  (3, 'ROLE_EMPLOYEE'); 
  
INSERT INTO agence(code, region) 
  VALUES
  ('A1', 'Dakar'),
  ('A2', 'St Louis'),
  ('A3', 'Thies');
    
INSERT INTO client(code, adresse, employeur, num_cin, profession, raison_social_employe, salaire, telephone, users_id)
  VALUES ('C01', 'Dakar, Cité des enseignants', 'Dia S', '230120071993',' Dev/CQ', 'DG Commercial', 800000,'776256295' , 2);
    
INSERT INTO employe(code, poste, users_id) 
  VALUES 
    ('E01', 'Responsable compte', 3);

    
INSERT INTO compte( id, type_cpte, date_ouverture, etat, numero_compte, solde, frais_ouverture_cb, agios, frais_ouverture_ce, code_agence, code_client, code_employe)
  VALUES 
    (3, 'CC', '2018-07-02 00:00:00', 1, 'CC1', 10, 0, 0, 0, 'A1', 2, 3);