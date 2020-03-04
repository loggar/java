package com.loggar.security.bcrypt;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BcryptExampleWithUpdatableIterations {
	private static final Logger log = LoggerFactory.getLogger(BcryptExampleWithUpdatableIterations.class);

	public static void main(String[] args) {
		// Mini function to test updates.
		String[] mutableHash = new String[1];
		Function<String, Boolean> update = hash -> {
			mutableHash[0] = hash;
			return true;
		};

		String hashPw1 = BCryptHashingUtils.hash("password");
		log.debug("hash of pw1: {}", hashPw1);
		log.debug("verifying pw1: {}", BCryptHashingUtils.verifyAndUpdateHash("password", hashPw1, update));
		log.debug("verifying pw1 fails: {}", BCryptHashingUtils.verifyAndUpdateHash("password1", hashPw1, update));
		String hashPw2 = BCryptHashingUtils.hash("password");
		log.debug("hash of pw2: {}", hashPw2);
		log.debug("verifying pw2: {}", BCryptHashingUtils.verifyAndUpdateHash("password", hashPw2, update));
		log.debug("verifying pw2 fails: {}", BCryptHashingUtils.verifyAndUpdateHash("password2", hashPw2, update));

		UpdatableBCrypt oldHasher = new UpdatableBCrypt(7);
		String oldHash = oldHasher.hash("password");
		log.debug("hash of oldHash: {}", oldHash);
		log.debug("verifying oldHash: {}, hash upgraded to: {}", BCryptHashingUtils.verifyAndUpdateHash("password", oldHash, update), mutableHash[0]);
	}
}
