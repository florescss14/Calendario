package com.chrisflores.calendariospring.security;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class Hashing {
	 private static final String SHA2_ALGORITHM = "SHA-256";
	 
	 public static byte[] getSalt() {
		 byte[] salt = new byte[16];
	        SecureRandom secure_random
	            = new SecureRandom();
	        secure_random.nextBytes(salt);
	        return salt;
	 }
	 
	 public static byte[] getHash(String password, byte[] salt) throws Exception{
        ByteArrayOutputStream byte_Stream
            = new ByteArrayOutputStream();
 
        byte_Stream.write(salt);
        byte_Stream.write(password.getBytes(StandardCharsets.UTF_8));
        byte[] valueToHash = byte_Stream.toByteArray();
        MessageDigest messageDigest = MessageDigest.getInstance(SHA2_ALGORITHM);
        return messageDigest.digest(valueToHash);
    }
}
