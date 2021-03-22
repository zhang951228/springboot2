package com.erayt.single.utility;

import java.util.UUID;

/**
 * @Auther: Z151
 * @Date: 2021/3/19 15:56
 */
public class RandomUtil {

    //得到32位的uuid
    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
