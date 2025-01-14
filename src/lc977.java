public class lc977 {
    public static void main(String[] args) {
        int [] nums={-4,-1,0,3,10};
       // int[] func = func(nums);
       /* for (int i = 0; i < func.length; i++) {
            System.out.print(func[i]+"  ");

        }*/
        System.out.println();
        int[] func1 = func1(nums);
        for (int i = 0; i < func1.length; i++) {
            System.out.print(func1[i]+"  ");

        }
    }

    //双指针法
    private static int[] func1(int[] nums) {
           int n= nums.length;
           int []res=new int[n];
           int i=0,j=n-1,m=n-1;
           while (i<j){
               if (nums[i]*nums[i]<=nums[j]*nums[j]){
                   res[m]=nums[j]*nums[j];
                   j--;
               }else{
                   res[m]=nums[i]*nums[i];
                   i++;
               }
               m--;
           }
           return res;
    }
/*
    private static int[] func(int[] nums) {
        //暴力算法 先把所有的元素平方 再排序
        for (int i = 0; i < nums.length; i++) {
            nums[i]=nums[i]*nums[i];
        }
        *//*for (int num : nums) {
            System.out.println(num);
        }*//*
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1; j++) {
                if (nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }

        return nums;
    }*/
}
