public class EjemploBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insLeaf(5);
        tree.insLeaf(43);
        tree.insLeaf(7);
        tree.insLeaf(9);
        tree.insLeaf(2);
        tree.insLeaf(89);
        tree.insLeaf(41);

        tree.printTree();

        tree.inorder();
        System.out.println("\n-----");
        tree.preorder();
        System.out.println("\n-----");
        tree.postorder();
//        System.out.println(tree.root.left.left.data);
    }
}
