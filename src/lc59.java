public class lc59 {
    public static void main(String[] args) {
        int n=3;
        int[][] res = generateMatrix(n);
        for (int i = 0; i < res.length; i++) {
            for (int i1 = 0; i1 < res[i].length; i1++) {
                System.out.print(res[i][i1]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] generateMatrix(int n) {
        int nums[][]=new int[n][n];
        int count=1;
        int startX=0;
        int startY=0;
        int offset=1;
        int loop=0;

         while (loop<n/2){

             int i,j;

             for (j=startY;j<n-offset;j++){
                 nums[startX][j]=count++;
             }
             for (i=startX;i<n-offset;i++){
                 nums[i][j]=count++;
             }
             for (;j>startY;j--){
                 nums[i][j]=count++;
             }
             for (;i>startX;i--){
                 nums[i][j]=count++;
             }

             startX++;
             startY++;
             offset++;
             loop++;
         }
         if (n%2==1){
             nums[startX][startY]=count;
         }
         return nums;
    }
}
