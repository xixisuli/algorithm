package string;

import com.sun.corba.se.impl.orbutil.closure.Future;

import java.util.HashMap;
import java.util.Map;

public class find {
    private boolean stringChapter01(String s1,String s2){
        if(s1==null||s2==null||s1.length()!=s2.length()){
            return false;
        }
        char[] schars1 = s1.toCharArray();
        char[] schars2 = s2.toCharArray();
        int[] map = new int[256];
        for(int i=0;i<schars1.length;i++){
            map[schars1[i]]++;
        }
        for(int i=0;i<schars2.length;i++){
            if(map[schars2[i]]--==0){
                return false;
            }
        }
        return true;
    }
    private static double stringChapter02(String s){
        int sign = 0;
        double sum = 0;
        double currentNum = 0;
        int numBit = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                if(sign==1){
                    sign=0;
                    sum += currentNum;
                    currentNum = 0;
                    numBit = 0;
                }
                int num = s.charAt(i)-'0';
                currentNum = currentNum+num*Math.pow(10,numBit);
                numBit++;
            }else if(s.charAt(i)=='-'){
                currentNum*=-1;
                sign = 1;
            }else{
                sum += currentNum;
                currentNum = 0;
                numBit = 0;
                if(sign==1){
                    sign=0;
                    sum += currentNum;
                }
            }
        }
        return sum;
    }
    //去除字符串中连续出现的k个0
    private static String stringChapter03(String str,int k){
        int zeroNum = 0;
        int beginIndex = 0;
        int endIndex = 0;
        StringBuilder result = new StringBuilder();
        for(int i=0;i<str.length();i++){
            endIndex++;
            if(str.charAt(i)=='0'){
                zeroNum++;
            }else{
                if(zeroNum==k){
                    beginIndex = endIndex-1;
                }else {
                    result = result.append(str.substring(beginIndex, endIndex));
                    beginIndex = endIndex ;
                }
                zeroNum = 0;
            }
        }
        return result.toString();
    }
    //互为旋转词
    private static boolean stringChapter04(String str1,String str2){
        if(str1==null||str2==null||str1.length()!=str2.length()){
            return false;
        }
        StringBuilder temp = new StringBuilder();
        for(int i = 0;i<str1.length();i++){
            temp = temp.append(str1.substring(i+1,str1.length())).append(str1.substring(0,i+1));
            if(temp.toString().equals(str2)){
                return true;
            }
        }
        return false;
    }
    private static boolean stringChapter04Best(String str1,String str2){
        if(str1==null||str2==null||str1.length()!=str2.length()){
            return false;
        }
        String temp = str1+str1;
        //注意哦，contains内部不是使用的kmp算法，此处可以自己实现一个kmp算法
        //谷歌并翻了下StackOverflow：
        // 原来JDK的编写者们认为大多数情况下，字符串都不长，使用原始实现可能代价更低。因为KMP和Boyer-Moore算法都需要预先计算处理来获得辅助数组，
        // 需要一定的时间和空间，这可能在短字符串查找中相比较原始实现耗费更大的代价。而且一般大字符串查找时，程序员们也会使用其它特定的数据结构，查找起来更简单
        if(temp.contains(temp)){
            return true;
        }
        return false;
    }
    // 整数字符串转成整数值,注意不要越界
    private static int stringChapter05(String s1){
        if(!isValid(s1))
            return 0;
        int negative =s1.charAt(0)=='-'?-1:1;
        int num = 0;
        int maxValueCarray =(int)Math.pow(2,31)/10;
        int maxValueBit =(int)Math.pow(2,31)%10;
        for(int i=0;i< s1.length();i++){
            if(i==0&&negative==-1){
                continue;
            }
            int b = s1.charAt(i)-'0';
            int s= negative==-1?-num:num;
            if(s>maxValueCarray||s==maxValueCarray&&((negative==-1&&b>maxValueBit+1)||(negative==1&&b>maxValueBit)))
                return 0;
            num = num*10+negative*(s1.charAt(i)-'0');
        }
        return num;
    }
    private static boolean isValid(String s1){
        if(s1==null){
            return false;
        }
        if(s1.charAt(0)=='-'&&(s1.length()==1||s1.charAt(1)=='0'))
            return  false;
        if(s1.charAt(0)==0 && s1.length()>1)
            return false;
        boolean negative = s1.charAt(0)=='-'?true:false;
        int i = negative?1:0;
        for(;i<s1.length();i++){
            if(s1.charAt(i)<'0'||s1.charAt(i)>'9')
                return false;
        }
        return true;
    }
    // 替换字符串中出现的指定字符串

    // 给定一个字符串，输出统计字符串



    private static String stringstringChapter06(String str,String from,String to){
        if(str==null||from==null||to==null){
            return str;
        }
        char[] charStr = str.toCharArray();
        char[] fromStr = str.toCharArray();
        int match = 0;
        for(int i=0;i<charStr.length;i++){
            if(charStr[i]==fromStr[match++]){
                if(match>=to.length()){
                    while(match--!=0){
                        charStr[i-match] = '0';

                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<charStr.length;i++){
            if(charStr[i]=='0'){
                continue;
            }
            res = res.append(charStr[i]);
        }
        return res.toString();


    }



































    public static void main(String[] args) {
//        System.out.println(stringChapter02("A-1B--2C--D6E"));
//        System.out.println(stringChapter03("000CDFFF000",3));
//        System.out.println(stringChapter04("abcd","bcda"));
        System.out.println(stringChapter05("21474836110"));
    }
}
