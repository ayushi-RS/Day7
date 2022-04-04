class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum = 0;
        int windowLength = cardPoints.length - k;
        for(int num: cardPoints) totalSum += num;
        if(k >= cardPoints.length) return totalSum;
        int currentSum = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < cardPoints.length; i++) {
            currentSum += cardPoints[i];
            if(i == windowLength - 1) max = Math.max(max, totalSum - currentSum);
            if(i >= windowLength) {
                currentSum -= cardPoints[i - windowLength];
                max = Math.max(max, totalSum - currentSum);
            }
        }
        
        return max;
    }
}