package pl.test.jwttokenexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.test.jwttokenexample.model.DAORole;
import pl.test.jwttokenexample.model.RoleType;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<DAORole, Long> {

    List<DAORole> findAllByRoleTypeIn(List<RoleType> list);
}
