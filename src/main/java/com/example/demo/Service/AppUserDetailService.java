package com.example.demo.Service;

import com.example.demo.Repo.UserRepository;
import com.example.demo.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository UserRepo ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserModel> user = UserRepo.findByUsername(username) ;

        user.orElseThrow(()->new UsernameNotFoundException("We didn't find you. Invalid username is" +username));

        return user.map(AppUserDetail::new).get();
    }
    public void addUser(UserModel user){
        this.UserRepo.save(user);
    }
}
