package array;

import javafx.scene.transform.MatrixType;

import java.util.HashMap;
import java.util.Map;

public class subArrLength {
    //未排序正数数组中等于给定值的最大子数组长度
    public static int equalsNum(int[] arr,int givenNum){
        if(arr==null||arr.length<=0)
            return 0;
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int maxLength = 0;
        while(right<arr.length){
            if(sum>givenNum){
                sum = sum-arr[left++];
            }else if(sum<givenNum){
                right++;
                if(right>=arr.length){
                    break;
                }
                sum = sum+arr[right];
            }else{
                maxLength = maxLength>right-left+1?maxLength:right-left+1;
                sum = sum - arr[left++];
            }
        }
        return maxLength;
    }
    //未排序数组中（可正可负可0）等于给定值的最大子数组长度
    public static int equalNum2(int[]arr,int givenNum){
        if(arr==null||arr.length<=0){
            return 0;
        }
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        int sum = 0;
        sumMap.put(0,-1);
        int maxLenght = 0;
        for(int i =0;i<arr.length;i++){
            sum = sum+arr[i];
            if(!sumMap.containsKey(sum)) {
                sumMap.put(sum, i);
            }
            if(sumMap.containsKey(sum-givenNum)){
                int j = sumMap.get(sum-givenNum);
//                System.out.println("i: "+i+" and j: "+j);
                maxLenght = maxLenght>i-j?maxLenght:i-j;
            }
        }
        return maxLenght;
    }
    public static int equalNum3(int[]arr,int givenNum){
        int sum = 0;
        int[] b = new int[arr.length+1];
        b[0] = 0;

        for(int i = 0;i<arr.length;i++){
            sum = sum+arr[i];
            b[i+1] = Math.max(sum,b[i]);
        }
        sum = 0;
        int max = -1;
        for(int i = 0;i<arr.length;i++){
            sum = sum + arr[i];
            int len = 0;
            int pre = getLessIndex(b ,sum-givenNum);
            if(pre!=-1){
                len = pre==-1?0:i-pre+1;
            }
            max = len>max?len:max;
        }
        return max;
    }
    public static int getLessIndex(int[]arr,int num){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        int res = -1;
        while(low<=high){
            mid = (low+high)/2;
            if(arr[mid]>=num){
                res=mid;
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={6,1,2,3,5};
//        System.out.println(equalsNum(arr,6));
//        System.out.println(equalNum2(arr,6));
        System.out.println(equalNum3(arr,6));
    }
}
