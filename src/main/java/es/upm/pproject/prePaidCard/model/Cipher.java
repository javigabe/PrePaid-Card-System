package es.upm.pproject.prePaidCard.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cipher {

    private static final Logger LOGGER = Logger.getLogger("Cipher");

    public String cipher(String passwordToHash) {
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            //Add password bytes to digest
            md.update(passwordToHash.getBytes());

            //Get the hash's bytes
            byte[] bytes = md.digest();

            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            //Get complete hashed password in hex format
            return sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            LOGGER.log(Level.SEVERE, "Fallo en cifrado");
            return null;
        }
    }
}
