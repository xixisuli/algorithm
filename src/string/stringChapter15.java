package string;

import java.util.Deque;
import java.util.Stack;

public class stringChapter15 {
    //给定一个运算式，返回运算式的结果
    private static int calculateBracket(char[] str,int left,int right){
        Stack<String> stackNum = new Stack<String>();
        int lB = -1;
        int num = 0;
        for(int l = left;l<str.length&&str[l]!=')';l++){
            if(str[l]<='9'&& str[l]>='0'){
                num = num*10+str[l]-'0';
            }else if(str[l]!='('){
                //不是数字，不是括号，只能是符号，先把数字入栈，再把符号
                stackNum.push(Integer.toString(num));
            }
            if(str[l]=='('){
                lB = l;
            }else {
                stackNum.push(Integer.toString(num));
            }
        }
        return -1;
    }
    private static void calclate(Deque<String> deque,char operator){

    }
}
