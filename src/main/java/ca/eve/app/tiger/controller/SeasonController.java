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

import ca.eve.app.tiger.dao.SeasonRepository;
import ca.eve.app.tiger.domain.Season;
import ca.eve.app.tiger.exceptions.SeasonNotFoundException;

@RestController
public class SeasonController {

	@Autowired
	private SeasonRepository seasonRepository;

	@GetMapping("/api/tiger/seasons")
	public List<Season> retrieveAllSeasons() {
		return seasonRepository.findAll();
	}
	
	@DeleteMapping("/api/tiger/seasons/{id}")
	public void deleteSeason(@PathVariable long id) {
		seasonRepository.deleteById(id);
	}

	@GetMapping("/api/tiger/seasons/{id}")
	public Resource<Season> retrieveSeason(@PathVariable long id) {
		Optional<Season> season = seasonRepository.findById(id);

		if (!season.isPresent())
			throw new SeasonNotFoundException("id-" + id);

		Resource<Season> resource = new Resource<Season>(season.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllSeasons());
		resource.add(linkTo.withRel("all-seasons"));

		return resource;
	}

	@PostMapping("/api/tiger/seasons")
	public ResponseEntity<Object> createSeason(@Valid @RequestBody Season season) {
		Season savedSeason = seasonRepository.save(season);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedSeason.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value = "/api/tiger/seasons/bulk", method = RequestMethod.POST)
	public String bulkInsert(@RequestBody List <Season> seasons) {
		seasons.forEach(item -> seasonRepository.save(item));
	    return "I'm sad that this won't work.";
	}
}
