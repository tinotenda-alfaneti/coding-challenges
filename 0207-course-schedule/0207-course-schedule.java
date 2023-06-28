class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, ArrayList<Integer>> preMap = new HashMap<>();
        HashSet<Integer> visitedSet = new HashSet<>();
        
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        
        
        for (int[] arr : prerequisites) {
            ArrayList<Integer> tmpArr = preMap.get(arr[0]);
            tmpArr.add(arr[1]);
            preMap.put(arr[0], tmpArr);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (depthFirstSearch(visitedSet, preMap, i) == false) return false;
        }
        
        return true;
        
        
    }
    
    public boolean depthFirstSearch(HashSet<Integer> visited, HashMap<Integer, ArrayList<Integer>> preMap, int course) {
        
        if (visited.contains(course)) return false;
        if (preMap.get(course).isEmpty()) return true;
        
        visited.add(course);
        
        for (int pre : preMap.get(course)) {
            if (depthFirstSearch(visited, preMap, pre) == false) return false;
        }
        visited.remove(course);
        preMap.put(course, new ArrayList<>());
        
        return true;
        
    }
}