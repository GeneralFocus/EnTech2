package com.capriquota.Miscellenous;

/**
 * Created by Ace Corps on 09/06/2019.
 */

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class Utility implements doUtility {


    public static final String LOGGER = "ENTECH:";


    public boolean checkInternet(){
        String ip = this.getRealIpAddr();
        return !((ip == null) || (ip.equals(doUtility.LOCALHOST)));
    }


    /*
    getEnv returns a string of requested System Environment
    @params(String value)
    */

    public static String getEnv(String value){return System.getenv(value);}

    //Hashing my passwords not yet used to database
    private static boolean validatePassword(String originalPass, String storedPass) throws NoSuchAlgorithmException, InvalidKeySpecException{

        String[] parts = storedPass.split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = Utility.fromHex(parts[1]);
        byte[] hash = Utility.fromHex(parts[2]);

        PBEKeySpec spec = new PBEKeySpec(originalPass.toCharArray(),salt,iterations,hash.length*8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;
        for(int i = 0 ; i < hash.length && i < testHash.length;i++){
            diff |= hash[i]^testHash[i];
        }
        return diff == 0;
    }


    private static byte[] fromHex(String hex ) {
        byte[] bytes = new byte[hex.length()/2];
        for(int i =0; i < bytes.length; i++){
            bytes[i] = (byte)Integer.parseInt(hex.substring(2*i,2*i+2),16);
        }
        return bytes;
    }


    private static String HashPass(String password) throws NoSuchAlgorithmException, InvalidKeySpecException{
        int iteration = 1000;
        char[] chars= password.toCharArray();
        byte[] salt = Utility.getSalt();

        PBEKeySpec  spec = new PBEKeySpec(chars,salt,iteration,64*8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();

        return iteration +":" + Utility.toHex(salt) + ":" + Utility.toHex(hash);
    }

    private static byte[] getSalt() throws  NoSuchAlgorithmException{
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1,array);
        String hex = bi.toString(16);
        int paddingLength = (array.length *2) - hex.length();
        if(paddingLength > 0){
            return String.format("%0" + paddingLength + "d",0)+hex;

        }else{
            return hex;
        }
    }

    public String getRawIpAddr(){
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Log.d(LOGGER , Log.getStackTraceString(ex));
        }
        return null;
    }

    public String getRealIpAddr(){
        try {
            URL ipAdress = new URL(doUtility.IPCHECKURL);
            BufferedReader in = new BufferedReader(new InputStreamReader(ipAdress.openStream()));
            return in.readLine();

        } catch (Exception ex) {
            Log.d(LOGGER , Log.getStackTraceString(ex));
        }

        return null;
    }

}
