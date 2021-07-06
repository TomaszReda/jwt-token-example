package pl.test.jwttokenexample.dto;

import lombok.Data;
import pl.test.jwttokenexample.model.DAORole;

import java.util.List;

@Data
public class UserDTO {
    private String username;
    private String password;
    private List<RoleDTO> role;
}