package ch.tbz.animal.core.security;


import ch.tbz.animal.core.security.helpers.AuthorizationSchemas;
import ch.tbz.animal.core.security.helpers.JwtProperties;
import ch.tbz.animal.domain.user.UserDetailsImpl;
import ch.tbz.animal.domain.user.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

  private final UserService userService;
  private final JwtProperties jwtProperties;

  public JWTAuthorizationFilter(UserService userService, JwtProperties jwtProperties) {
    this.userService = userService;
    this.jwtProperties = jwtProperties;
  }

  private String resolveToken(String token) {
    if (token != null && token.startsWith(AuthorizationSchemas.BEARER.toString())) {
      byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecret());
      return Jwts.parserBuilder()
                 .setSigningKey(Keys.hmacShaKeyFor(keyBytes))
                 .build()
                 .parseClaimsJws(token.replace(AuthorizationSchemas.BEARER + " ", ""))
                 .getBody()
                 .getSubject();
    } else {
      return null;
    }
  }


  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    try {
      String authToken = request.getHeader(HttpHeaders.AUTHORIZATION);
      UserDetails userDetails = new UserDetailsImpl(userService.findById(UUID.fromString(resolveToken(authToken))));
      SecurityContextHolder.getContext()
              .setAuthentication(new UsernamePasswordAuthenticationToken(userDetails, null,
                      userDetails.getAuthorities()));
    }
    catch (RuntimeException e) {
      SecurityContextHolder.clearContext();
    }
    filterChain.doFilter(request, response);
  }
}
