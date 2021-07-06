package pl.test.jwttokenexample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.test.jwttokenexample.dto.UserDTO;
import pl.test.jwttokenexample.model.DAORole;
import pl.test.jwttokenexample.model.DAOUser;
import pl.test.jwttokenexample.repository.UserDaoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDaoRepository userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        DAOUser user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }


    public DAOUser save(UserDTO user) {
        DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        List<DAORole> roles = new ArrayList<>();
        user.getRole().stream().forEach(x -> roles.add(new DAORole(x.getName())));
        newUser.getRoles().addAll(roles);
        return userDao.save(newUser);
    }
}