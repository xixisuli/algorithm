public class bit {
    static void swap1(Integer a,Integer b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a+","+b);
    }
}
