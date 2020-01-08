package string;

public class stringChapter13 {
    //添加最少字符使字符串整体都是回文字符串
    //dp[i][j]含义代表str[i..j]最少添加几个字符可以使str[i..j]整体都是回文串，如何求dp数组
    //如果i..j只有一个字符，那么dp[i][j]的值显然为0
    //如果i..j只有两个字符，如果两个字符相等，dp[i][j] =0,
    // 如果不相等，dp[i][j] = 1j
    //如果i..j两个字符以上，
    // 如果str[i] = str[j],dp[i][j] = dp[i+1][j-1]
    // 如果str[i]!= str[j],dp[i][j] = min{dp[i+1][j],dp[i][j-1]}+1
    private static int[][] getDp(char[] str){
        int[][] dp = new int[str.length][str.length];
        for(int i=1;i<dp[0].length;i++){
            dp[i-1][i] = str[i-1]==str[i]?0:1;
            for(int j = i+1;j<dp[0].length;j++){
                if(str[i]==str[j]){
                    dp[i][j] = dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp;
    }
    private static char[] getHuiwen(char[] str){
        int[][] dp = getDp(str);
        char[] newStr = new char[str.length+dp[0][str.length-1]];
        int i = 0;
        int j = str.length-1;
        int resl = 0;
        int resr = newStr.length-1;
        while(i<j){
            if(str[i]==str[j]){
                newStr[resl++] = str[i];
                newStr[resr--] = str[i];
            }else if(dp[i+1][j]<dp[i][j-1]){
                newStr[resr--] = str[i];
                newStr[resl++] = str[i];
            }else{
                newStr[resl++] = str[j];
                newStr[resr--] = str[j];
            }
        }
        return newStr;
    }


}
