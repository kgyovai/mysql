package com.bridgephase.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestEntityRepositoryService {

	@Autowired
	private TestEntityRepository testEntityRepository;

	@Transactional
	public TestEntity findById(String id) {
		return testEntityRepository.findById(id).get();
	}

	@Transactional
	public TestEntity save(TestEntity testEntity) {
		return testEntityRepository.saveAndFlush(testEntity);
	}
}
