package designPattern.builder.demo;

/**
 * Builder： 构建者的抽象基类（有时会使用接口代替）。其定义了构建Product的抽象步骤，
 * 其实体类需要实现这些步骤。其会包含一个用来返回最终产品的方法Product getProduct()。
 *
 *
 */
public abstract class ComputerBuilder {
    public abstract void setUsbCount();
    public abstract void setKeyboard();
    public abstract void setDisplay();
    public abstract Computer getComputer();
}