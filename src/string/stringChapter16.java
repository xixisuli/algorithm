package string;

public class stringChapter16 {
    //给一个整数N，字符串由0，1组成，长度为N，在所有的组合中，0左边必有1的组合数有多少
    //0的数量一定不超过N/2
    //P[i] 代表[0，i-1]上的字符已经确定，且i-1位置上的值一定为1，穷举（i，N）位置的值一共有多少种
    //因为P[i-1]的值一定为1，P[i]的值可以为0，也可以为1，如果为1，那么剩下的可能性为P[i+1]
    //如果为0，那么i+1位置一定为1，剩下的可能性为P[i+2]
    //所以p[i] = p[i+1]+p[i+2]
    //P[N-1] = 1;
    //P[N-2] = 2;
    private static int getNum(int N){
        int pre = 1;
        int cur = 2;
        for(int i=N-3;i>=0;i--){
            int tmp = cur;
            cur = cur+pre;
            pre = tmp;
        }
        System.out.println(cur);
        return cur;
    }
    public static void main(String[] args) {
        getNum(8);
    }

}
