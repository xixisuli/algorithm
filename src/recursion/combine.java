package recursion;

import java.util.ArrayList;
import java.util.List;

public class combine {
    public List<List<Integer>> combine(int n, int k) {
        if(k<0 || n<k){
            return null;
        }
        List<Integer> numList = new ArrayList<>();
        List<List<Integer>> returnList = new ArrayList<>();
        for(int i=1;i<=n;i++){
            numList.add(i);
        }
        for(int i=0;i<n;i++){
            List<Integer> sonList = new ArrayList<Integer>();
            sonList.add(numList.get(i));
            for(int j=i+1;j<=i+k-1;j++){
                sonList.add(numList.get(j));
            }
            for(int x = i+k;x<n;x++){
                returnList.add(sonList);
                int len = returnList.size();
                returnList.get(len-1).add(numList.get(x));
            }

        }
        return returnList;
    }

}
