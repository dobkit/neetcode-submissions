class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double currentMaxTime = -1.0;
        int numFleets = 0;
        int[][] cars = new int[n][2];
        for (int i = 0; i< n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        for (int[] car : cars) {
            double arrivalTime = (double) (target - car[0])/car[1];
            if (currentMaxTime < arrivalTime) {
                numFleets++;
                currentMaxTime = arrivalTime;
            }
        }
        return numFleets;
    }
}
