class Solution {
    
    HashSet<Integer> cycleTracker = new HashSet<>();
    
    HashSet<Integer> visited = new HashSet<>();
    
    ArrayList<Integer> output = new ArrayList<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] resultArr = new int[numCourses];
        
        //create adjacency list of prerequisites
        HashMap<Integer, ArrayList<Integer>> prereqMap = new HashMap<>();
        
        for(int i=0; i<numCourses; i++) {
            prereqMap.put(i, new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites) {
            prereqMap.get(prerequisite[0]).add(prerequisite[1]);
        }
        
        
        for (int i = 0; i < numCourses; i++) {
            if (depthFirstSearch(i, prereqMap) == false) {
                return new int[0];
            }
        }
        
        for (int i = 0; i < output.size(); i++) {
            resultArr[i] = output.get(i);
        }
        
        return resultArr;  
    }
    
    public boolean depthFirstSearch(int course, HashMap<Integer, ArrayList<Integer>> prereqMap) {
        if (cycleTracker.contains(course)) return false;
        if (visited.contains(course)) return true;
        
        cycleTracker.add(course);
        
        for (int prereq : prereqMap.get(course)) {
            if (depthFirstSearch(prereq, prereqMap) == false) return false;
        }
        cycleTracker.remove(course);
        visited.add(course);
        output.add(course);
        return true;   
    }
}