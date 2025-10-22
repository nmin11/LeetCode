class Solution {
    static class Point {
        long distance;
        int[] point;

        public Point(long distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.distance));

        for (int[] point : points) {
            long distance = (long) point[0] * point[0] + (long) point[1] * point[1];
            pq.add(new Point(distance, point));
        }

        int[][] results = new int[k][];
        for (int i = 0; i < k; i++) {
            results[i] = pq.poll().point;
        }

        return results;
    }
}