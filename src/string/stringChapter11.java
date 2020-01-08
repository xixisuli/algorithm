package string;

public class stringChapter11 {
    //翻转字符串
    //单词逆序调整
    //思路，先整体逆序，再挨个单词逆序就好
    private static void reverse(char[] str){
        for(int i=0;i<str.length/2;i++){
            swap(str,i,str.length-i-1);
        }
        System.out.println(str);
        for(int i=0,j=i;i<str.length;i++){
            if(str[i]==' '){
                if(j<i){
                    int t = i;
                    for(int x=j;x<(i+j+1)/2;x++){
                        swap(str,x,--t);
                    }
                }
                j = i;
                j++;
            }
        }
    }
    private static void swap(char[] str, int i,int j){
        char a=str[i];
        str[i] = str[j];
        str[j] = a;
    }
    //请把大小为size的左半区移动到右半区，右半区移动到左半区
    private static void moveBlock(int size,char[] array){
         reverseUtil(array,0,array.length-1);
         reverseUtil(array,0,array.length-size-1);
        reverseUtil(array,array.length-size,array.length-1);
    }
    private static void reverseUtil(char[] array,int l,int r){
        while(l<r){
            char temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        char[] str = "a big pigs".toCharArray();
        reverse(str);
        char[] str1 = "ABCDE".toCharArray();
        moveBlock(3,str1);
        System.out.println(str1);
    }

}
