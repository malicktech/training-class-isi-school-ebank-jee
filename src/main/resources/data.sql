INSERT INTO role(name) 
  VALUES
  ('ROLE_ADMIN'),
  ('ROLE_USER'),
  ('ROLE_EMPLOYE'),
  ('ROLE_CAISSIER');
  
INSERT INTO user(id, actif, email, prenom, nom, mot_de_passe) 
  VALUES
  (1, 1, 'test@test.com', 'Prénom Test', 'Nom Test', '$2a$10$b8jR.blm5dQt1HGHr0DVm.3xGP3zkzbcVtDg/PKz0UK9/tg8f6bVe'),
  (2, 1, 'mounasdiop@gmail.com', 'MAIMOUNA', 'DIOP', '$2a$10$b8jR.blm5dQt1HGHr0DVm.3xGP3zkzbcVtDg/PKz0UK9/tg8f6bVe'),
  (3, 1, 'diop-malick@hotmail.fr', 'Client', 'DEUX', '$2a$10$b8jR.blm5dQt1HGHr0DVm.3xGP3zkzbcVtDg/PKz0UK9/tg8f6bVe'),
  (4, 1, 'mdiop.sne@gmail.com', 'Malick', 'DIOP', '$2a$10$b8jR.blm5dQt1HGHr0DVm.3xGP3zkzbcVtDg/PKz0UK9/tg8f6bVe'),
  (5, 1, 'citizenddiop@gmail.com', 'Citizen', 'FOUR', '$2a$10$b8jR.blm5dQt1HGHr0DVm.3xGP3zkzbcVtDg/PKz0UK9/tg8f6bVe'),
  (6, 1, 'caissier1@test.com', 'Awa', 'NDIAYE', '$2a$10$b8jR.blm5dQt1HGHr0DVm.3xGP3zkzbcVtDg/PKz0UK9/tg8f6bVe');
  
INSERT INTO user_role(user_id, role_name) 
  VALUES
  (1, 'ROLE_ADMIN'),
  (2, 'ROLE_USER'),
  (3, 'ROLE_USER'),
  (4, 'ROLE_EMPLOYE'),
  (5, 'ROLE_EMPLOYE'),
  (6, 'ROLE_EMPLOYE'); 
  
INSERT INTO agence(code, region) 
  VALUES
  ('A1', 'Dakar'),
  ('A2', 'St Louis'),
  ('A3', 'Thies');
    
INSERT INTO client(id, code, adresse, employeur, num_cin, profession, raison_social_employe, salaire, telephone)
  VALUES 
  	(2, 'C1', 'Cité des enseignants', 'Dia S', 'CIN0000001',' Dev/CQ', 'DG Commercial', 800000,'776256295'),
  	(3, 'C2', 'Liberté 6', 'Snecommerce', 'CIN0000002','Avocat', 'RSE C1', 100000,'776149662' );
    
INSERT INTO employe(id, code, poste) 
  VALUES 
    (4, 'E01', 'Responsable compte 1'),
    (5, 'E02', 'Responsable compte 2'),
    (6, 'E03', 'Caissière 1');

    
INSERT INTO compte( numero_compte, type_cpte, date_ouverture, etat, solde, frais_ouverture_cb, agios, frais_ouverture_ce, code_agence, code_client, code_employe)
  VALUES 
    ('CC1', 'CC', '2018-07-02 00:00:00', 1,  10, 0, 0, 0, 'A1', 2, 4),
    ('CC2', 'CC', '2018-07-01 00:00:00', 1, 500, 0, 0, 0, 'A2', 3, 5);
    
    INSERT INTO operation(id, date, description, montant_ht, montant_ttc, taxe_operation, raxe_releve, taxe_sms, type_operation, type_transaction, numero_compte, code_employe)
    VALUES
    (1, '2018-07-02 00:00:00', 'operation 1', 10, 11, 1, 0, 0, 'DEPOT', 'CREDIT', 'CC1', 6),
    (2, '2018-07-03 00:00:00', 'operation 2', 10, 10, 0, 0, 0, 'RETRAIT', 'DEBIT', 'CC1', 6),
    (3, '2018-07-03 00:00:00', 'operation 3', 10, 17, 2, 0, 5, 'VIREMENT', 'CREDIT', 'CC2', 5);
    
    
    