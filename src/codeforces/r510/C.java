package codeforces.r510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a[] = new int[n];
        st = new StringTokenizer(reader.readLine());
        int countNeg = 0;
        int maxNegPos=0;
        int maxNeg=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] < 0){
                countNeg++;
                if(a[i] > maxNeg){
                    maxNeg = a[i];
                    maxNegPos = i;
                }
            }
        }
        int[]mark = new int[n];
        StringBuilder sb = new StringBuilder();
        int rem = n;
        int zeroPos = -1;
        for (int i = 0; i < n; i++) {
            if(a[i] == 0){
                zeroPos = i;
                break;
            }
        }
        if(countNeg %2 == 1){
            mark[maxNegPos] = 1;
            if(zeroPos == -1){
                sb.append("2 ").append(maxNegPos+1).append('\n');
            } else{
                sb.append("1 ").append(maxNegPos+1).append(" ").append(zeroPos+1).append('\n');
            }
            rem --;
        }
        if(zeroPos != -1) {
            for (int i = zeroPos + 1; i < n; i++) {
                if (rem <= 1)
                    break;
                if (a[i] == 0) {
                    sb.append("1 ").append(zeroPos+1).append(" ").append(i+1).append('\n');
                    mark[zeroPos] = 1;
                    zeroPos = i;
                    rem --;
                }
            }
            if(rem > 1){
                sb.append("2 ").append(zeroPos+1).append('\n');
                mark[zeroPos] = 1;
                rem --;
            }
        }
        if(rem > 1){
            int first = -1;
            for (int i = 0; i < n; i++) {
                if(mark[i] == 0){
                    first = i;
                    break;
                }
            }
            int prev = first;
            for (int i = first+1; i < n ; i++) {
                if (rem <= 1)
                    break;
                if(mark[i] == 0){
                    sb.append("1 ").append(prev+1).append(" ").append(i+1).append('\n');
                    prev = i;
                    rem-=1;
                }
            }
        }
        System.out.println(sb.toString());


    }
}
