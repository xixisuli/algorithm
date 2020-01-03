package array;

import java.util.HashMap;
import java.util.Map;

public class findKNum {
    private static void exitHalfNum(int[] arr){
        int candinate = 0;
        int num = 0;
        for(int i = 0;i<arr.length;i++){
            if(num==0){
                candinate = arr[i];
                num++;
            }else if(arr[i]!=candinate){
                num--;
            }else{
                num++;
            }
        }
        num=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==candinate){
                num++;
            }
        }
        if(num>arr.length/2){
             System.out.println("the num is "+candinate);
        }else{
            System.out.println("cannot find the num");
        }
    }
    private static void exitNum(int[] arr,int k){
        int[]candinate = new int[k-1];
        int[] num = new int[k-1];
        for(int i =0;i<k-1;i++){
            candinate[i] = 0;
            num[i] = 0;
        }
        for(int i = 0;i<arr.length;i++){
            boolean flag = false;
            for (int j=0;j<k-1;j++){
                if(candinate[j]==arr[i]){
                    num[j]++;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                for(int j = 0;j<k-1;j++){
                    if(num[j]<=0){
                        candinate[j] = arr[i];
                        num[j]=1;
                    }
                }
                for(int j = 0;j<k-1;j++){
                    if(num[j]!=0){
                        num[j]--;
                    }
                }
            }
        }
        for(int j = 0;j<num.length;j++){
            if(num[j]>0){
                int len = 0;
                for(int i=0;i<arr.length;i++){
                    if(arr[i]==candinate[j]){
                        len++;
                    }
                }
                if(len>arr.length/k){
                    System.out.println("result num is "+candinate[j]);
                }
            }
        }
    }
    private static void exitNum1(int[] arr,int k){
        HashMap<Integer,Integer> candinate = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            if(candinate.containsKey(arr[i])){
                    candinate.put(arr[i],candinate.get(arr[i])+1);
            }else{
                if(candinate.size()==k-1){
                    for(Map.Entry<Integer,Integer> e:candinate.entrySet()){
                        int count = candinate.get(e.getKey())-1;
                        if(count==0){
                            candinate.remove(e.getKey());
                        }else{
                            candinate.put(e.getKey(),count);
                        }
                    }
                }else{
                    candinate.put(arr[i],1);
                }
            }
        }
        for(Map.Entry<Integer,Integer> e:candinate.entrySet()){
            if(e.getValue()>0){
                int len = 0;
                for(int i=0;i<arr.length;i++){
                    if(arr[i]==e.getKey()){
                        len++;
                    }
                }
                if(len>arr.length/k){
                    System.out.println("result num is "+e.getKey());
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[]a = {1,1,0,0,0};
//        exitNum(a,2);

        for(int j = 1;j<=7;j++) {
            double l = 0;
            double sum = 0;
            for (int i = 1; i <= 365 * j; i++) {
                l = l + 0.000001;
                sum = sum + l;
            }
            int s =(int)(sum*100000);
            System.out.println(j+"年："+s+"元");
        }

    }
}
