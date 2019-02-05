package jmx;

/**
 * Created by gezz on 2019/1/11.
 */
public interface HelloMBean {
    public String getName();
    public void setName(String name);
    public void printHello();
    public void printHello(String whoName);
}