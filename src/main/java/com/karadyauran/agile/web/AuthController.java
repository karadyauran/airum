package com.karadyauran.agile.web;

import com.karadyauran.agile.dto.jwt.JwtRequest;
import com.karadyauran.agile.dto.jwt.JwtResponse;
import com.karadyauran.agile.mapper.UserMapper;
import com.karadyauran.agile.service.interf.UserService;
import com.karadyauran.agile.util.JwtTokenUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController
{

    UserService service;
    UserMapper mapper;
    JwtTokenUtil jwtTokenUtil;
    AuthenticationManager authenticationManager;

    @PostMapping()
    public ResponseEntity<JwtResponse> authenticate(@RequestBody JwtRequest jwtRequest)
    {
        log.info("User trying to log in with login: {}", jwtRequest.getUsername());
        var user = mapper.toEntity(
                service.getUserByUsername(jwtRequest.getUsername())
        );
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),
                jwtRequest.getPassword()));

        var token = jwtTokenUtil.generateTokenFromUser(user);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}