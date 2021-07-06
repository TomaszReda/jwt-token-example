package pl.test.jwttokenexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.test.jwttokenexample.model.DAORole;

@Repository
public interface RoleRepository extends JpaRepository<DAORole, Long> {
    DAORole findByName(String name);
}
