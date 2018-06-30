package com.examen.GestionBanque.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.GestionBanque.entities.User;

/**
 * Spring Data JPA repository for the User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	Optional<User> findOneByEmailIgnoreCase(String email);
}
