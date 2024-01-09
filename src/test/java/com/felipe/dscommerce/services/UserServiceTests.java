package com.felipe.dscommerce.services;

import com.felipe.dscommerce.entities.User;
import com.felipe.dscommerce.projections.UserDetailsProjection;
import com.felipe.dscommerce.repositories.UserRepository;
import com.felipe.dscommerce.tests.UserDetailsFactory;
import com.felipe.dscommerce.tests.UserFactory;
import com.felipe.dscommerce.util.CustomUserUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class UserServiceTests {

    @InjectMocks
    private UserService service;
    @Mock
    private UserRepository repository;
    @Mock
    private CustomUserUtil userUtil;

    private String existingUsername;
    private String nonExistingUsername;
    private User user;
    private List<UserDetailsProjection> userDetailsProjections;

    @BeforeEach
    void setUp() throws Exception {
        existingUsername = "maria@gmail.com";
        nonExistingUsername = "user@gmail.com";

        user = UserFactory.createCustomClientUser(1L,existingUsername);
        userDetailsProjections = UserDetailsFactory.createCustomAdminUser(existingUsername);

        Mockito.when(repository.searchUserAndRolesByEmail(existingUsername)).thenReturn(userDetailsProjections);
        Mockito.when(repository.searchUserAndRolesByEmail(nonExistingUsername)).thenReturn(new ArrayList<>());

        Mockito.when(repository.findByEmail(existingUsername)).thenReturn(Optional.of(user));
        Mockito.when(repository.findByEmail(nonExistingUsername)).thenReturn(Optional.empty());

    }

    @Test
    public void loadUserByUsernameShouldReturnUserDetailsWhenUserExists() {
        UserDetails result = service.loadUserByUsername(existingUsername);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getUsername(), existingUsername);
    }

    @Test
    public void loadUserByUsernameShouldThrowUsernameNotFoundExceptionWhenUserNotExists() {
        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            service.loadUserByUsername(nonExistingUsername);
        });
    }

    @Test
    public void authenticatedShouldReturnUserWhenUserExists() {
        Mockito.when(userUtil.getLoggedUsername()).thenReturn(existingUsername);
        User result = service.authenticated();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getUsername(), existingUsername);
    }

    @Test
    public void authenticatedShouldThrowUsernameNotFoundExceptionWhenUserNotExists() {
        Mockito.doThrow(ClassCastException.class).when(userUtil).getLoggedUsername();
        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            service.authenticated();
        });
    }

}
