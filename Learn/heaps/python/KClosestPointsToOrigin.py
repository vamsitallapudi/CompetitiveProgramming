class Solution:
    def kClosest(self, points, k):
        points.sort(key=lambda p: p[0]**2 + p[1]**2)
        return points[:k]


print(Solution().kClosest([[3, 3], [5, -1], [-2, 4]], 2))
