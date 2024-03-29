public class 06_MaximumSubarray {
    //基础版
    public int maxSubarray(int[] nums) {
        //f[i]：以i结尾的子序的最大子序和，与f[i-1]有关
        int n = nums.length;
        ing[] f = new int[n];
        f[0] = nums[0];
        //给所有的f[i]赋值，然后找到最大的
        for(int i = 1; i < n; i++) 
            f[i] = Math.max(f[i-1], 0) + nums[i];
        int res = Integer.MIN_VALUE;
        for(int j = 0; j < n; j++) 
            res = f[j] > res ? f[j] : res;
        return res;
    }
    //进阶版
    public int maxSubarray(int[] nums) {
        //f[i]代表以i结尾的子序的最大子序和，与f[i]有关，就是子序必须包含nums[i]
        //1 2 -1   f[0] = 1, f[1] = 3, f[2] = 2, res = max(f[0], f[1], ...f[n-1])
        int res = Integer.MIN_VALUE;
        int last = 0;
        for(int i = 0; i < nums.length; i++) {
            int now = Math.max(last, 0) + nums[i];
            res = Math.max(res, now);
            last = now;
        }
        return res;
    }
}
