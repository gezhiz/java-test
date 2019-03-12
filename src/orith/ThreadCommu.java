package orith;

/**
 * 两个线程交叉打印
 * 1B2B3C4D
 * Created by gezz on 2019/3/12.
 */
public class ThreadCommu {

    private boolean isNum = true;

    public synchronized void printChar(char c) {
        while(isNum) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!isNum) {
            System.out.print(c);
            isNum = true;
            notifyAll();
        }
    }

    public synchronized void printNum(int n) {
        while(!isNum) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (isNum) {
            System.out.print(n);
            isNum = false;
            notifyAll();
        }

    }

    public static void main(String[] args) {
        ThreadCommu threadCommu = new ThreadCommu();
        final int count = 23;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while (true) {
                    threadCommu.printNum(i++);
                    if (i > count) {
                        break;
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                char  c = 'A';
                while (true) {
                    threadCommu.printChar(c++);
                    i++;
                    if (i > count) {
                        break;
                    }
                }
            }
        });
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
