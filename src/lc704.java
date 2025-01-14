public class lc704 {
    //二分查找
    public static void main(String[] args) {
        int [] nums={1,2,3,4,5,6};
        int targrt=4;
        int i = BinarySearch(nums, targrt);
        System.out.println(i);
    }

    private static int BinarySearch(int[] nums, int targrt) {
        //左闭右闭
        int i=0;
        int j= nums.length;
        while (i<=j){
            int sum=i+j;
            int mid= (int) Math.floor(sum/2);
            if (nums[mid]==targrt){
                return mid;
            }else if (nums[mid]<targrt){
                i=mid+1;
            }else if (nums[mid]>targrt){
                j=mid-1;
            }
        }
        return -1;
    }
}
