package stepOne.stackAndQueue;

import java.util.*;

public class Solution1 {

    public int[] solution(int []arr) {
        int[] answer = {};

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            if(queue.isEmpty()) {
                queue.add(arr[i]);
                stack.push(arr[i]);
                continue;
            }

            if(arr[i] != stack.peek()) {
                queue.add(arr[i]);
                stack.push(arr[i]);
            }

        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }

        answer = new int[list.size()];

        for( int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {



    }
}
