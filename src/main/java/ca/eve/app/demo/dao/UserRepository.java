package ca.eve.app.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.eve.app.demo.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
