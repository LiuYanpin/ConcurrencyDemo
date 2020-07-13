package sort;

import java.util.*;

public class ThreeSumMain {
    public static void main(String[] args) {
        int[] ints=new int[]{ -1, 0, 1, 2, -1, -4};
        Arrays.sort(ints);
        List<List<Integer>> lists = threeSum(ints, 0);
        System.out.println(lists);
    }

    public  static List<List<Integer>> threeSum(int[] origin ,int sumTotal){
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<origin.length;i++){
            int first = origin[i];
            int rest=sumTotal-first;
            if(i==0 || origin[i-1]!=first){
                List<List<Integer>> lists = twoSum(origin, i+1, origin.length - 1, rest);
                lists.forEach(
                        list->result.add(addThreeSumList(first,list))
                );
            }
        }
        return result;
    }

    public  static List<List<Integer>> twoSum(int[] origin ,int start,int end,int sumTotal){
        if(start>=end){
            return new ArrayList<>();
        }
        Map<Integer,Integer> map=new HashMap();
        for(int i=start;i<=end;i++){
            if(map.containsKey(origin[i])){
                map.put(origin[i],map.get(origin[i])+1);
            }else{
                map.put(origin[i],1);
            }
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int i=start;i<=end;i++){
            int value = origin[i];
            int otherValue = sumTotal - value;
            if(!map.containsKey(otherValue)){
                continue;
            }
            if(value==otherValue){
                Integer count = map.get(value);
                if(count>=2){
                    result.add(addTwoSumList(value,otherValue));
                }

            }else if(value<otherValue){
                result.add(addTwoSumList(value,otherValue));
            }
        }

        return result;
    }

    public static List<Integer> addTwoSumList(Integer one,Integer two){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(one);
        integers.add(two);
        return integers;
    }

    public static List<Integer> addThreeSumList(Integer first,List<Integer> list){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(first);
        integers.addAll(list);
        return integers;
    }


}
