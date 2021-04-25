package designPattern.builder;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: Z151
 * @Date: 2021/4/22 16:11
 *
 * 测试使用构造者模式进行操作。
 *  参考代码： https://zhuanlan.zhihu.com/p/58093669
 * 环境描述： 阅卷过程中存在一个试题,ID，必须填写，但是试题名称、区域选填。构造结束后返回该试题对象。
 */
@ToString
public class Questions {
    @Setter(AccessLevel.NONE)//禁止生成该字段的set方法。
    private final Integer id;
    private String name;
    private String region;

    //TODO:进阶版:抽取出去，使用接口来实现。
    static class Bulder{
        /** 试题id值，唯一，不允许修改。 **/
        private Integer id;
        private String name;
        private String region;

        public Bulder(Integer id){
            this.id = id;
        }

        public Bulder setName(String name){
            this.name = name;
            return this;
        }

        public Bulder setRegion(String region){
            this.region = region;
            return  this;
        }

        public Questions build(){
            return new Questions(this);
        }
    }

    private Questions(Bulder bulder){
        this.id = bulder.id;
        this.name = bulder.name;
        this.region = bulder.region;
    }
}
