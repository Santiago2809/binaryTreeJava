
public class BinaryTree {
    public TreeNode root;

    public BinaryTree(){ this.root = null; }

    public void insLeaf(int data){
        this.root = insLeafR(root, data);
    }
    private TreeNode insLeafR(TreeNode root, int data){
        if( root == null){
            root = new TreeNode(data);
            return root;
        }

        if( data < root.data ){
            root.left = insLeafR(root.left, data);
        } else if (data > root.data) {
            root.right = insLeafR(root.right, data);
        }

        return root;
    }
    public void inorder() {
        System.out.println("Recorrido en inorden");
        inorderRecursive(root);
    }

    private void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }

    public void preorder() {
        System.out.println("Recorrido en preorden");
        preorderRecursive(this.root);
    }
    private void preorderRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }

    public void postorder() {
        System.out.println("Recorrido en postorden");
        postorderRecursive(root);
    }

    private void postorderRecursive(TreeNode root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.data + " ");
        }
    }

    void printTree() {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }

        printSubTree(root, "", false);
    }

    void printSubTree(TreeNode node, String prefix, boolean isLeft) {
        if (node == null)
            return;

        // Imprime el nodo actual con su valor y nivel en el árbol
        String nodeValue = "[" + node.data + "]";
        String nodeLevel = "(" + getNodeLevel(node) + ")";
        String nodeString = nodeValue + nodeLevel;
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + nodeString);

        // Agrega caracteres especiales para separar visualmente los nodos y las ramas
        String newPrefix = prefix + (isLeft ? "│   " : "    ");
        printSubTree(node.left, newPrefix, true);
        printSubTree(node.right, newPrefix, false);
    }

    int getNodeLevel(TreeNode node) {
        return getNodeLevel(node, root, 1);
    }

    int getNodeLevel(TreeNode node, TreeNode current, int level) {
        if (current == null)
            return -1;

        if (current == node)
            return level;

        int leftLevel = getNodeLevel(node, current.left, level + 1);
        if (leftLevel > 0)
            return leftLevel;

        int rightLevel = getNodeLevel(node, current.right, level + 1);
        if (rightLevel > 0)
            return rightLevel;

        return -1;
    }


}
