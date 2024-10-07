package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Collaborator;
import com.example.demo.services.CollaboratorService;

@RestController
@RequestMapping("/collaborator")
public class CollaboratorController {
	
	private final CollaboratorService collaboratorservice;
	
	@Autowired
	public CollaboratorController (CollaboratorService collaboratorservice) {
		this.collaboratorservice = collaboratorservice;
	}
	
	@PostMapping
	public Collaborator createCollaborator (@RequestBody Collaborator collaborator) {
		return collaboratorservice.saveCollaborator(collaborator);
	}
	
	
	
	@GetMapping
	public List<Collaborator> getAllCustomer(){
		return collaboratorservice.getAllCollaborators();
	}
	
	@GetMapping("/{id}")
	public Collaborator getCollaborator(@PathVariable Long id) {
		return collaboratorservice.getCollaboratorById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteCollaborator(@PathVariable Long id) {
		collaboratorservice.deleteCollaborator(id);
	}


}

