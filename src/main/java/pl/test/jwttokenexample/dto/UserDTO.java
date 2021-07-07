package pl.test.jwttokenexample.dto;

import lombok.Data;
import pl.test.jwttokenexample.model.DAORole;
import pl.test.jwttokenexample.model.RoleType;

import java.util.List;

@Data
public class UserDTO {
    private String username;
    private String password;
    private List<RoleType> role;
}