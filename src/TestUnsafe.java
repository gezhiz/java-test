import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by gezz on 2018/5/15.
 */
public class TestUnsafe {
    public static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    /**
     * 寻址操作
     */
    @Test
    public void addressOperate() {
        Entry[] entries = new Entry[10];
        int itemScale = unsafe.arrayIndexScale(Entry[].class);//每一个元素的增量
//        int shift = 31 - Integer.numberOfLeadingZeros(itemScale);
        int base = unsafe.arrayBaseOffset(Entry[].class);//数组第一个元素的地址偏移量
        for (int j = 0; j < entries.length; j++) {
            Entry entry = new Entry();
            unsafe.putOrderedObject(entries,base + (long)j * itemScale, entry);
        }
        int i = 3;//第i个元素
        Entry entry = (Entry) unsafe.getObjectVolatile(entries,base + (long)i * itemScale);
        entry.i = 10;
        for (Entry entryItem : entries) {
            if (entryItem != null) {
                System.out.println(entryItem.i);
            }
        }

    }

    @Test
    public void testLeftShift() {
        System.out.println(0l << 2);

        int itemScale = 4;
        int shift = 31 - Integer.numberOfLeadingZeros(itemScale);
        System.out.println("shift:" + shift);
        for (long i = 0l; i < 10l; i++) {
            System.out.println(i << shift);
        }
        System.out.println("乘积的结果如下：");
        for (long i = 0l; i < 10l; i++) {
            System.out.println(i * itemScale);
        }
    }

    /**
     * 寻址操作2:使用位偏移量
     */
    @Test
    public void addressOperate1() {
        Entry[] entries = new Entry[10];
        int itemScale = unsafe.arrayIndexScale(Entry[].class);//每一个元素的增量
        int shift = 31 - Integer.numberOfLeadingZeros(itemScale);//返回这个数据的二进制串中从最左边算起连续
        int base = unsafe.arrayBaseOffset(Entry[].class);//数组第一个元素的地址偏移量

        for (int j = 0; j < entries.length; j++) {
            Entry entry = new Entry();
            unsafe.putOrderedObject(entries,base + ((long)j << shift), entry);
        }
        int i = 3;//第i个元素
        Entry entry = (Entry) unsafe.getObjectVolatile(entries,base + ((long)i << shift));
        entry.i = 10;
        for (Entry entryItem : entries) {
            if (entryItem != null) {
                System.out.println(entryItem.i);
            }
        }

    }

    class Entry {
        public int i = 0;
        public int j = 0;
        public Entry next;
    }

}
