package moto.motorcyclegaragehelper.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.util.Date;

@Component
public class JwUtil {
    private final String SECRET_KEY = "meowmeowmeow";

    public String generateJwToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis()+86400000)
                ).signWith(
                        Keys.hmacShaKeyFor(SECRET_KEY.getBytes()),
                        SignatureAlgorithm.HS256
                ).compact();

    }
}
