package proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * Created by gezz on 2019/1/12.
 */
public class Test {

    public static void main(String args[]) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //这是HelloWorld接口的一个代理class，有jdk动态生成，所以叫做jdk动态代理
        Class<?> proxyClass = Proxy.getProxyClass(Test.class.getClassLoader(),HelloWorld.class);

        //得到代理Class的构造函数
        final Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);

        //创建被代理对象
        HelloWorldImpl helloWorldImpl = new HelloWorldImpl();
        //创建一个Handler类
        final InvocationHandler myInvocationHandler = new MyInvocationHandler(helloWorldImpl);

        // 生成一个proxyClass代理对象，HelloWorld的对象
        HelloWorld proxy = (HelloWorld) constructor.newInstance(myInvocationHandler);//使用代理Class构造函数创建一个代理对象
        proxy.sayHello();
    }
}
