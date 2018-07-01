INSERT INTO role(name) VALUES
  ('ROLE_ADMIN'),
  ('ROLE_USER');
  
  INSERT INTO user(id, activated, email, first_name, last_name, password) VALUES
  (1, 1, 'test@test.com', 'MALICK', 'DIOP', '$2a$10$b8jR.blm5dQt1HGHr0DVm.3xGP3zkzbcVtDg/PKz0UK9/tg8f6bVe');
  
 INSERT INTO user_role(	user_id, role_name) VALUES
  (1, 'ROLE_ADMIN'); 
  
  INSERT INTO agence(id, num_agence, region) VALUES
  (1, 'A1', 'Dakar'),
   (2, 'A2', 'St Louis'),
    (3, 'A3', 'Thies');