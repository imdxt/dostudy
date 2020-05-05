package tree;

public class BinaryTree {
    public static void main(String[] args) {
        BinaryTreeDemo binaryTree = new BinaryTreeDemo();

        //          1
        //        2   3
        //          4   5

        TreeNode root = new TreeNode(1,"刘备");
        TreeNode tree2 = new TreeNode(2,"张飞");
        TreeNode tree3 = new TreeNode(3,"关羽");
        TreeNode tree4 = new TreeNode(4,"吕布");
        TreeNode tree5 = new TreeNode(5,"貂蝉");
        root.setLeft(tree2);
        root.setRight(tree3);
        tree3.setLeft(tree4);
        tree3.setRight(tree5);

//        //遍历 前序遍历DLR 1、2、3、4、5
//        System.out.println("前序遍历");
//        binaryTree.preOrder(root);
//        //中序遍历LDR 2、1、4、3、5
//        System.out.println("中序遍历");
//        binaryTree.infixOrder(root);
//        //后序遍历LRD 2、4、5、3、1
//        System.out.println("后序遍历");
//        binaryTree.postOrder(root);

//        TreeNode result;
//        //前序查找
//        result = binaryTree.preOrderSearch(root,3);
//        System.out.println(result);
//        //中序查找
//        result = binaryTree.infixOrderSearch(root,3);
//        System.out.println(result);
//        //后序查找
//        result = binaryTree.postOrderSearch(root,3);
//        System.out.println(result);

        //删除
        root = binaryTree.remove(root,1);
        System.out.println("前序遍历");
        binaryTree.preOrder(root);

    }

}
class BinaryTreeDemo{
    //前序遍历
    public void preOrder(TreeNode treeNode){
        if(treeNode != null){
            treeNode.preOrder(treeNode);
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //中序遍历
    public void infixOrder(TreeNode treeNode){
        if(treeNode != null){
            treeNode.infixOrder(treeNode);
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder(TreeNode treeNode){
        if(treeNode != null){
            treeNode.postOrder(treeNode);
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //前序遍历查找
    public TreeNode preOrderSearch(TreeNode node,int id){
        if(node == null){
            return null;
        }
        return node.preOrderSearch(node,id);
    }
    //中序遍历查找
    public TreeNode infixOrderSearch(TreeNode node,int id){
        if(node == null){
            return null;
        }
        return node.infixOrderSearch(node,id);
    }
    //后序遍历查找
    public TreeNode postOrderSearch(TreeNode node,int id){
        if(node == null){
            return null;
        }
        return node.postOrderSearch(node,id);
    }

    //删除二叉树
    public TreeNode remove(TreeNode node,int id){
        if(node != null){
            return node.remove(node,id);
//            if(node.getId() == id){
//                return null;
//            }else {
//                return node.remove(node,id);
//            }
        }else {
            System.out.println("当前二叉树为空");
            return null;
        }
    }
}

