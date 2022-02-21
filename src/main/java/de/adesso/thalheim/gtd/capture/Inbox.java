package de.adesso.thalheim.gtd.capture;

import org.springframework.stereotype.Component;

import de.adesso.thalheim.gtd.data.ThoughtRepository;
import de.adesso.thalheim.gtd.domain.Thought;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Inbox {

	private final ThoughtRepository thoughtRepository;

	public void collect(String thought) {
		thoughtRepository.save(new Thought(thought));
	}

	public Iterable<Thought> get() {
		return thoughtRepository.findAll();
	}

}
