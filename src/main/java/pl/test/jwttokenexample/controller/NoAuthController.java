package pl.test.jwttokenexample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NoAuthController
{


    @GetMapping("/noauth")
    public ResponseEntity<Void> noauth(){
        return ResponseEntity.ok().build();
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/auth")
    public ResponseEntity<Void> auth(){
        return ResponseEntity.ok().build();
    }

}
