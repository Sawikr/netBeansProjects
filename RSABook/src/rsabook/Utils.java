/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsabook;

/**
 *
 * @author Radosław Sawicki
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Utils {
    
 private static class FixedRand extends SecureRandom
 {
 MessageDigest sha;
 byte[] state;
 FixedRand()
 {
 try
 {
 this.sha = MessageDigest.getInstance("SHA-1");
 this.state = sha.digest();
 }
 catch (NoSuchAlgorithmException e)
 {
 throw new RuntimeException("nie znaleziono SHA-1!");
 }
 }
 public void nextBytes(byte[] bytes)
 {
 int off = 0;
 sha.update(state);
 while (off < bytes.length)
 {
 state = sha.digest();
 if (bytes.length - off > state.length)
 {
 System.arraycopy(state, 0, bytes, off, state.length);
 }
 else
 {
 System.arraycopy(state, 0, bytes, off, bytes.length - off);
 }

 off += state.length;
 sha.update(state);
 }
 }
 }
 /**
 * Zwraca obiekt SecureRandom generujący stałą wartość.
 * <b>Wyłącznie do celów testowych!</b>
 * @return stała wartość losowa
 */
 public static SecureRandom createFixedRandom()
 {
 return new FixedRand();
 }
}