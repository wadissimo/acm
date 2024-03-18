package chelper;

import java.util.Arrays;
import java.util.Comparator;

public class CandidatesSelectionEasy {
    public int[] sort(String[] score, int x) {
        final String[] chars = score;
        final int needed = x;
        Integer candidates [] =  new Integer[score.length];
        for (int i = 0; i < score.length; i++) {
            candidates[i] = i;
        }
        Arrays.sort(candidates, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Character.compare(chars[o1].charAt(needed), chars[o2].charAt(needed));
            }
        });
        int [] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            answer[i] = candidates[i];
        }
        return answer;
    }
}
