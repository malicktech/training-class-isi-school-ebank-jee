package com.examen.GestionBanque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.GestionBanque.dao.AgenceRepository;
import com.examen.GestionBanque.entities.Agence;

@Service
public class AgenceService{ 
		@Autowired
		private AgenceRepository agenceRepository;

		public Agence saveAgence(Agence agence) {
			return agenceRepository.save(agence);
		}

	
}
