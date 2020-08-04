import javax.naming.LinkLoopException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode_207 {
    /**
     * 题目：课程表
     * 解析：判断能不能完成课程，其实就是多个课程是否形成相互依赖的过程，借用图来解析，即判断图中是否存在闭环，如有，则无法完成
     */

    //图模型(公用)
    List<List<Integer>> edges;


    //每个课程的遍历属性，0->尚未遍历， 1->遍历中， 2->已遍历，作为深度遍历的返回结果，表示没有形成环路
    int[] visited;
    //返回的结果
    boolean valid = true;


    //保存入度的数组，当该课程没有先决课程时，入度为0，数组对应位置值为0
    int[] indep;



    //方法1：先将所有先决条件抽象为图模型，然后使用深度优先遍历的方法，依次对所有课程进行遍历
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }

        for (int i = 0; i < numCourses && valid; ++i) {
            //对每门未遍历过的课程进行深度优先遍历
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            }else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }

    //方法2：这种方法比较抽象，逆向思维，将没有先决课程的课程逐一移除，在没有环路的情况下，最终必然所有课程都会变成没有先决课程的课程，
    //有一个专用的名字：入度法，还是不理解的话可以画个只有三四个节点的图辅助理解
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        indep = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indep[info[0]];
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; ++i){
            if (indep[i] == 0) {
                deque.push(i);
            }
        }
        int count = 0;
        while (!deque.isEmpty()) {
            ++count;
            int tmp = deque.pop();
            for (int i : edges.get(tmp)) {
                --indep[i];
                if (indep[i] == 0) {
                    deque.push(i);
                }
            }
        }
        return count == numCourses;
    }


}
