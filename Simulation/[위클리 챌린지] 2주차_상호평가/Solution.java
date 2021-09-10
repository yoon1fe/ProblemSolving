class Solution {
    public static String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();
        int LEN = scores.length;

        for (int i = 0; i < LEN; i++) {
            int selfScore = scores[i][i];
            int[] scoreCount = new int[101];
            int n = LEN;
            int maxScore = -1;
            int minScore = 101;
            int totalScore = 0;

            for (int j = 0; j < LEN; j++) {
                scoreCount[scores[j][i]]++;
                maxScore = Math.max(maxScore, scores[j][i]);
                minScore = Math.min(minScore, scores[j][i]);

                totalScore += scores[j][i];
            }

            // 유일한 최고점이나 최저점인 경우
            if (scoreCount[selfScore] == 1 && (selfScore == maxScore || selfScore == minScore)) {
                totalScore -= selfScore;
                n--;
            }
            answer.append(getResult((double) totalScore / n));
        }

        return answer.toString();
    }

    public static String getResult(double avg) {
        return avg >= 90 ? "A" : avg >= 80 ? "B" : avg >= 70 ? "C" : avg >= 50 ? "D" : "F";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Solution.solution(new int[][]{{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}}));
    }
}