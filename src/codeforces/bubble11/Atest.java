package codeforces.bubble11;

/**
 *
 */
public class Atest {
    public static void main(String[] args) {

        int a[]=new int[]{1,2,3,4,4,4,4,5,5,7,8,9,10};
        int low = 0;
        int high = a.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (a[mid] < 11)
                low = mid+1;
            else
                high = mid;
        }
        System.out.println(low);
        System.out.println(a[low]);
    }
}
