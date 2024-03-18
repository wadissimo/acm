package codeforces.ecr45;

public class Gtest {
    public static void main(String[] args) {
        int n = 200000;
        int res = 0;
        int a = 0;
        int tot = 0;
        for (int i = 1; i < n; i++) {
            int cnt = 0;
            int div = 1;
            for (; div*div < i; div++) {
                if(i%div == 0){
                    cnt+=2;
                }
            }
            if(div*div == i)
                cnt++;
            if(cnt > res){
                res = cnt;
                a = i;
            }
            tot += cnt;
        }
        System.out.println("total = " + tot);
        System.out.println("a = " + a);
        System.out.println("res = " + res);

    }
}
