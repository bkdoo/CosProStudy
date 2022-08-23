package stepOne.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Solution4 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> reportedMap = new HashMap<>();
        List<String> distinctReport = Arrays.stream(report).distinct().collect(Collectors.toList());


        HashMap<String, HashSet<String>> reportInfo = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            reportedMap.put(id_list[i],0);
            reportInfo.put(id_list[i], new HashSet<>());
        }

        distinctReport.stream()
                .forEach(s -> reportedMap.put(s.split(" ")[1], reportedMap.get(s.split(" ")[1])+1));

        List<String> email = distinctReport.stream().filter(s -> reportedMap.get(s.split(" ")[1]) >= k).collect(Collectors.toList());

        email.stream()
                .forEach(s -> {
                    HashSet<String> set = reportInfo.get(s.split(" ")[0]);
                    set.add(s.split(" ")[1]);
                    reportInfo.put(s.split(" ")[0],
                            set);
                });

        for (int i = 0; i < answer.length; i++) {
            answer[i] = reportInfo.get(id_list[i]).size();
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        Solution4 solution4 = new Solution4();

        System.out.println("solution4 = " + solution4.solution(id_list, report, k)[0]);

    }
}
