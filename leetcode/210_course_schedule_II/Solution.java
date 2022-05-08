public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] sol = new int[numCourses];
        int[] indegree = new int[numCourses];

        for (int[] i : prerequisites) {
            indegree[i[0]] += 1;
        }

        return sol;
    }
}
