package com.examen.GestionBanque.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.examen.GestionBanque.configuration.security.RolesConstants;
import com.examen.GestionBanque.dao.RoleRepository;
import com.examen.GestionBanque.dao.UserRepository;
import com.examen.GestionBanque.entities.Role;
import com.examen.GestionBanque.entities.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User saveUser(User user) {
		user.setMotDePasse(passwordEncoder.encode(user.getMotDePasse()));
		user.setActif(true);

		Set<Role> roles = new HashSet<>();
		roleRepository.findById(RolesConstants.ADMIN).ifPresent(roles::add);
		user.setRoles(roles);

		System.out.println("Utilisateur à enregistrer = ");
		System.out.println(user);

		User registeredUser = userRepository.save(user);

		System.out.println("Utilisateur enregistré = ");
		System.out.println(registeredUser);

		return registeredUser;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

}
