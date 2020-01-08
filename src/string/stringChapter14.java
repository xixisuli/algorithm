package string;

public class stringChapter14 {
    //括号有效性判断 最长有效括号子串
    private static boolean isValid(String str){
        char[] strChar = str.toCharArray();
        int leftnum = 0;
        for(int i=0;i<str.length();i++){
            if(strChar[i]=='('){
                leftnum++;
                continue;
            }
            if(strChar[i]==')'&&--leftnum<0){
                return false;
            }
            if(strChar[i]!='('&&strChar[i]!=')')
                return false;

        }
        return true;
    }
    //给定一个括号字符串，给出最长有效括号子串
    private static String maxSubStr(String str){
        //dp[i]代表必需以第i个字符结尾的有效括号子串的长度
        char[] strs = str.toCharArray();
        int[] dp = new int[str.length()];
        int max = -1;
        for(int i=1;i<str.length();i++){
            if(strs[i]==')'){
                int l = i-dp[i-1]-1;
                if(l>=0&&strs[l]=='('){
                    dp[i] = dp[i-1]+2+(l-1>0?dp[l-1]:0);
                }
            }
            max = Math.max(max,dp[i]);
        }

        if(max==-1){
            return null;
        }
        String sub = str.substring(max-dp[max-1],max);
        return sub;
    }
    public static void main(String[] args) {
        String str = "()(())()()";
        System.out.println(maxSubStr(str));
    }
}
