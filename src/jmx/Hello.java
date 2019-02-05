package jmx;

/**
 * 这个就是MBean
 * Created by gezz on 2019/1/11.
 */
public class Hello implements HelloMBean {
    private String name;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printHello() {
        System.out.println("Hello world, "+ name);
    }

    @Override
    public void printHello(String whoName) {
        System.out.println("Hello, "+whoName);
    }
}
