package com.felipe.dscommerce.tests;

import com.felipe.dscommerce.entities.Role;
import com.felipe.dscommerce.entities.User;

import java.time.LocalDate;

public class UserFactory {

    public static User createClientUser() {
        User user = new User(1L,"Maria","maria@gmail.com", "9999999", LocalDate.parse("2001-07-25"), "$2a$10$FxNVmbT/AvpKsRG1FNm2q.ZMxeIpMN/E/UeYM3jNhyNQlj8LjJfwC");
        user.addRole(new Role(1L, "ROLE_CLIENT"));
        return user;
    }

    public static User createAdminUser() {
        User user = new User(2L,"Alex","alex@gmail.com", "9999999", LocalDate.parse("1987-12-13"), "$2a$10$FxNVmbT/AvpKsRG1FNm2q.ZMxeIpMN/E/UeYM3jNhyNQlj8LjJfwC");
        user.addRole(new Role(2L, "ROLE_CLIENT"));
        return user;
    }

    public static User createCustomClientUser(Long id, String username) {
        User user = new User(id,"Maria",username, "9999999", LocalDate.parse("2001-07-25"), "$2a$10$FxNVmbT/AvpKsRG1FNm2q.ZMxeIpMN/E/UeYM3jNhyNQlj8LjJfwC");
        user.addRole(new Role(1L, "ROLE_CLIENT"));
        return user;
    }
    public static User createCustomAdminUser(Long id, String username) {
        User user = new User(id,"Alex",username, "9999999", LocalDate.parse("1987-12-13"), "$2a$10$FxNVmbT/AvpKsRG1FNm2q.ZMxeIpMN/E/UeYM3jNhyNQlj8LjJfwC");
        user.addRole(new Role(2L, "ROLE_CLIENT"));
        return user;
    }

}
