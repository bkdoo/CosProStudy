package stepOne.hash;

import java.util.HashMap;

public class Solution3 {

    public String solution(String[] survey, int[] choices) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("R",0);
        map.put("T",0);
        map.put("C",0);
        map.put("F",0);
        map.put("J",0);
        map.put("M",0);
        map.put("A",0);
        map.put("N",0);

        for (int i = 0; i < survey.length; i++) {

            if(choices[i]>4) {
                map.put(survey[i].substring(1), map.get(survey[i].substring(1))+choices[i]-4);
            }
            if(choices[i]<4) {
                map.put(survey[i].substring(0,1), map.get(survey[i].substring(0,1))+Math.abs(choices[i]-4));
            }

        }

        StringBuffer sb = new StringBuffer();

        String one = map.get("R") < map.get("T") ? "T" : "R";
        String two = map.get("C") < map.get("F") ? "F" : "C";
        String three = map.get("J") < map.get("M") ? "M" : "J";
        String four = map.get("A") < map.get("N") ? "N" : "A";

        return sb.append(one).append(two).append(three).append(four).toString();
    }



    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        Solution3 solution3 = new Solution3();
        System.out.println("solution3.solution(survey,choices) = " + solution3.solution(survey,choices));
    }
}
