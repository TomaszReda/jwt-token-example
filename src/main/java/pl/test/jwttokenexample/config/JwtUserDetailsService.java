package pl.test.jwttokenexample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.test.jwttokenexample.dto.UserDTO;
import pl.test.jwttokenexample.model.DAORole;
import pl.test.jwttokenexample.model.DAOUser;
import pl.test.jwttokenexample.repository.RoleRepository;
import pl.test.jwttokenexample.repository.UserDaoRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDaoRepository userDao;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Set authorities = new HashSet();
        DAOUser user = userDao.findByUsername(username);
        user.getRoles().stream().forEach(x -> authorities.add(new SimpleGrantedAuthority("ROLE_" + x.getRoleType())));
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);
    }


    public DAOUser save(UserDTO user) {
        DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));

        List<DAORole> daoRoles = roleRepository.findAllByRoleTypeIn(user.getRole());
        newUser.setRoles(daoRoles);
        return userDao.save(newUser);
    }
}