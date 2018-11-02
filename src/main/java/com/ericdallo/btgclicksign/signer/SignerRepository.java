package com.ericdallo.btgclicksign.signer;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Signer.class, idClass = Long.class)
public interface SignerRepository {

	List<Signer> findAll();
	
}
