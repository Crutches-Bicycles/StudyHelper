package crutchesbicycles.studyhelper.controller;

import crutchesbicycles.studyhelper.domain.Account;
import crutchesbicycles.studyhelper.security.UserDetailController;
import crutchesbicycles.studyhelper.security.jwt.JwtTokenProvider;
import crutchesbicycles.studyhelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @RequestMapping("login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

            Account account = userService.findByEmail(email);
            String token = jwtTokenProvider.createToken(email, account.getRoles());

            Map<Object, Object> response = new HashMap<>();

            response.put("email", email);
            response.put("token", token);

            return ResponseEntity.ok(response);
        }catch (AuthenticationException e){
            throw new BadCredentialsException("Invalid email or password");
        }
    }

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider,
                          UserDetailController userDetailController) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailController = userDetailController;
    }
}
