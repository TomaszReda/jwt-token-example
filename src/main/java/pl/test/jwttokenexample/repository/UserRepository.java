package pl.test.jwttokenexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.test.jwttokenexample.model.DAOUser;

@Repository
public interface UserRepository extends JpaRepository<DAOUser, Long> {
    DAOUser findByUsername(String username);
}
