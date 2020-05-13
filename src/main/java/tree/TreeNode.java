package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    private int id;
    private String name;
    private TreeNode left;
    private TreeNode right;


    //前序遍历DLR、中序遍历LDR、后序遍历LRD
    //1、输出当前节点(D)
    //2、如果左子节点不为空，则递归前序遍历左子节点(L)
    //3、如果右子节点不为空，则递归前序遍历左子节点(R)

    //==================前序遍历DLR 递归==================
    public void preOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        //输出当前节点（D）
        System.out.println(tree);
        //前序递归遍历，左子树
        preOrder(tree.left);

        //前序递归遍历，右子树
        preOrder(tree.right);
    }
    public void preOrder(){
        //输出当前节点（D）
        System.out.println(this);
        //前序递归遍历，左子树
        if(this.left != null){
            this.left.preOrder();
        }

        //前序递归遍历，右子树
        if(this.right != null){
            this.right.preOrder();
        }
    }

    //==================中序遍历LDR==================
    public void infixOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        //中序递归遍历，左子树
        infixOrder(tree.left);

        //输出当前节点
        System.out.println(tree);
        //中序递归遍历，右子树
        infixOrder(tree.right);
    }

    //==================后序遍历 LRD==================
    public void postOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        //后续递归遍历，左子树
        postOrder(tree.left);

        //后续递归遍历，右子树
        postOrder(tree.right);

        System.out.println(tree);
    }

    //前序查找、中序查找、后续查找
    //==================前序遍历查找，同前序遍历顺序一样，DLR的顺序进行搜索==================
    public TreeNode preOrderSearch(TreeNode node, int id) {
        if (node == null) {
            return null;
        }
        System.out.println(node.id);
        //判断当前节点是不是要找的节点
        if (node.id == id) {
            return node;
        }

        //如果不相等，判断当前节点左节点是否为空，不为空则递归查找
        TreeNode result = null;
        if (node.left != null) {
            result = preOrderSearch(node.left, id);
        }
        if (result != null) {//说明已经找到
            return result;
        }

        //递归找右子节点
        if (node.right != null) {
            result = preOrderSearch(node.right, id);
        }

        return result;
    }

    //==================中序遍历查找 LDR顺序==================
    public TreeNode infixOrderSearch(TreeNode node, int id) {
        if (node == null) {
            return null;
        }
        TreeNode result = null;
        //判断当前节点左节点是否为空，不为空则递归查找
        if (node.left != null) {
            result = infixOrderSearch(node.left, id);
        }
        if (result != null) {//说明已经找到
            return result;
        }
        System.out.println(node.id);
        //判断当前节点是不是要找的节点
        if (node.id == id) {
            return node;
        }
        //递归找右子节点
        if (node.right != null) {
            result = infixOrderSearch(node.right, id);
        }

        return result;
    }

    //==================后序遍历查找 LRD顺序==================
    public TreeNode postOrderSearch(TreeNode node, int id) {
        if (node == null) {
            return null;
        }
        TreeNode result = null;
        //判断当前节点左节点是否为空，不为空则递归查找
        if (node.left != null) {
            result = postOrderSearch(node.left, id);
        }
        if (result != null) {//说明已经找到
            return result;
        }

        //递归找右子节点
        if (node.right != null) {
            result = postOrderSearch(node.right, id);
        }
        if (result != null) {//说明已经找到
            return result;
        }
        System.out.println(node.id);
        //判断当前节点是不是要找的节点
        if (node.id == id) {
            return node;
        }

        return result;
    }



    /** ==================步骤分析==================
     * 1、如果是空树，只有一个root结点，直接将二叉树置空就可以
     * 2、以为树是单向的，所有只要判断当前结点的子节点是否要删除
     * 3、当前结点的左子节点不为空，且左子节点就是要删除的节点，则note.left = null，然后返回
     * 4、当前节点的右子节点不为空，且右子节点就是要删除的节点，则note.right = null,然后返回
     * 5、递归 3、4
     *
     * @param node
     * @param id
     */
    public TreeNode remove(TreeNode node,int id){
        if(node == null){
            return null;
        }
        if(node.id == id){
            return null;
        }
        //步骤三
        if(node.left != null && node.left.id == id){
            node.left = null;
            return node;
        }
        //步骤四
        if(node.right != null && node.right.id == id){
            node.right = null;
            return node;
        }
        //递归三
        if(node.left != null){
            remove(node.left,id);
        }
        //递归四
        if(node.right != null){
            remove(node.right,id);
        }
        return node;

    }





    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public TreeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
