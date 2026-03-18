class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = defaultdict(list)
        visited = set()

        for u, v in prerequisites:
            adj[u].append(v)

        def dfs(u):
            if u in visited: return False
            if adj[u] == []: return True

            visited.add(u)

            for pre in adj[u]:
                if not dfs(pre): return False

            visited.remove(u)
            adj[u] = []

            return True

        for c in range(numCourses):
            if not dfs(c): return False

        return True
        
        