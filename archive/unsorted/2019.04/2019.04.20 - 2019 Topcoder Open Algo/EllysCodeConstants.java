package main;

public class EllysCodeConstants {
    boolean check(String s, int to){
        if(to == 0)
            return false;
        for (int i = 0; i < to; i++) {
            char c = s.charAt(i);
            if(c >= '0' && c<= '9' || c >= 'A' && c<='F')
                continue;
            return false;
        }
        return true;
    }
    public String getLiteral(String candidate)
    {
        String s = candidate;
        int n = s.length();
        s = s.replaceAll("O", "0");
        s = s.replaceAll("I", "1");
        s = s.replaceAll("Z", "2");
        s = s.replaceAll("S", "5");
        s = s.replaceAll("T", "7");
        String [] suf = new String[]{"L","LL","U","UL", "ULL", "LU", "LLU"};
        if(check(s, n))
            return "0x"+s;
        for (String suffix : suf) {
            if(s.endsWith(suffix) && check(s, n-suffix.length()))
                return "0x"+s;
        }
        return "";
    }
}
