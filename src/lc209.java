public class lc209 {
    public static void main(String[] args) {
      int nums[]={2,3,1,2,4,3};
      int target=7;
      function(nums,target);
    }

    private static int function(int[] nums, int target) {
        int i=0;
        int sum=0;
        int res=Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum+=nums[i];
            while (sum>=target){
                int subL=j-i+1;
                res=Math.min(res,subL);
                sum=sum-nums[i];
                i++;
            }
sout
        }
        return res;
    }
}
