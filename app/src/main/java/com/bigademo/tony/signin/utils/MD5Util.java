package com.bigademo.tony.signin.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Tony on 2017/4/25.
 */

public class MD5Util {
    public MD5Util() {
        super();
    }

    public static String MD5(String arg4) {
        MessageDigest v1=null;
        try {
            v1 = MessageDigest.getInstance("MD5");
        }
        catch(NoSuchAlgorithmException v3) {
        }

        v1.reset();
        v1.update(arg4.getBytes());
        return MD5Util.toHexString(v1.digest(), "");
    }

    private static String toHexString(byte[] arg7, String arg8) {
        StringBuilder v1 = new StringBuilder();
        int v4 = arg7.length;
        int v3;
        for(v3 = 0; v3 < v4; ++v3) {
            int v0 = arg7[v3];
            if(Integer.toHexString(v0 & 255).length() < 2) {
                v1.append("0");
            }

            v1.append(Integer.toHexString(v0 & 255)).append(arg8);
        }

        return v1.toString();
    }
}