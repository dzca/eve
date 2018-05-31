package ca.eve.app.tiger.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.eve.app.tiger.domain.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long>{

}
