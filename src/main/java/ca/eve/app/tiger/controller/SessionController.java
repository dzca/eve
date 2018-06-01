package ca.eve.app.tiger.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ca.eve.app.tiger.dao.SessionRepository;
import ca.eve.app.tiger.domain.Session;
import ca.eve.app.tiger.exceptions.SessionNotFoundException;

@RestController
public class SessionController {

	@Autowired
	private SessionRepository sessionRepository;

	@GetMapping("/api/tiger/sessions")
	public List<Session> retrieveAllSessions() {
		return sessionRepository.findAll();
	}
	
	@DeleteMapping("/api/tiger/sessions/{id}")
	public void deleteSession(@PathVariable long id) {
		sessionRepository.deleteById(id);
	}

	@GetMapping("/api/tiger/sessions/{id}")
	public Resource<Session> retrieveSession(@PathVariable long id) {
		Optional<Session> session = sessionRepository.findById(id);

		if (!session.isPresent())
			throw new SessionNotFoundException("id-" + id);

		Resource<Session> resource = new Resource<Session>(session.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllSessions());
		resource.add(linkTo.withRel("all-sessions"));

		return resource;
	}

	@PostMapping("/api/tiger/sessions")
	public ResponseEntity<Object> createSession(@Valid @RequestBody Session session) {
		Session savedSession = sessionRepository.save(session);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedSession.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value = "/api/tiger/sessions/bulk/{id}", method = RequestMethod.POST)
	public String bulkInsert(@RequestBody List <String> sessions, @PathVariable long id) {
		sessions.forEach(item-> System.out.println(item));
	    return "I'm sad that this won't work.";
	}
}
