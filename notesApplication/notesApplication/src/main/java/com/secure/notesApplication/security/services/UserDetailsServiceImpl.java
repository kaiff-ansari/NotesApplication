package com.secure.notesApplication.security.services;

import com.secure.notesApplication.models.User;
import com.secure.notesApplication.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("[DEBUG_LOG] Loading user by username: " + username);
        try {
            User user = userRepository.findByUserName(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

            System.out.println("[DEBUG_LOG] User found: " + username);
            System.out.println("[DEBUG_LOG] User account status - accountNonLocked: " + user.isAccountNonLocked() + 
                               ", accountNonExpired: " + user.isAccountNonExpired() + 
                               ", credentialsNonExpired: " + user.isCredentialsNonExpired() + 
                               ", enabled: " + user.isEnabled());

            UserDetails userDetails = UserDetailsImpl.build(user);
            System.out.println("[DEBUG_LOG] UserDetails built successfully for: " + username);
            return userDetails;
        } catch (UsernameNotFoundException e) {
            System.out.println("[DEBUG_LOG] User not found: " + username);
            throw e;
        } catch (Exception e) {
            System.out.println("[DEBUG_LOG] Error loading user: " + username + ", error: " + e.getMessage());
            throw e;
        }
    }

}
