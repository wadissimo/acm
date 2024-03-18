package main;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), z = in.ni();

        int[] a = in.na(n);
        ArrayUtils.randomShuffle(a);
        Arrays.sort(a);
        int ct=0;
        int i=0,j=n/2;
        int[] arr = new int[n];
        while(i<n)
        {	if(arr[i]==1)
        {i++;
            continue;
        }
            arr[i]=1;
            while(j<n && (a[j]-a[i]<z || arr[j]==1))
                j++;
            //cout<<i<<" "<<j<<"\n";
            if(j==n)
                break;
            arr[j]=1;

            ct++;
            i++;
            j++;

        }
        out.println(ct);

    }
}
