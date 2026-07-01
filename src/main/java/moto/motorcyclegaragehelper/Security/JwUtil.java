package moto.motorcyclegaragehelper.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.Security;
import java.util.Date;
/** This is a Service class for Authentication
 * The class is used for password encoding
 * This class is used when users are logging in to generate a token for the log in session*/

@Service
public class JwUtil {

    //Encoding key
    private final String SECRET =
            "mySuperSecretJwtKeyThatIsAtLeast32CharactersLongForHS256AndSpringBoot";

    //Generates token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 86400000)
                )
                .signWith(
                        Keys.hmacShaKeyFor(SECRET.getBytes()), //Encodes password
                        SignatureAlgorithm.HS256
                )
                .compact();
    }

    //Gets Username from token
    public String extractUsername(String token) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(
                        Keys.hmacShaKeyFor(SECRET.getBytes())
                )
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
