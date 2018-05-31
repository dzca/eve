package ca.eve.app.tiger.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.eve.app.tiger.domain.Season;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long>{

}
