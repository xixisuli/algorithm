import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        double sum = 0;
        for(int i = 1;i<=365*5;i++){
            sum = sum+0.000001*i;
            System.out.println("第"+i+"天："+0.000001*i*65000);
        }
        System.out.println(sum*65000);
    }
}
