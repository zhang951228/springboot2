package designPattern.builder;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


/**
 * @Auther: Z151
 * @Date: 2021/4/22 16:23
 */

@Slf4j
class QuestionsTest {

    @Test
    public void createQuestions(){
        Questions questions = new Questions.Bulder(1).setName("试题1").setRegion("从A到B").build();
        log.info(String.valueOf(questions));
        log.info(String.valueOf(questions));

    }

}