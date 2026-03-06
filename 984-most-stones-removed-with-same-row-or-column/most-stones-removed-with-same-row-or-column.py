class Solution:
    def removeStones(self, stones: List[List[int]]) -> int:
        n = len(stones)
        rank = [0] * n
        parent = list(range(n))

        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]

        def union(x, y):
            rx = find(x)
            ry = find(y)

            if rx==ry: return False

            if rank[rx] > rank[ry]:
                parent[rx] = ry

            elif rank[ry] > rank[rx]:
                parent[ry] = rx
            else:
                parent[rx] = ry
                rank[rx] +=1

            return True
        
        components = n

        for i in range(n):
            for j in range(i+1, n):
                if stones[i][0] == stones[j][0] or stones[i][1] == stones[j][1]:
                    components -= union(i, j)

        return n - components


        