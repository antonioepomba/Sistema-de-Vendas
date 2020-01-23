package com.sales.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt
{
    public String encrypt(String password) throws NoSuchAlgorithmException
    {
        if (password.length()==0)
        {
            return null;
        }
        else
        {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(password.getBytes());
            byte[] hash = md.digest();
            StringBuffer senhaEncrip = new StringBuffer();
            for (int i=0;i<hash.length;i++)
            {
                senhaEncrip.append(Integer.toHexString(hash[i]&0xff));
            }
            return senhaEncrip.toString();
        }
    }

}
