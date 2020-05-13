package test;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public static void main(String[] args){

    }

        /**
         * Definition for a binary tree node.
         * public class TreeNode {
         *     int val;
         *     TreeNode left;
         *     TreeNode right;
         *     TreeNode(int x) { val = x; }
         * }
         */
        public List<List<Integer>> levelOrder(TreeNode root) {

            List<List<Integer>> data = new ArrayList<>();
            if(root == null){
                return data;
            }


            bfs(data,root);
            return data;
        }
        private int num = 0;//记录遍历的层
        private List<List<Integer>> result = new ArrayList<>();
        private void dfs(TreeNode node){
            if(node == null){
                return;
            }
            //构造每一层数据，
            if(result.size() <= num){
                result.add(new LinkedList<>());
            }
            //add到result
            result.get(num).add(node.getId());
            System.out.println("===dfs=id==="+node.getId()+" num="+num);
            //遍历左子树
            if(node.getLeft() != null){
                num++;//表示遍历了一层
                dfs(node.getLeft());
                num--;//遍历完成返回后，层次应该减少一层
            }
            //遍历右子树
            if(node.getRight() != null){
                num++;
                dfs(node.getRight());
                num--;
            }

        }
        //创建辅助队列,广度优先
        private void bfs(List<List<Integer>> data,TreeNode root){

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                while (size > 0){
                    TreeNode node = queue.poll();
                    list.add(node.getId());
                    System.out.println("===bfs=id==="+node.getId());
                    size--;
                    if(node.getLeft() == null){
                        queue.offer(node.getLeft());
                    }
                    if(node.getRight() == null){
                        queue.offer(node.getRight());
                    }
                }
                data.add(list);
            }

        }


}
