package com.enzo.uiservice.service.proxy;


import com.enzo.uiservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="patient", contextId = "userClient")
public interface UserFeignClient {

    @PostMapping("/createUser")
    public UserDTO createUser(@RequestBody UserDTO userDTO);

    @GetMapping("/findUserByUsername")
    public UserDTO getUserByUsername(@RequestParam String username);

}
