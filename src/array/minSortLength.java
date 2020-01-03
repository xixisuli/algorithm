package array;

public class minSortLength {

    public static int minLenght(int[] arr){
        if(arr==null||arr.length<=1){
            return 0;
        }
        int before = arr.length-1;
        int min = arr[before];
        for(int i=before-1;i>=0;i--){
            if(min>=arr[i]){
                min = arr[i];
                continue;
            }
            before = i;
        }
        if(before==arr.length-1)
            return 0;
        int after = 0;
        int max =arr[after];
        for(int i = after+1;i<arr.length;i++){
            if(max<arr[i]){
                max = arr[i];
                continue;
            }
            after = i;
        }
        return after-before+1;
    }

    public static void main(String[] args) {
        int[] a = {1,5,3,2,6};
        System.out.println(minLenght(a));
        int[] b = {1,2,4};
        System.out.println(minLenght(b));
    }
}
