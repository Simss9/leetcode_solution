class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        
        if (check(n, edges, k, 1) == false) {
            return -1;
        }

        int maxS = 0;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][2] > maxS) {
                maxS = edges[i][2];
            }
        }

        int low = 1;
        int high = 2 * maxS;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int n, int[][] edges, int k, int target) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int edgesUsed = 0;
        int upgradesUsed = 0;

        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            if (e[3] == 1) {
                if (e[2] < target) return false;
                int u = find(parent, e[0]);
                int v = find(parent, e[1]);
                if (u != v) {
                    parent[u] = v;
                    edgesUsed++;
                } else {
                    return false;
                }
            }
        }

        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            if (e[3] == 0 && e[2] >= target) {
                int u = find(parent, e[0]);
                int v = find(parent, e[1]);
                if (u != v) {
                    parent[u] = v;
                    edgesUsed++;
                }
            }
        }

        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            if (e[3] == 0 && e[2] < target && e[2] * 2 >= target) {
                if (upgradesUsed < k) {
                    int u = find(parent, e[0]);
                    int v = find(parent, e[1]);
                    if (u != v) {
                        parent[u] = v;
                        edgesUsed++;
                        upgradesUsed++;
                    }
                }
            }
        }

        if (edgesUsed == n - 1) {
            return true;
        } else {
            return false;
        }
    }

    public int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }
}