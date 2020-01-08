package string;

import java.util.ResourceBundle;

public class stringChapter08 {
    // 判断字符数组中是否所有的字符都只出现过一次
    // 要求额外空间复杂度为O(1)
    // 思路是先排序，哪些排序算法的额外空间复杂度为O(1):
    // 插入排序：直接插入和希尔
    // 选择排序：简单选择和堆排序
    // 交换排序：冒泡  （快排不是）
    // 归并不是，桶不是、基数排序
    // 以上几种，时间复杂度最好的应该就是堆排序了，那就先选用堆排序

    private static boolean isOneTime(String str)
    {
        char[] strChar = str.toCharArray();
        for(int i=str.length()-1;i>0;i--){
            heapAdjust(i,strChar);
            swap(0,i,strChar);
        }
        System.out.println(strChar);
        for(int i = 0;i<strChar.length-1;i++){
            if(strChar[i]==strChar[i+1]){
                return true;
            }
        }
        return false;

    }
    private static void heapAdjust(int n,char[] strChar){
        for(int i=(n-1)/2;i>=0;i--){
            int childIndex = 2*i+1;
            if(childIndex!=n && strChar[childIndex+1]>strChar[childIndex]){
                childIndex++;
            }
            if(strChar[i]<strChar[childIndex]){
                swap(i,childIndex,strChar);
            }
        }
    }













    //交换排序：快排 和 冒泡
    //快排属于交换排序，可以简单理解为 挖坑+分而治之
    //时间复杂度nlog(n)   空间复杂度
    private static int patition(int l,int r,int[] array){
        int pivot = array[l];
        while(l<r){
            while(r>l&&array[r]>pivot) {
                r--;
            }
            array[l] = array[r];
            while(l<r&&array[l]<pivot) {
                l++;
            }
            array[r] = array[l];
        }
        array[l] = pivot;
        return l;

    }
    private static void quickSort(int left,int right,int[] array){
        if(left<right){
            int partitionIndex = patition(left,right,array);
            quickSort(left,partitionIndex-1,array);
            quickSort(partitionIndex+1,right,array);
        }
    }
    private static void swap(int m,int n,char[]array){
        char temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }
    private static void swap(int m,int n,int[]array){
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }
    // 比较两个元素，顺序错误就交换 时间复杂度O(n2) 空间复杂度O(1) 稳定
    private static void maopao(int[] array){
        for(int i =0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]<array[j]){
                    swap(i,j,array);
                }
            }
        }
    }
    //选择sort
    //简单选择是在比较时记下位置，最后来交换，冒泡是比较时就交换，交换过程不一样，但是查找过程一样
    //不稳定，时间复杂度O(n2) 空间复杂度O(1)
    private static void selectSort(int[] array)
    {
        for(int i =0;i<array.length;i++){
            int small = i;
            for(int j = i;j<array.length;j++){
                if(array[j]<array[small]){
                    small = j;
                }
            }
            if(small!=i){
                swap(i,small,array);
            }
        }
    }
    //堆排序:先建立堆，然后调整最大值，再建堆，再调整值。。。。
    //建立堆的过程, 从length/2 一直处理到0, 时间复杂度为O(n);
    //调整堆的过程是沿着堆的父子节点进行调整, 执行次数为堆的深度, 时间复杂度为O(lgn);
    //堆排序的过程由n次第2步完成, 时间复杂度为O(nlgn).
    //总时间复杂度就是：n+nlog（n） = nlog(n)
    //空间复杂度为O(1)
    //不稳定
    private static void heapSort(int[] array){
        heapMax(array.length-1,array);
        for(int i = array.length-1;i>0;i--) {
            swap(0,i,array);
            heapAdj(i-1,array);
        }
    }
    private static void heapMax(int n,int[] array){
        //完全二叉树性质
        // 满二叉树深度为k（层数从0开始），则节点个数为2^(𝑘+1)−1
        // 第一个非叶子节点
        // 这个的函数时间复杂度为log(n)
        for(int i = (n-1)/2;i>=0;i--){
            int left  = 2*i+1;
            int child = left;
            if(child!=n&&array[child]<array[child+1]){
                child++;
            }
            if(array[i]<array[child]){
                swap(i,child,array);
            }
        }
    }
    private static void heapAdj(int n,int[] array){
        int i=0;
        int child = 2*i+1;
        while(child<=n){
            if(child<n && array[child]<array[child+1]){
                child++;
            }
            if(array[i]<array[child]){
                swap(i,child,array);
            }else{
                break;
            }
            i = child;
            child = 2*i+1;
        }
    }
    //插入排序
    //通常人们整理桥牌的方法是一张一张的来，将每一张牌插入到其他已经有序的牌中的适当位置。
    // 在计算机的实现中，为了要给插入的元素腾出空间，我们需要将其余所有元素在插入之前都向右移动一位。

    private static void insertSort(int[] array){
        for(int i=1;i<array.length;i++){
           for(int j=i;j>0;j--){
               if(array[j]<array[j-1]){
                   swap(j-1,j,array);
               }
           }
        }
    }
    public static void main(String[] args) {
        int[] array = new int[]{1,5,3,2,4};
//        maopao(array);
//        selectSort(array);
        heapSort(array);
//        insertSort(array);
//        String str = "aabdcybglmvxzdn";
//        isOneTime(str);
        for(int i=0;i<=array.length-1;i++){
            System.out.println(array[i]);
        }
    }
}
