package thread;

import sun.misc.Unsafe;
import sun.print.PrintJob2D;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    static CountDownLatch startThread1Signal = new CountDownLatch(1);
    static CountDownLatch startThread2Signal = new CountDownLatch(1);
    static CountDownLatch startThread3Signal = new CountDownLatch(1);
    static class PrintStart1 implements Runnable{
        private String printSomething;
        PrintStart1(String printSomething){
            this.printSomething = printSomething;
        }
        @Override
        public void run() {
            try {
                for(;;) {
                    startThread1Signal.await();
                    System.out.println(printSomething);
                    startThread1Signal = new CountDownLatch(1);
                    startThread2Signal.countDown();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    static class PrintStart2 implements Runnable{

        private String printSomething;
        PrintStart2(String printSomething){
            this.printSomething = printSomething;
        }
        @Override
        public void run() {
            try {
                for(;;) {
                    startThread2Signal.await();
                    System.out.println(printSomething);
                    startThread2Signal = new CountDownLatch(1);
                    startThread3Signal.countDown();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    static class PrintStart3 implements Runnable{

        private String printSomething;
        PrintStart3(String printSomething){
            this.printSomething = printSomething;
        }
        @Override
        public void run() {
            try {
                for(;;) {
                    startThread3Signal.await();
                    System.out.println(printSomething);

                    startThread3Signal = new CountDownLatch(1);
                    startThread1Signal.countDown();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        try {
//            startThread1Signal.countDown();
//            new Thread(new PrintStart1("Thread 1 run")).start();
//            new Thread(new PrintStart2("Thread 2 run")).start();
//            new Thread(new PrintStart3("Thread 3 run")).start();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
        List<String> ads =new ArrayList<String>();
        ads.get(0);
    }
}