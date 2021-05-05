package com.learning.securityjpa.springsecurityjpa;

import com.learning.securityjpa.springsecurityjpa.model.MyUsers;
import com.learning.securityjpa.springsecurityjpa.model.UserModel;
import com.learning.securityjpa.springsecurityjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserModel> userModel = userRepository.findByUserName(userName);

        userModel.orElseThrow(() -> new UsernameNotFoundException("User not found: " + userName));

        return userModel.map(MyUsers::new).get();
    }
}
