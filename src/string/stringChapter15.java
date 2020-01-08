package string;

import java.util.Stack;

public class stringChapter15 {
    //给定一个运算式，返回运算式的结果
    private static int calculateBracket(char[] str,int left,int right){
        Stack<String> stackNum = new Stack<String>();
        int lB = -1;
        int num = 0;
        for(int l = left;l<str.length;l++){
            if(str[l]=='('){
                lB = l;
            }else if(str[l]==')'){
                int res = calculateBracket(str,lB++,l--);
                stackNum.push(Integer.toString(res));
            }else if(str[l]<='9'&& str[l]>='0'){
                num = num*10+str[l]-'0';
            }else if(str[l]=='*'||str[l]=='/'){

            }
        }
    }
}
