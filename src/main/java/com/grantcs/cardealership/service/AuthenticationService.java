package com.grantcs.cardealership.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

public class AuthenticationService {
    private static final long EXPIRATION_TIME = 854_00_00;
    private static final String SECRET_KEY = "SecretKey";
    private static final String PREFIX = "BEARER";

    // Add token to Authorization header
    public static void addToken(HttpServletResponse httpServletResponse, String username) {
        String JwtToken = Jwts
                .builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
        httpServletResponse.addHeader("Authorization", PREFIX + " " + JwtToken);
        httpServletResponse.addHeader("Access-Control-Expose-Headers", "Authorization");
    }

    // Get token from Authorization header
    public static Authentication getAuthentication(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        if (token != null) {
            String user = Jwts
                    .parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();
            if (user != null)
                return new UsernamePasswordAuthenticationToken(user, null,
                        emptyList());
        }
        return null;
    }
}
