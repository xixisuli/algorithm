package string;

import java.util.HashMap;
import java.util.Map;

public class stringChapter18 {
    //找到字符串最长无重复子串的长度
    //使用map，key为str里的字符，value为最近一次出现的位置
    //dp[i]为必需以第i个字符结尾的时候,最长无重复子串的长度
    //如果 dp[i-1] = len1
    // map[str[i]] = location
    // if(location>i-1-dp[i-1]) dp[i] = i-location
    // else dp[i] = dp[i-1]+1
    private static int getMaxLenSubStr(String string){
        if(string==null)
            return 0;
        char[] str = string.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int[] dp = new int[str.length];
        dp[0] = 1;
        map.put(str[0],0);
        int max = dp[0];
        for(int i=1;i<str.length;i++){
            if(!map.containsKey(str[i])){
                dp[i] = dp[i-1]+1;
            }else {
                int recentLoc = map.get(str[i]);
                if (recentLoc <= (i - 1 - dp[i - 1])) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = i - recentLoc;
                }
            }
            max = Math.max(max,dp[i]);
            map.put(str[i],i);
        }
        return max;
    }

    public static void main(String[] args) {
        String a = "abcabcdefgefg";
        System.out.println(getMaxLenSubStr(a));
    }
}
