public class Main {

  public static void main(String[] args) {
    printTreeTest();
    heightTest();
    isBSTTest();
  }

  private static void printTreeTest(){
    BT nil = Nil.getNil();
    BT tree =  new Node(3, new Node(1, nil, new Node(4, nil, nil)), new Node(2, nil, nil));
    System.out.println(tree);

    System.out.print("\nTree string test: ");
    System.out.println(tree.toString().equals("Node(3, Node(1, Nil, Node(4, Nil, Nil)), Node(2, Nil, Nil))"));
  }

  private static void heightTest(){
    BT nil = Nil.getNil();
    BT tree =  new Node(3, new Node(1, nil, new Node(4, nil, nil)), new Node(2, nil, nil));
    System.out.print("\nHeight test: ");
    System.out.println(tree.height() == 3);
  }

  private static void isBSTTest(){
    // Test with valid BST
    BT nil = Nil.getNil();
    BT tree =  new Node(3, new Node(1, nil, new Node(4, nil, nil)), new Node(2, nil, nil));
    System.out.print("\nIs BST test with valid BST: ");
    System.out.println(tree.isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE) == true);

    // Test with invalid BST
    BT tree2 =  new Node(3, new Node(1, nil, new Node(4, nil, nil)), new Node(2, nil, nil));
    System.out.print("\nIs BST with invalid BST Test: ");
    System.out.println(tree2.isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE) == false);

    // test with empty tree 
    BT emptyTree = Nil.getNil();
    System.out.print("\nIs BST test with empty tree: ");
    System.out.println(emptyTree.isBST(emptyTree, Integer.MIN_VALUE, Integer.MAX_VALUE) == true);
  }
}
