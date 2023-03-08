package com.cdvtc.ecommerce.repository;

import com.cdvtc.ecommerce.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserRepositoryTest extends BaseTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void getUserByEmailAndPassword() {
        assertNotNull(userRepository.getUserByEmailAndPassword("cart@mail.com", "123456"), "登陆验证失败");
    }
}
