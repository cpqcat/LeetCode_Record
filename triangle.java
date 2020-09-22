class triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] memo = new int [m+1];
        for (int i = m-1; i >= 0; i--) {
            for (int j  = 0; j <=  i; j++) {
                memo[j] = Math.min(memo[j],memo[j+1]) + triangle.get(i).get(j);
            }
        }
        return memo[0];
    }
}