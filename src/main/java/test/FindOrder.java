package test;

import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.*;

/**
 *  课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * 示例 1:
 *      输入: 2, [[1,0]]
 *      输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 */
public class FindOrder {
    public static void main(String[] args){
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

//        findOrder(4,prerequisites);
        findOrder1(4,prerequisites);

    }

    /**
     * https://mp.weixin.qq.com/s?__biz=MzA3MjU5NjU2NA==&mid=2455502896&idx=1&sn=df6f2c86e0f1de823f79087ba9e8eb33&chksm=88b34d0bbfc4c41d863b4b6d78309e6ae01e766b1a7826b4c326246dd2489df9d684e8091ece&scene=21#wechat_redirect
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];

        // get the indegree for each course
        for(int[] pre : prerequisites) {
            indegree[pre[0]] ++;
            System.out.println("=====pre[0] ="+pre[0]+"/ "+indegree[pre[0]]);
        }

        // put courses with indegree == 0 to queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                System.out.println("=====offer i ="+i);
                queue.offer(i);
            }
        }
        // execute the course
        int i = 0;
        while(!queue.isEmpty()) {
            Integer curr = queue.poll();
            res[i++] = curr;

            // remove the pre = curr //如果数组很大，这里时间复杂度很大，应该使用hash表存放，减少循环次数
            for(int[] pre : prerequisites) {
                System.out.println("=====remove ="+pre[1]);
                if(pre[1] == curr) {
                    indegree[pre[0]] --;
                    if(indegree[pre[0]] == 0) {
                        queue.offer(pre[0]);
                    }
                }
            }
        }

        return i == numCourses ? res : new int[]{};
    }
    private static int[] findOrder1(int numCourses,int[][] prerequisites){
        //存放结果
        int[] res = new int[numCourses];
        //存放度,index 是编号，value是度
        int[] indegree = new int[numCourses];
        //队列存放 度适中为0的数据
        Queue<Integer> queue = new LinkedList<>();
        //存放依赖关系,key 编号，value存放依赖关系
        Map<Integer,List<Integer>> map = new HashMap<>();
        //初始化度和map
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;//当前编号被关联次数，也就是度
            System.out.println("=====init  ="+prerequisites[i][0]+"/ ="+prerequisites[i][1]+"、 "+indegree[prerequisites[i][0]]);
            if(map.containsKey(prerequisites[i][1])){
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1],list);
            }
        }
        //把度为0的如队列
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0){
                System.out.println("=====offer i ="+i);
                queue.offer(i);
            }
        }
        int i = 0;
        //循环取出度为0的数
        while (!queue.isEmpty()){
            int cur = queue.poll();
            res[i++] = cur;
            System.out.println("=====poll  ="+cur);
            if(map.containsKey(cur) && map.get(cur).size() != 0){
                for (Integer num: map.get(cur)){
                    indegree[num]--;
                    System.out.println("=====poll @@@@  ="+indegree[num]+"/ num "+num);
                    if(indegree[num] == 0){
                        queue.offer(num);
                    }
                }

            }

        }
        return i == numCourses ? res : new int[]{};
    }
}
