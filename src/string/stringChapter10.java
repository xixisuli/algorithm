package string;

public class stringChapter10 {
    //字符串的调整与替换
    private static char[] replaceStr(char[] str){
        if(str==null||str.length<=0){
            return str;
        }
        int nullCharNum = 0;
        int charNum = 0;
        for(int i=0;i<str.length;i++){
            if(str[i]==' '){
                nullCharNum++;
            }else{
                charNum++;
            }
        }
        int newNum = nullCharNum*3+charNum;
        for(int i=str.length-1;i>=0;i--){

            if(str[i]==' '){
                int j = 3;
                str[--newNum] = '0';
                str[--newNum] = '2';
                str[--newNum] = '%';
            }else {
                str[--newNum] = str[i];
            }
        }
        return str;
    }
    //把*挪到char左边
    private static void replace(char[] str){
        int j = str.length-1;
        for(int i=str.length-1;i>=0;i--){
            if(str[i]!='*'){
                str[j--] = str[i];
            }
        }
        for(;j>=0;j--){
            str[j--] = '*';
        }
    }

    public static void main(String[] args) {
//        char[] str="aa b c t".toCharArray();
//        replaceStr(str);
        char[] str2 = "**ab*c".toCharArray();
        replace(str2);
        System.out.println(str2);
    }
}
