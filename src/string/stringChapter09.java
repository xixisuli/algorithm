package string;

public class stringChapter09 {
    //在有序但含有null的数组中查找字符串
    private static int find(String[] strArr,String target){
        if(target==null||strArr==null){
            return -1;
        }
        int left = 0;
        int right = strArr.length-1;

        int index = -1;
        while(left<=right){
            int mid = (right+left)/2;
            if(strArr[mid]==null){
                int i = mid;
                while(strArr[i]==null&&--i>=left);
                if(i<left||strArr[i].compareTo(target)<0){
                    left = mid+1;
                }else{
                    right = i;
                }
                continue;
            }
            if(strArr[mid]!=null&&strArr[mid].compareTo(target)>0){
                left = mid+1;
                continue;
            }
            if(strArr[mid].compareTo(target)<=0){
                if(strArr[mid].compareTo(target)==0) {
                    index = mid;
                }
                right = mid-1;
                continue;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String[] strArr = {null,"a","a",null,null,"b",null,"b","c"};
        int a = find(strArr,"b");
        System.out.println(a);
    }
}
