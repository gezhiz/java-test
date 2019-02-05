import org.junit.Test;
import sun.misc.Unsafe;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    @Test
    public void testJava() {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i & 1);
//        }
//
        new ConcurrentHashMap<String,Object>();
    }

    @Test
    public void testIntOverflow() {
        System.out.println(Integer.MAX_VALUE + 1);//结果：-2147483648
        System.out.println(Integer.MIN_VALUE - 1);//结果：2147483647
    }

    @Test
    public void testUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        System.out.println(unsafe);
    }

//    private static int LIST_SIZE = 10;
//    private static String[] list = new String[LIST_SIZE];
//    @Test
//    public void testNonVolatile() throws InterruptedException {
//        new Thread(new MyRun(0,"gezz")).start();
//        new Thread(new MyRun(0,"worthto")).start();
//        System.out.println(list[0]);
//    }
//
//    public static synchronized void seti(int i, String value) {
//        if (i >= LIST_SIZE) {
//            throw new IllegalArgumentException();
//        }
//        if (list[i] == null) {
//            System.out.println("execute:" + value);
//            list[i] = value;
//            System.out.println("list[i]:" + list[i]);
//        }
//    }
//    public static class MyRun implements Runnable {
//        private String value;
//        private int i;
//
//        public MyRun(int i, String value) {
//            this.value = value;
//            this.i = i;
//        }
//
//        @Override
//        public void run() {
//
//            seti(i,value);
//        }
//    }
}
