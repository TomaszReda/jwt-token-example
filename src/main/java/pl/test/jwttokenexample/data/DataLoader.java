package pl.test.jwttokenexample.data;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.test.jwttokenexample.model.DAORole;
import pl.test.jwttokenexample.model.RoleType;
import pl.test.jwttokenexample.repository.RoleRepository;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final RoleRepository repository;


    public void run(ApplicationArguments args) {
        DAORole admin = new DAORole();
        admin.setRoleType(RoleType.ADMIN);
        DAORole user = new DAORole();
        user.setRoleType(RoleType.USER);
        repository.save(admin);
        repository.save(user);
    }
}