package string;

import java.util.HashMap;

public class stringChapter20 {
    //*****
    //给定字符串str1，给定str1包含str2所有字符的最小子串长度
    private static int getMinSub(char[] str1,char[] str2){
        int match = str2.length;
        int[] valueMap = new int[256];
        for(int i=0;i<str2.length;i++){
            valueMap[str2[i]]++;
        }
        int left = 0 ;
        int right  = 0;
        int min = Integer.MAX_VALUE;
        while(right<str1.length){
            valueMap[str1[right]]--;
            if(valueMap[str1[right]]>=0){
                match--;
            }
            if(match==0){
                while(valueMap[str1[left]]<0){
                    valueMap[str1[left++]]++;
                }
                min = Math.min(min,right-left+1);
                match++;
                valueMap[str1[left++]]++;
            }
            right++;
        }
        return min==Integer.MAX_VALUE?0:min;
    }

    public static void main(String[] args) {
        System.out.println(getMinSub("abcddedf".toCharArray(),"def".toCharArray()));
    }

}
