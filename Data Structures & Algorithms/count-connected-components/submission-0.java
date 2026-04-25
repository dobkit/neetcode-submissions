class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        int res = n;
        for (int[] edge : edges){
            if (unionFind.union(edge[0], edge[1])) res -=1;
        }
        return res;
    }
}

class UnionFind {
    int parrent[];

    public UnionFind(int n) {
        parrent = new int[n];
        for (int i = 0; i < n; i++){
            this.parrent[i] = i;
        }
    }

    public int find(int x){
        if(parrent[x] == x) return x;
        int cur = x;
        while (parrent[cur] != cur){
            parrent[cur] = parrent[parrent[cur]];
            cur = parrent[cur];
        }
        return cur;
    }

    public boolean union(int a, int b){
        int pA = find(a);
        int pB = find(b);
        if (pA == pB) return false;
        parrent[pA] = pB;
        return true;
    }
}