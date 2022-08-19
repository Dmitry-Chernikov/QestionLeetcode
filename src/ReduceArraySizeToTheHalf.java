import java.util.*;
import java.util.stream.Stream;

/**
 * ReduceArraySizeToTheHalf
 * 1338. Reduce Array Size to The Half
 * @author :Dmitry_Chernikov
 * @version :0.0.0
 * @since :2022-08-18, чт, 9:53
 */
public class ReduceArraySizeToTheHalf {
    public int minSetSize(int[] arr) {
        if (2 <= arr.length && arr.length <= Math.pow(10,5) && arr.length%2==0) {
            HashMap<Integer, Integer> subMap = new HashMap<Integer, Integer>();
            int res = 0, cnt = 0, maxValueInMap = 0;
            int j = arr.length;

            while (j-- > 0) {
                if (subMap.containsKey(arr[j])) {
                    subMap.put(arr[j], subMap.get(arr[j])+1);
                } else {
                    subMap.put(arr[j], 1);
                }
            }

            ArrayList<Integer> list = new ArrayList<>(subMap.values());

            while (res < Math.floorDiv(arr.length, 2)) {
                maxValueInMap = (Collections.max(subMap.values()));
                res += maxValueInMap;
                cnt++;
                for (Map.Entry<Integer, Integer> entry : subMap.entrySet()) {
                    if (entry.getValue() == maxValueInMap) {
                        subMap.remove(entry.getKey());
                        break;
                    }
                }
            }
            return cnt;
        }else{
            return arr.length - 1 ;
        }

//        HashMap<Integer, Integer> subMap = new HashMap<Integer, Integer>();
//        int len = arr.length;
//        for(int i=len-1; i!=0; i--){
//            subMap.put(arr[i],subMap.getOrDefault(arr[i],0)+1);
//        }

//        int [] freqarr=new int[subMap.size()];
//        for(int key: subMap.keySet()){
//                freqarr[subMap.get(key)]++;
//        }
//
//        int size=arr.length;int count=0;
//
//        for(int i=freqarr.length-1;i>=0 && size>arr.length/2;){ // traverse array in rev order to greedily choose the max frequency
//            if(freqarr[i]==0){
//                i--;
//            }else{ // keep reducing the size till freq[i]==0 -> use up all high freq elements
//                while(freqarr[i]!=0 && size>arr.length/2){
//                    size-=i;
//                    freqarr[i]--;
//                    count++;
//                }
//                if(size<=arr.length/2) return count;
//                i--;
//            }
//        }
//        return count;
    }
}
