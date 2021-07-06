package pl.test.jwttokenexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.test.jwttokenexample.model.DAOUser;

@Repository
public interface UserDaoRepository extends JpaRepository<DAOUser, Integer> {
    DAOUser findByUsername(String username);
}