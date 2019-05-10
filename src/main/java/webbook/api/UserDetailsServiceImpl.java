package webbook.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import webbook.api.entity.User;
import webbook.api.entity.UserAuthority;
import webbook.api.entity.dto.CustomGrantedAuthorityDTO;
import webbook.api.entity.dto.CustomUserDetailsDTO;
import webbook.api.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user != null) {
            CustomUserDetailsDTO customUserDetails = new CustomUserDetailsDTO();
            customUserDetails.setUserName(user.getEmail());
            customUserDetails.setPassword(user.getPassword());
            Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
            for (UserAuthority authority : user.getUserAuthorities()) {
                authorities.add(new CustomGrantedAuthorityDTO(authority.getAuthority().getName()));
            }
            customUserDetails.setGrantedAuthorities(authorities);
            return customUserDetails;
        }
        throw new UsernameNotFoundException(username);
    }

}