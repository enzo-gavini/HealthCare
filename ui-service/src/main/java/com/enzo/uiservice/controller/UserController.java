    package com.enzo.uiservice.controller;


    import com.enzo.uiservice.dto.UserDTO;
    import com.enzo.uiservice.dto.UserRole;
    import com.enzo.uiservice.service.proxy.UserFeignClient;
    import lombok.AllArgsConstructor;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PostMapping;

    @Controller
    @AllArgsConstructor
    public class UserController {

        private final UserFeignClient userFeignClient;
        private final PasswordEncoder passwordEncoder;

        @GetMapping("/signin")
        public String showSigninPage(Model model) {
            model.addAttribute("userDto", new UserDTO());
            return "signin";
        }

        @GetMapping("/signup")
        public String showSignupPage(Model model) {
            model.addAttribute("userDto", new UserDTO());
            return "signup";
        }

        @PostMapping("/signup")
        public String register(@ModelAttribute("userDto") UserDTO userDTO) {
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userDTO.setRole(UserRole.USER);
            userFeignClient.createUser(userDTO);
            return "redirect:/signin";

        }


    }
