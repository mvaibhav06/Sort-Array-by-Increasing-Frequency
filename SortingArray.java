import java.util.*;

public class SortingArray {
    public static int[] frequencySort(int[] nums){
        HashMap<Integer,Integer> temp = new HashMap<>();

        for (int i=0; i< nums.length; i++){
            if (temp.containsKey(nums[i])){
                temp.put(nums[i], temp.get(nums[i])+1);
            }else {
                temp.put(nums[i], 1);
            }
        }

        List<Map.Entry<Integer,Integer>> myList = new ArrayList<>(temp.entrySet());

        Comparator<Map.Entry<Integer,Integer>> myComparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int compare = o1.getValue().compareTo(o2.getValue());
                if (compare == 0){
                    return o2.getKey().compareTo(o1.getKey());
                }
                return compare;
            }
        };

        Collections.sort(myList, myComparator);

        int[] out = new int[nums.length];
        int k=0;
        for (int i=0; i<myList.size(); i++){
            for (int j=0; j<myList.get(i).getValue(); j++){
                out[k] = myList.get(i).getKey();
                k++;
            }
        }

        return out;
    }
    public static void main(String[] args) {
        int[] nums = {-1,1,-6,4,5,-6,1,4,1};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }
}
