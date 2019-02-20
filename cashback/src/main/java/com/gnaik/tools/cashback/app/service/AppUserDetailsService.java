/*
package com.gnaik.tools.cashback.app.service;

import com.gnaik.tools.cashback.app.documents.Account;
import com.gnaik.tools.cashback.app.resource.AccountResource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final AccountResource accountResource;

    public AppUserDetailsService(AccountResource accountResource) {
        this.accountResource = accountResource;
    }

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        Account account = accountResource.getAccount(Long.getLong(userName));
        return new User(account.getFirstName(), account.getPassword(), null);
    }
}*/
