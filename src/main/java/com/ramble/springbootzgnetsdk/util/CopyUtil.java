package com.ramble.springbootzgnetsdk.util;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Project     springboot-zgnetsdk
 * Package     com.ramble.springbootzgnetsdk.util
 * Class       CopyUtil
 * date        2024/1/24 10:48
 * author      cml
 * Email       liangchen_beijing@163.com
 * Description
 */
public class CopyUtil {
    public static void copyStringToArray(String str,byte[]byteArray)
    {
        Arrays.fill(byteArray,(byte)0);
        try{
            byte[] arry = str.getBytes(StandardCharsets.UTF_8);
            int len = byteArray.length<arry.length?byteArray.length:arry.length;
            System.arraycopy(arry,0,byteArray,0,len);//将arry复制到byteArray中
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
