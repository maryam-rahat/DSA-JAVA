"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        
        cloned_map = {}
        
        def dfs(curr):
            if curr in cloned_map:
                return cloned_map[curr]
            
            clone = Node(curr.val)
            cloned_map[curr] = clone

            for nei in curr.neighbors:
                clone.neighbors.append(dfs(nei))
            
            return clone
        
        return dfs(node)