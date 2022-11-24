package com.apiRest.apiRest.security;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {
    
    private final static String ACCES_TOKEN_SECRET = "4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud"; //Firma del token
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L; //Tiempo para la vida util del token "1 mes"

    public static String createToken(String nombre, String email){
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);
        return Jwts.builder()
        .setSubject(email)
        .setExpiration(expirationDate)
        .addClaims(extra)
        .signWith(Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
        .compact();
    }

    public static UsernamePasswordAuthenticationToken getAutentication(String token){
       try {
        Claims claims = Jwts.parserBuilder()
        .setSigningKey(ACCES_TOKEN_SECRET.getBytes())
        .build()
        .parseClaimsJws(token)
        .getBody();

        String email = claims.getSubject();
        return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
       } catch (JwtException e) {
        // TODO: handle exception
        return null;
       }
        
    }

}
