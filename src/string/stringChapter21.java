package string;

public class stringChapter21 {
    //*****
    //给定一个字符串，返回把str全部切成回文子串的最小分割数
    //使用动态规划，dp[i]为子串【i，len】至少要经过几次分割才能切成回文子串
    //假设 j>=i && j<len  如果[i,j]为回文字符串，那么dp[i]有可能等于dp[j+1]+1
    //使用一个二维数组记录i，j是否为一个回文字符串
    private static int minSplitNum(char[] str){
        int[] dp = new int[str.length+1];
        boolean[][] isHuiwen = new boolean[str.length][str.length];
        for(int i=0;i<str.length;i++){
            isHuiwen[i][i] = true;
        }
        int min = str.length-1;
        for(int i=str.length-1;i>=0;i--){
            dp[i] = Integer.MAX_VALUE;
            for(int j=i;j<=str.length-1;j++){
                if(str[j]==str[i] && j-i<2||isHuiwen[i+1][j-1]){
                    isHuiwen[i][j] = true;
                    dp[i] = Math.min(dp[i],dp[j+1]+1);
                }
            }
        }
        return dp[0];

    }






}
