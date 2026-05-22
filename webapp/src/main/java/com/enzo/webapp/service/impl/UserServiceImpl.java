package com.enzo.webapp.service.impl;


import com.enzo.webapp.model.User;
import com.enzo.webapp.service.client.PatientFeignClient;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    private final PasswordEncoder passwordEncoder;
    private final PatientFeignClient patientFeignClient;

        public UserServiceImpl(PasswordEncoder passwordEncoder, PatientFeignClient patientFeignClient) {
            this.passwordEncoder = passwordEncoder;
            this.patientFeignClient = patientFeignClient;
        }

        @Override
        public User register(User user) {
            user.setRole(UserRole.USER);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
          return patientFeignClient.createUser(user).getBody();
        }

        @Override
        public User findByUserName(String username) {
            return patientFeignClient.findUserByUsername(username).getBody();
        }
}
