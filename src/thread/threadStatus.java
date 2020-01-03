//package thread;
//
//public class threadStatus {
//    private static void printWithThread(String content) {
//        System.out.println("[" + Thread.currentThread().getName() + "线程]: " + content);
//    }
//    public void produce() {
//        synchronized (this) {
//            while (mBuf.isFull()) {
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            mBuf.add();
//            notifyAll();
//        }
//    }
//
//    public void consume() {
//        synchronized (this) {
//            while (mBuf.isEmpty()) {
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            mBuf.remove();
//            notifyAll();
//        }
//
//    }
//    public static void main(String[] args) {
//        System.out.println("main start");
//        Thread mythread = new Thread(()->{
//            printWithThread("我在自定义的thread的run方法里面");
//            printWithThread("我马上要休息，要出让cpu");
//            try {
//                Thread.sleep(1000);
//                printWithThread("重新获取cpu,马上要退出");
//            }catch (InterruptedException e){
//                System.out.println(e);
//            }
//        });
//        try{
//            mythread.start();
//            printWithThread("我在main里面，join之前");
//            mythread.join(500);
//            printWithThread("我在main方法里面，join之后");
//        }catch (InterruptedException e){
//
//        }
//    }
//}
