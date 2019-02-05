package proxy;

import java.lang.reflect.*;

/**
 * 代理处理类
 * Created by gezz on 2019/1/12.
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke" + method.getName());
        Object result = method.invoke(target,args);
        System.out.println("after invoke" + method.getName());
        return result;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
