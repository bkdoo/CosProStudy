package stepOne.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution4 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        HashMap<String, Integer> reportedMap = new HashMap<>();
        List<String> distinctReport = Arrays.stream(report).distinct().collect(Collectors.toList());


        HashMap<String, HashMap<String, Integer>> reportInfo = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            reportedMap.put(id_list[i],0 );
        }

        distinctReport.stream()
                .forEach(s -> reportedMap.put(s.split(" ")[1], reportedMap.get(s.split(" ")[1])+1));

        for (int i = 0; i < distinctReport.size(); i++) {
            String[] reportOne = report[i].split(" ");

            reportInfo.put(reportOne[0], reportedMap);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] concat = "dodo jii".split(" ");
        System.out.println("concat = " + concat[0]);
    }
}
