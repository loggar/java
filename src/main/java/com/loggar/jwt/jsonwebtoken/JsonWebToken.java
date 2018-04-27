package com.loggar.jwt.jsonwebtoken;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @author charly.lee
 * 
 *         <pre>
 * https://jwt.io/
 * http://mvnrepository.com/artifact/io.jsonwebtoken/jjwt/0.9.0
 * https://stormpath.com/blog/jwt-java-create-verify
 *         </pre>
 */
public class JsonWebToken {
	private static final String API_KEY = "lkj3ivlkddj239@$@Gwe19193fjck";

	// Sample method to construct a JWT
	public String create(String id, String issuer, String subject, long howlong_ttlMillis) {

		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(API_KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
				.signWith(signatureAlgorithm, signingKey);

		// if it has been specified, let's add the expiration
		if (howlong_ttlMillis >= 0) {
			long expMillis = nowMillis + howlong_ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	public Claims verify(String jwt) {
		// This line will throw an exception if it is not a signed JWS (as expected)
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(API_KEY)).parseClaimsJws(jwt)
				.getBody();
		return claims;
	}
}
