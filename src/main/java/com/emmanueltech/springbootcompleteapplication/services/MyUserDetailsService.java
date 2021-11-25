package com.emmanueltech.springbootcompleteapplication.services;

import com.emmanueltech.springbootcompleteapplication.models.UserPrincipal;
import com.emmanueltech.springbootcompleteapplication.models.Users;
import com.emmanueltech.springbootcompleteapplication.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users foundUser = usersRepository.findByUsername(username);

        if(foundUser==null){
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(foundUser);
    }
}
