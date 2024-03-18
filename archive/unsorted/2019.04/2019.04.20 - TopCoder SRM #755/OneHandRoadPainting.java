package main;

public class OneHandRoadPainting {
    public long fastest(int[] dStart, int[] dEnd, int paintPerBrush) {
        int n = dStart.length;
        long rem = 0;
        long ans = 0;
        for (int i = n-1; i >= 0 ; i--) {
            int len = dEnd[i]-dStart[i];
            if(len <= rem){
                rem -= len;
            } else {
                long end = dEnd[i]-rem;//stop painting here and must return
                if(end == dStart[i]){
                    rem = 0;
                    continue;
                }
                long cnt = (end-dStart[i]+paintPerBrush-1)/paintPerBrush;//how many times we apply brush on this interval
                long from = end-cnt*paintPerBrush;
                rem = dStart[i]-from;
                ans+= (2*end - (cnt-1)*paintPerBrush)*cnt;
            }
        }
        return ans;
    }
}
