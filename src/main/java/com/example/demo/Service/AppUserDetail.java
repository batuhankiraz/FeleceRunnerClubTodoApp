package com.example.demo.Service;

import com.example.demo.models.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class AppUserDetail implements UserDetails {

    private int userId;

    private String username;
    private String password;
    private List<GrantedAuthority> authorities ;



    public AppUserDetail(UserModel userModel){
        this.username = userModel.getUsername();
        this.password = userModel.getPassword();
        this.authorities = Arrays.stream(userModel.getRoles()
                .split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        this.userId = userModel.getUserId();
    }

    public AppUserDetail(){

    }


    public int getUserId() {
        return userId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
