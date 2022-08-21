package stepOne.stackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution2 {

    public String solution(String new_id) {
        String answer = "";

        //step1
        String step1 = new_id.toLowerCase();

        //step2, 3, 4
        Stack<String> step2 = new Stack<>();
        for (int i = 0; i < step1.length(); i++) {
            if(step2.isEmpty()) {
                if(step1.codePointAt(i) == 46) {
                    continue;
                }
            }
            if( (step1.codePointAt(i)<=122 && step1.codePointAt(i) >= 97)
            || (step1.codePointAt(i)>= 48 && step1.codePointAt(i) <= 57)
            || (step1.codePointAt(i) == 95) || (step1.codePointAt(i) == 45)) {
                step2.add(String.valueOf(step1.charAt(i)));
            }
            if(!step2.isEmpty()) {
                if(step1.codePointAt(i) == 46 && !step2.peek().equals("."))  {
                    step2.add(String.valueOf(step1.charAt(i)));
                }

            }

            //step4
        }

        //step4
        if(!step2.isEmpty()) {
            if(step2.peek().equals(".")) {
                step2.pop();
            }
        }

        //step5
        if(step2.isEmpty()) {
            step2.add("a");
        }

        if(step2.size()>15) {
            while(step2.size()>15) {
                step2.pop();
            }
        }

        if(step2.peek().equals(".")) {
            step2.pop();
        }

        if(step2.size()<3) {
            while(step2.size()<3) {
                step2.add(step2.peek());
            }
        }

        StringBuffer sb = new StringBuffer();

        while(!step2.isEmpty()) {
            sb.append(step2.pop());
        }

        answer = sb.reverse().toString();

        return answer;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String solution = solution2.solution("abcdefghijklmn.p");
        System.out.println("solution = " + solution);
    }
}
