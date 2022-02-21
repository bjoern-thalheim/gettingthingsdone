package de.adesso.thalheim.gtd.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Thought {
	
	@Id
	private UUID id;

	private String description;

	public Thought(String description) {
		this.id = UUID.randomUUID();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	/*
	 * protected methods below are boilerplate code for spring data.
	 */
	Thought() { }
	
	UUID getId() {
		return id;
	}

	void setId(UUID id) {
		this.id = id;
	}

	void setDescription(String description) {
		this.description = description;
	}
}
