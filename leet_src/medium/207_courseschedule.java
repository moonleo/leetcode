class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> visited;
        for(int i = 0; i < prerequisites.length; i ++) {
            visited = new ArrayList<Integer>();
            if(!DFS(numCourses, prerequisites, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean DFS(int numCourses, int[][] prerequisites, List<Integer> visited, int index) {
        if(visited.size() == numCourses) {
            return true;
        }
        int from, to;
        visited.add(prerequisites[index][0]);
        for(int j = 0; j < prerequisites.length; j ++) {
            if(j == index) {
                continue;
            }
            from = prerequisites[j][0];
            to = prerequisites[j][1];
            if(from == prerequisites[index][1]) {
                if(visited.contains(to)) {
                    return false;
                }
                return DFS(numCourses, prerequisites, visited, j);
            }
        }
        return true;
    }
}
