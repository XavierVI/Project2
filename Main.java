public class Main {

  public static void main(String[] args) {
    printTreeTest();
    heightTest();
    isBSTTest();
  }

  private static void printTreeTest() {
    BT nil = Nil.getNil();
    BT tree = new Node(3, new Node(1, nil, new Node(4, nil, nil)), new Node(2, nil, nil));
    // System.out.println(tree);

    System.out.print("\nTree string test: ");
    System.out.println(tree.toString().equals("Node(3, Node(1, Nil, Node(4, Nil, Nil)), Node(2, Nil, Nil))"));
  }

  private static void heightTest() {
    BT nil = Nil.getNil();
    BT tree = new Node(12, new Node(10, nil, new Node(11, nil, nil)), new Node(33, nil, nil));
    System.out.print("\nTree Height test: ");
    System.out.println(tree.height() == 2);
  }

  private static void isBSTTest() {
    // Test with valid BST
    BT nil = Nil.getNil();
    Node validBST = new Node(12, new Node(10, nil, new Node(11, nil, nil)), new Node(33, nil, nil));
    System.out.print("\nIs BST test with valid BST: ");
    System.out.println(validBST.isBST(validBST, Integer.MIN_VALUE, Integer.MAX_VALUE) == true);

    // Test with invalid BST
    Node invalidBST = new Node(3, new Node(1, nil, new Node(4, nil, nil)), new Node(2, nil, nil));
    System.out.print("\nIs BST with invalid BST Test: ");
    System.out.println(invalidBST.isBST(invalidBST, Integer.MIN_VALUE, Integer.MAX_VALUE) == false);

    // Test with empty tree
    BT emptyTree = Nil.getNil();
    System.out.print("\nIs BST test with empty tree: ");
    System.out.println(emptyTree.isBST(emptyTree, Integer.MIN_VALUE, Integer.MAX_VALUE) == true);
  }
}
