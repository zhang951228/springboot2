import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: Z151
 * @Date: 2021/4/29 17:51
 */
@Slf4j
public class domain {

    @Test
    public void test1(){
        double a = 25/2;
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        log.info(String.valueOf(a));
        a = 27/2;
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
        log.info(String.valueOf(a));
    }

    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        // 使用InPutStream流读取properties文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\ideaworkspace\\springboot2\\analysis\\src\\main\\resources\\application.properties"));
        properties.load(bufferedReader);
        // 获取key对应的value值
        String property = properties.getProperty("import.fileSplitChar");
        log.info("A:"+property);
        String property2 = properties.getProperty("import.fileSplitChar2");
        log.info("B:"+property2);
    }
}
