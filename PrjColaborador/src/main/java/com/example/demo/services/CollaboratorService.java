package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Collaborator;
import com.example.demo.repositories.CollaboratorRepository;


@Service
public class CollaboratorService {
	
	private final CollaboratorRepository collaboratorrepository;
	
	@Autowired
	public CollaboratorService (CollaboratorRepository collaboratorrepository) {
		this.collaboratorrepository = collaboratorrepository;
	}
	
	public Collaborator saveCollaborator(Collaborator collaborator) {
		return collaboratorrepository.save(collaborator);
	}
	
	public Collaborator getCollaboratorById(Long id) {
		return collaboratorrepository.findById(id).orElse(null);
	}
	
	public List<Collaborator> getAllCollaborators(){
		return collaboratorrepository.findAll();
	}
	
	public void deleteCollaborator(Long id) {
		collaboratorrepository.deleteById(id);
	}

}
