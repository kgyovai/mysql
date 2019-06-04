package com.bridgephase.mysql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestEntityRepositoryTest {

	@Autowired
	private TestEntityRepository testEntityRepository;

	@Test
	public void test() {
		TestEntity entity = new TestEntity();
		TestEntity persisted = testEntityRepository.saveAndFlush(entity);

		Optional<TestEntity> fromDb = testEntityRepository.findById(persisted.getId());

		assertEquals(persisted, fromDb.get());
	}
}
