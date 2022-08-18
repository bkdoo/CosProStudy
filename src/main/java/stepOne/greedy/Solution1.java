package stepOne.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class Solution1 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <=n; i++) {
            map.put(i,1);
        }
        for (int i = 0; i < reserve.length; i++) {
            map.put(reserve[i], 2);
        }
        for (int i = 0; i < lost.length; i++) {
            map.put(lost[i], map.get(lost[i])-1);
        }
        int[] arr = new int[n];
        for(Integer i : map.keySet()) {
            int key = i;
            int value = map.get(i);
            arr[key-1] = value;
        }
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]==2 && arr[i+1]==0) {
                arr[i]=1;
                arr[i+1]=1;
            } else if(arr[i]==0 && arr[i+1]==2) {
                arr[i]=1;
                arr[i+1]=1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0) {
                answer++;
            }
        }




        return answer;
    }

    public static void main(String[] args) {
        int[] lost = {3,2};
        int[] reserve = {1,4};

        Solution1 solution1 = new Solution1();

        int result = solution1.solution(4, lost, reserve);
        System.out.println("result = " + result);
    }
}
