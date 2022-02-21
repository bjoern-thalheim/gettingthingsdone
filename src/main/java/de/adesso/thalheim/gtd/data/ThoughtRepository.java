package de.adesso.thalheim.gtd.data;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.adesso.thalheim.gtd.domain.Thought;

@Repository
public interface ThoughtRepository extends CrudRepository<Thought, UUID> {

}
