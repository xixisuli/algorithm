package string;

public class stringChapter08 {
    // 判断字符数组中是否所有的字符都只出现过一次
    // 要求额外空间复杂度为O(1)
    // 思路是先排序
    // 排序的几种方式：快排、堆排、冒泡、
    private static int patition(int left,int right,int[] array){
        int partition = left;
        int partiNum = array[left];
        for(int i = left;i<=right;i++) {
            if (array[i] < array[partition]) {
                int temp = partiNum;
                array[partition] = array[i];
                array[i] = temp;
                partition = i;
            }
        }
        return partition;

    }
    private static void quickSort(int left,int right,int[] array){
        if(left<right){
            int partitionIndex = patition(left,right,array);
            quickSort(left,partitionIndex-1,array);
            quickSort(partitionIndex+1,right,array);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{6,4,5,1};
        quickSort(0,array.length-1,array);
        for(int i=0;i<=array.length-1;i++){
            System.out.println(array[i]);
        }
    }
}
