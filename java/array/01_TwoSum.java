import java.util.HashMap;
public class 01_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //两数之和：哈希表
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}
