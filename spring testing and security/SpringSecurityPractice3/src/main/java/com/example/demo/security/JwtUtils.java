package com.example.demo.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.example.demo.entities.User;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;


@Component
public class JwtUtils {

	 @Value("${jwt.secret}")
	  private String jwtSecret;

	  @Value("${jwt.jwtExpirationInMs}")
	  private int jwtExpirationMs;

	  @Value("${jwt.jwtCookieName}")
	  private String jwtCookie;

	  public String getJwtFromCookies(HttpServletRequest request) {
		    Cookie cookie = WebUtils.getCookie(request, jwtCookie);
		    
		    if (cookie != null) {
		    	System.out.println(cookie.getValue());
		      return cookie.getValue();
		    } else {
		      return null;
		    }
		  }

		  public ResponseCookie generateJwtCookie(MyUserDetails userPrincipal) {
			  System.out.println(jwtCookie);
		    String jwt = generateTokenFromUsername(userPrincipal.getUsername());
		    ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/").maxAge(24 * 60 * 60).httpOnly(true).build();
		    return cookie;
		  }

		  public ResponseCookie getCleanJwtCookie() {
		    ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();
		    return cookie;
		  }

		  public String getUserNameFromJwtToken(String token) {
		    return Jwts.parserBuilder().setSigningKey(key()).build()
		        .parseClaimsJws(token).getBody().getSubject();
		  }
		  
		  private Key key() {
		    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
		  }

		  public boolean validateJwtToken(String authToken) {
			  System.out.println(authToken);
		    try {
		      Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
		      return true;
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }

		    return false;
		  }
		  
		  public String generateTokenFromUsername(String username) {   
		    return Jwts.builder()
		              .setSubject(username)
		              .setIssuedAt(new Date())
		              .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
		              .signWith(key(), SignatureAlgorithm.HS256)
		              .compact();
		  }


}
