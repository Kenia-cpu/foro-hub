package com.alura.forohub.controller;

import com.alura.forohub.domain.usuario.DatosAutenticacionUsuario;
import com.alura.forohub.domain.usuario.Usuario;
import com.alura.forohub.infra.security.DatosJWTToken;
import com.alura.forohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datos) {
        // 1. Creamos el token con las credenciales que vienen de Insomnia
        Authentication authToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.clave());

        // 2. Le pedimos al AuthenticationManager que verifique si el usuario existe y la clave es correcta
        var usuarioAutenticado = authenticationManager.authenticate(authToken);

        // 3. Si todo está bien, generamos el Token JWT usando nuestra clase TokenService
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());

        // 4. Devolvemos el token envuelto en nuestro DTO DatosJWTToken
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}