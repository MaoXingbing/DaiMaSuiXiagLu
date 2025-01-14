import java.util.Scanner;

public class text {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nodeNumber = sc.nextInt();
        Scanner sc3=new Scanner(System.in);
        String first = sc3.nextLine();
        Scanner sc2=new Scanner(System.in);
        String mid = sc2.nextLine();
        System.out.println(function(nodeNumber,first,mid));

    }

    private static String function(int nodeNumber, String first, String mid) {
        if (nodeNumber==1 || nodeNumber==0){
            return first;
        }
         String root=Character.toString(first.charAt(1)) ;
        String[] tree=mid.split(root);
        return new String(tree[0]+root+tree[1]);
    }
}
