
class Triplet {
    int first;
    int second;
    int third;

    public Triplet(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    private int[][] getNearestOnes(List<List<Integer>> grid, int n, int[] dr, int[] dc) {
        Queue<Triplet> q = new LinkedList<>();
        int[][] res = new int[n][n];
        int[][] vis = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(grid.get(i).get(j) == 1) {
                    vis[i][j] = 1;
                    q.offer(new Triplet(i, j, 0));
                }
            }
        }
        while(!q.isEmpty()) {
            Triplet cell = q.poll();
            int row = cell.first;
            int col = cell.second;
            int dist = cell.third;
            res[row][col] = dist;
            for(int i=0;i<4;i++) {
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.offer(new Triplet(nrow, ncol, dist+1));
                }
            }
        }
        return res;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        int[][] nearestOnes = getNearestOnes(grid, n, dr, dc);
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> {
            if(a.first != b.first) return b.first - a.first;
            else if(a.second != b.second) return a.second - b.second;
            return a.third - b.third;
        });
        int[][] vis = new int[n][n];
        pq.offer(new Triplet(nearestOnes[0][0], 0, 0));
        while(!pq.isEmpty()) {
            Triplet cell = pq.poll();
            int safeness = cell.first;
            int row = cell.second;
            int col = cell.third;

            if(row == n-1 && col == n-1) {
                return safeness;
            }

            if(vis[row][col] == 1) continue;
            vis[row][col] = 1;

            for(int i=0;i<4;i++) {
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0) {
                    pq.offer(new Triplet(Math.min(safeness, nearestOnes[nrow][ncol]), nrow, ncol));
                }
            }
        }
        return 0;
    }
}

