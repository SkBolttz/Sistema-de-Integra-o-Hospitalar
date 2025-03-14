package br.com.SistemaSaude.SistemaSaude.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.SistemaSaude.SistemaSaude.DTO.LoginDTO;
import br.com.SistemaSaude.SistemaSaude.Service.SecurityService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    
    @Autowired
    private SecurityService securityService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO usuario) {

        securityService.login(usuario);

        return ResponseEntity.ok("Login realizado com sucesso");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid LoginDTO usuario) {

        securityService.register(usuario);

        return ResponseEntity.ok("Cadastro realizado com sucesso");
    }
}
