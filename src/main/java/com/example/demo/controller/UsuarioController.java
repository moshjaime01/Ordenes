package com.example.demo.controller;

import com.example.demo.dto.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsuarioController {

    @PostMapping("usuario")
    public Usuario login(@RequestParam("usuario") String usuario, @RequestParam("password") String pass){

        String token = getJWTToken(usuario);

        Usuario usuario1 = new Usuario();
        usuario1.setUsuario(usuario);
        usuario1.setToken(token);
        return usuario1;

    }


    private String getJWTToken(String usuario) {
        String key = "mySecretKeymySecretKeymySecretKeymySecretKeymySecretKeymySecretKeymySecretKeymySecretKeymySecretKeymySecretKey";

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts.builder().setId("pruebaJWT").setSubject(usuario).claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        key.getBytes()).compact();

        return "Bearer "+token;
    }
}
