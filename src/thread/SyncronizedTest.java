package thread;

public class SyncronizedTest {
    static Object lockValue = new Object();
    static boolean print1Signal = true;
    static boolean print2Signal = false;
    static boolean print3Signal = false;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    synchronized (lockValue) {
                        if (print1Signal) {
                            System.out.println("thread 1 run");
                            print1Signal = false;
                            print2Signal = true;
                            print3Signal = false;
                            lockValue.notifyAll();
                        } else {
                            try {
                                lockValue.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    synchronized (lockValue) {
                        if (print2Signal) {
                            System.out.println("thread 2 run");
                            print2Signal = false;
                            print3Signal = true;
                            print1Signal = false;
                            lockValue.notifyAll();
                        } else {
                            try {
                                lockValue.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    synchronized (lockValue) {
                        if (print3Signal) {
                            System.out.println("thread 3 run");
                            print2Signal = false;
                            print1Signal = true;
                            print3Signal = false;
                            lockValue.notifyAll();
                        } else {
                            try {
                                lockValue.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
    }
}
