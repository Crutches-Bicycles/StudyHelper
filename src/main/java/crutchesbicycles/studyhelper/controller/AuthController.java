package crutchesbicycles.studyhelper.controller;

import crutchesbicycles.studyhelper.domain.Account;
import crutchesbicycles.studyhelper.security.jwt.JwtTokenProvider;
import crutchesbicycles.studyhelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Вход в систему \n
     * <b>Путь: /api/auth/login</b> \n
     * Тип запроса: POST \n
     * @param email -- почта пользователя
     * @param password -- пароль в открытом виде (шифруется на сервере)
     * @return jwtToken (expired_time=8640000ms (1 день))
     */
    @PostMapping("login")
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

    /**
     * Создать аккаунт в системе \n
     * <b>Путь: /api/accounts</b> \n
     * @param email -- email пользователя
     * @param password -- пароль пользователя
     * @param i -- тип пользователя (0 -- user, 1 -- староста+user, 2 -- admin+user+староста)
     * @return HttpStatus OK и созданный аккаунт
     */
    @PostMapping("register")
    public ResponseEntity<?> register(@RequestParam String email, @RequestParam String password, @RequestParam Integer i){
        Account account = new Account(null, email, password, null);
        Account createdAccount = userService.register(account, i);
        return ResponseEntity.ok(createdAccount);
    }

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
}
