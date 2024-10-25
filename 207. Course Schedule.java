class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        int[] indigres = new int[numCourses];
        int count = 0;

        for(int[] pre: prerequisites){
            // dependent course
            int de = pre[0];
            // independent course i.e the prereq
            int ind = pre[1];

            //maintain a array where we store our dependent nodes connections to prereqs
            indigres[de]++;

            if(!map.containsKey(ind)){
                map.put(ind, new ArrayList<>());
            }
            map.get(ind).add(de);
        }

        // Populate queue with courses which have no prereqs
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indigres[i] == 0){
                q.add(i);
            }
        }

        // BFS
        
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            ArrayList<Integer> list = map.get(curr);
            if (list == null){
                continue;
            }

            for(int depend : list){
                indigres[depend]--;
                if (indigres[depend] == 0){
                    q.add(depend);
                    if(count == numCourses){
                        return true;
                    }
                }
            }
        }

        return count == numCourses;
    }

}

/// T(C): O(V+E) i.e. O(max(V, E) )
// S(C): O(VE) ... queue
