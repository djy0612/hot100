package main.java.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class canFinish {
    public static void main(String[] args) {

    }
    public boolean canFinish(int numCourses, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDrgee = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {  //邻接表构建图
            graph.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            int ai = pre[0];    //后修课程
            int bi = pre[1];    //先修课程
            graph.get(bi).add(ai);
            inDrgee[ai]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDrgee[i]==0)
                q.offer(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            count++;
            for(int next:graph.get(course)){
                inDrgee[next]--;
                if(inDrgee[next]==0)
                    q.offer(next);
            }
        }
        return count == numCourses;
    }
}
