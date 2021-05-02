package com.erayt.analysis.utility;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: Z151
 * @Date: 2021/4/30 16:43
 */
@Slf4j
public class ConfigFileUtil {

    public static String getKey(String key)  {
        try {
        Properties properties = new Properties();
        // 使用InPutStream流读取properties文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\ideaworkspace\\springboot2\\analysis\\src\\main\\resources\\application.properties"));
            properties.load(bufferedReader);
        // 获取key对应的value值
        return properties.getProperty(key);
        } catch (IOException e) {
            log.error("使用{}获取配置文件值错误。",key,e);
            return "";
        }
    }
}
