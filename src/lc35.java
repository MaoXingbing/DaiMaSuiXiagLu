public class lc35 {
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int res=nums.length;
        while(left<=right){
            int k=left+right;
            int mid=k/2;
            if(nums[mid]>=target){
                res=mid;
                right=mid-1;
            }else{

                left=mid+1;
            }
        }
        return res;
    }
}
