package de.adesso.thalheim.gtd.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import de.adesso.thalheim.gtd.capture.Inbox;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CaptureStepDefinitions {
	
	@Autowired
	private Inbox inbox;
	
	@When("Thought {string} is collected")
	public void thought_is_collected(String thought) {
		inbox.collect(thought);
	}

	@Then("Inbox contains {string}")
	public void inbox_contains(String thought) {
		assertThat(StreamSupport.stream(inbox.get().spliterator(), false)
			.filter(x -> x.getDescription().equals(thought))
			.findAny()).isPresent();
	}
}
