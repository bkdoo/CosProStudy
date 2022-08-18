package stepOne.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Solution1 {
    public <A> int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <=n; i++) {
            map.put(i,1);
        }
        Stack<Integer> lostStack = new Stack<>();
        Stack<Integer> reserveStack = new Stack<>();


        for (int i = 0; i < reserve.length; i++) {
            map.put(reserve[i], 2);
        }

        for (int i = 0; i < lost.length; i++) {
            lostStack.push(lost[i]);
            map.put(lost[i], map.get(lost[i])-1);
        }

        for (Integer i: map.keySet()
             ) {
            if(map.get(i)<2) {
                map.remove(i);
            }

        }

        List<Integer> list = map.keySet().stream().toList();
        list.stream().sorted();

        for (int i = 0; i < list.size(); i++) {
            reserveStack.push(list.get(i));
        }

        while (!reserveStack.isEmpty()) {
            int temp = reserveStack.pop();
            if(lostStack.peek()+1 == temp || lostStack.peek()-1 == temp) {
                lostStack.pop();
            }

            if(lostStack.isEmpty()) {
                break;
            }

        }
        answer = n - lostStack.size();
        return answer;
    }

    public static void main(String[] args) {
        int[] lost = {3};
        int[] reserve = {1};

        Solution1 solution1 = new Solution1();

        int result = solution1.solution(3, lost, reserve);
        System.out.println("result = " + result);
    }
}
