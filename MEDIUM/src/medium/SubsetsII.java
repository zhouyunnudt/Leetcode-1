package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.CommonUtils;

public class SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> empty = new ArrayList();
        result.add(empty);
        if(nums == null) return result;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            Set<List<Integer>> temp = new HashSet();
            for(List<Integer> list : result){
                List<Integer> newList = new ArrayList(list);
                newList.add(nums[i]);
                temp.add(newList);
            }
            result.addAll(temp);
        }
        Set<List<Integer>> resultSet = new HashSet();
        resultSet.addAll(result);
        result.clear();
        result.addAll(resultSet);
        return result;
    }
    
    public static void main(String...args){
        int[] nums = new int[]{1,2,2};
        List<List<Integer>> result = subsetsWithDup(nums);
        CommonUtils.printIntegerList(result);
    }

}
