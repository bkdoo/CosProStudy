package stepOne.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Solution2 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> pMap = new HashMap<>();
        HashMap<String, Integer> cMap = new HashMap<>();


        for (int i = 0; i < completion.length; i++) {
            cMap.put(completion[i], cMap.getOrDefault(completion[i],0)+1);
        }

        for(String s : pMap.keySet()) {
            if(!cMap.containsKey(s)) {
               answer = s;
               break;
            }

            if(cMap.get(s)>1) {
                cMap.put(s, cMap.get(s)-1);
            } else {
                cMap.remove(s);
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        String[] p = {"mislav", "stanko", "mislav", "ana"};
        String[] c = {"stanko", "ana", "mislav"};
        String solution = s.solution(p, c);
        System.out.println("solution = " + solution);
    }
}
