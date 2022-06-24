package com.ti.customer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ti.customer.dao.CollaboratorRepository;
import com.ti.customer.entity.Collaborator;

@Service("collaboratorService")
@Transactional
public class CollaboratorServiceImpl implements CollaboratorService{

	private static final Logger logger = LogManager.getLogger(CollaboratorServiceImpl.class);
	
	@Autowired
	private  CollaboratorRepository repo;
	
	@Override
	public Collaborator getCollaboratorById(Long id) {
		return repo.getCollaborator(id);
	}

	@Override
	public List<Collaborator> getListAllCollaborator() {
		logger.info("TAMAÑO DE LA LISTA COLABORADORES EN LA CAPA SERVICE ES : "+ repo.getListAllCollaborator().size());
		return repo.getListAllCollaborator();
	}

}
