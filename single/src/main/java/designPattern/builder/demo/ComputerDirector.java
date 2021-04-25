package designPattern.builder.demo;

/**
 * Director: 决定如何构建最终产品的算法. 其会包含一个负责组装的方法void Construct(Builder builder)，
 * 在这个方法中通过调用builder的方法，就可以设置builder，等设置完成后，就可以通过builder的 getProduct() 方法获得最终的产品。
 */
public class ComputerDirector {
    public void makeComputer(ComputerBuilder builder){
        builder.setUsbCount();
        builder.setDisplay();
        builder.setKeyboard();
    }
}