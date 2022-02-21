package de.adesso.thalheim.gtd.capture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import de.adesso.thalheim.gtd.data.ThoughtRepository;
import de.adesso.thalheim.gtd.domain.Thought;

class InboxTest {

	private ThoughtRepository repository;

	private Inbox inbox;

	@Test
	void testPutThoughtIntoInbox() {
		this.repository = mock(ThoughtRepository.class);
		this.inbox = new Inbox(repository);
		// when
		inbox.collect("myThought");
		ArgumentCaptor<Thought> thoughtArgumentCaptor = ArgumentCaptor.forClass(Thought.class);
		// then
		verify(repository).save(thoughtArgumentCaptor.capture());
		assertThat(thoughtArgumentCaptor.getValue().getDescription()).isEqualTo("myThought");
	}

}
