package stepOne.bruteForceSearch;

public class Solution1 {
    public int solution(int[][] sizes) {
        int answer = 0;

        for(int i = 0; i < sizes.length ; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }

        int w = 0;
        int h = 0;

        for(int i = 0; i < sizes.length ; i++) {
            w = w < sizes[i][0] ? sizes[i][0] : w ;
            h = h < sizes[i][1] ? sizes[i][1] : h ;
        }

        answer = w*h;
        return answer;
    }
}
