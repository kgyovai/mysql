package com.bridgephase.mysql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "test")
public class TestEntity {

	private Instant createdOn;

	@Id
	private String id;

	@PrePersist
	private void update() {
		id = UUID.randomUUID().toString();
		createdOn = Instant.now();
	}

	public String getId() {
		return id;
	}

	public Instant getCreatedOn() {
		return createdOn;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof TestEntity)) {
			return false;
		}
		TestEntity that = (TestEntity) o;
		return Objects.equals(createdOn, that.createdOn) &&
				Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdOn, id);
	}
}
