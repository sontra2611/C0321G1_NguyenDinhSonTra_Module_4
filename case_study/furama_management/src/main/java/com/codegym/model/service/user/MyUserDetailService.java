package com.codegym.model.service.user;

import com.codegym.model.entity.user.MyUserDetail;
import com.codegym.model.entity.user.User;
import com.codegym.model.repository.employee.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepository iuserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iuserRepository.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("username not found" + username);
        }
        return new MyUserDetail(user);
    }
}
