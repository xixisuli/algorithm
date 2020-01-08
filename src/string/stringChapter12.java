package string;

public class stringChapter12 {
    //返回两个字符串之间的最短距离
    private static int shortestDistance(String[] strs,String str1,String str2){
        int str1Location = -1;
        int str2Location = -1;
        int minShort = -1;
        for(int i=0;i<strs.length;i++){
            if(strs[i].equals(str1)){
                str1Location = i;
                if(str2Location!=-1){
                    minShort = i-str2Location;
                }
            }
            if(strs[i].equals(str2)){
                str2Location = i;
                if(str1Location!=-1){
                    minShort = i-str1Location;
                }
            }
        }
        return minShort;
    }

    public static void main(String[] args) {
        String[] strs = {"ab","tt","cd","ab"};
        System.out.println(shortestDistance(strs,"ab","cd"));
    }




}
