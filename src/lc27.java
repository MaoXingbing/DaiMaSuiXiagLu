public class lc27 {
    public static void main(String[] args) {
        int [] nums={4,5,6,4,4,4};
        int targrt=4;
        int ints = removeElement(nums, targrt);
        System.out.println(ints);
    }

    private static int removeElement(int[] nums, int targrt) {
        //暴力解法
       /* int length= nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i]==targrt){
                for (int j = i+1; j < length; j++) {
                    nums[j-1]=nums[j];
                }
                i--;
                length--;
            }
        }
        return length;*/

        //双指针
        /*
        * 快指针：寻找新数组的元素
        * 慢指针：指向更新 新数组的下标
        * */
        int low=0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast]!=targrt){
                nums[low]=nums[fast];
                low++;
            }
        }
        return low;
    }

}
