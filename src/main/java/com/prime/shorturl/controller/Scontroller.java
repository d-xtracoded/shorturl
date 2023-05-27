package com.prime.shorturl.controller;

import com.prime.shorturl.entity.Redirect;
import com.prime.shorturl.repository.RedirectRepository;
import com.prime.shorturl.request.RedirectCreationRequest;
import com.prime.shorturl.service.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class Scontroller {
    private RedirectRepository redirectRepository;
    @Autowired
    private RedirectService redirectService;
@Autowired
    public Scontroller(RedirectRepository redirectRepository) {
        this.redirectRepository = redirectRepository;
    }

    @GetMapping("/")
    public String greet(){
        return "greetings";
    }

@GetMapping("/{alias}")
    public ResponseEntity<Redirect> handleRedirect(@PathVariable String alias) throws URISyntaxException {
    Redirect redirect = redirectService.getredirect(alias);
    System.out.println("WE are redirecting");

    URI uri = new URI(redirect.getUrl());
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setLocation(uri);
        return  new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
}

@PostMapping("/")
    public ResponseEntity<?> createRedirect(@Valid @RequestBody RedirectCreationRequest redirectCreationRequest){
        return ResponseEntity.ok(redirectService.CreateRedirect(redirectCreationRequest));
}
}
