package yandex.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 16.05.2014.
 */
public class A {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] d = new int[10][10];
        StringTokenizer st = new StringTokenizer(reader.readLine());


        for (int i = 0; i < 10 ; i++) {
            d[0][i] = 1;
            d[9][i] = 1;
            d[i][0] = 1;
            d[i][9] = 1;
        }
        String pos = st.nextToken();
        int wky = pos.charAt(1)-'1'+1;
        int wkx = pos.charAt(0) - 'a'+1;
        d[wkx][wky] = 1;

        pos = st.nextToken();
        int wty = pos.charAt(1)-'1'+1;
        int wtx = pos.charAt(0) - 'a'+1;
        d[wtx][wty] = 1;

        pos = st.nextToken();
        int bky = pos.charAt(1)-'1'+1;
        int bkx = pos.charAt(0) - 'a'+1;
        d[bkx][bky] = -1;

        //check strange
        if(Math.abs(wky-bky)<=1 && Math.abs(wkx-bkx)<=1) {
            System.out.println("Strange");
        } else {

                d[wkx-1][wky] = d[wkx-1][wky -1] = d[wkx-1][wky+1] = d[wkx+1][wky] = d[wkx+1][wky -1] =d[wkx+1][wky+1] =
                        d[wkx][wky -1] = d[wkx][wky+1] = 1;

            int start = 1;
            int end = 9;
            if(wtx == wkx) {
                if(wty < wky) {
                    end = wky;
                } else {
                    start = wky+1;
                }
            }
            for (int i = start; i < end; i++) {
                d[wtx][i] = 1;
            }

            start = 1;
            end = 9;
            if(wty == wky) {
                if(wtx < wkx) {
                    end = wkx;
                } else {
                    start = wkx+1;
                }
            }

            for (int i = start; i < end; i++) {
                d[i][wty] = 1;
            }

            if(Math.abs(wky-wty)>1 || Math.abs(wkx-wtx) > 1) {
                d[wtx][wty] = 0; //om-nom-nom
            }
            boolean hasMoves = true;
            if(d[bkx-1][bky] == 1 && d[bkx-1][bky -1] == 1 &&  d[bkx-1][bky+1] == 1 &&  d[bkx+1][bky] == 1 &&
                    d[bkx+1][bky -1] == 1 && d[bkx+1][bky+1] == 1 &&
                    d[bkx][bky -1] == 1 &&  d[bkx][bky+1]== 1) {
                hasMoves = false;
            }
            if(d[bkx][bky]==1){
                //attacked
                //checkmate?
                if(!hasMoves) {
                    System.out.println("Checkmate");
                }else{
                    System.out.println("Check");
                }
            } else {
                if(!hasMoves) {
                    System.out.println("Stalemate");
                }else{
                    System.out.println("Normal");
                }
            }
        }



    }
}
