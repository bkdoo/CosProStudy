package stepOne.hash;

import java.util.HashSet;

public class Solution1 {
    public int solution(int[] nums) {
        int answer = 0;
        int half = nums.length/2;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        answer = set.size() > half ? half : set.size();

        return answer;
    }
}
