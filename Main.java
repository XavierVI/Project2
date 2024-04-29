import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    printTreeTest();
    heightTest();
    isBSTTest();
    deletionTest();
  }

  private static void deletionTest() {
    ArrayList<BT> trees = new ArrayList<BT>();
    BT nil = Nil.getNil();
    // case (a)
    BT tree1 = new Node(5, nil, new Node(7, nil, new Node(20, nil, nil)));
    // case (b)
    BT tree2 = new Node(5, nil, new Node(7, new Node(6, nil, nil), nil));
    // case (c)
    BT tree3 = new Node(5, nil, new Node(7, new Node(6, nil, nil), new Node(20, nil, new Node(21, nil, nil))));
    // case (d)
    BT tree4 = new Node(5, new Node(4, nil, nil), new Node(7, new Node(6, nil, nil), new Node(20, new Node(18, nil, new Node(19,nil,nil)), new Node(22, nil, nil))));
    BT tree5 = new Node(5, new Node(4, new Node(2, new Node(1, nil, nil), nil),nil), new Node(9, new Node(7, nil, new Node(8, nil, nil)), new Node(20, new Node(18, nil, new Node(19,nil,nil)), new Node(22, nil, nil))));
    BT tree6 = new Node(9, new Node(4, new Node(3, new Node(2, nil, nil), nil), new Node(5,nil,nil)), nil);
    BT tree7 = new Node(9, nil, nil);

    trees.add(tree1);
    trees.add(tree2);
    trees.add(tree3);
    trees.add(tree4);
    trees.add(tree5);
    trees.add(tree6);
    trees.add(tree7);

    trees.forEach((tree) -> {
      System.out.println("Before: " + tree);
      BT newTree = BT.delete(9, tree);
      System.out.println("After: " + newTree);
      System.out.println();
    });
  }

  private static void printTreeTest() {
    BT nil = Nil.getNil();
    BT tree = new Node(3, new Node(1, nil, new Node(4, nil, nil)), new Node(2, nil, nil));
    // System.out.println(tree);

    System.out.print("\nTree string test: ");
    System.out.println(tree.toString().equals("Node(3, Node(1, Nil, Node(4, Nil, Nil)), Node(2, Nil, Nil))"));

    System.out.println("\nBuild tree tests: \n ----------------------------------------------------\n");
    buildTreeTests();
    System.out.println("\n ----------------------------------------------------\n");

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
  public static void buildTreeTests() {
    int passing = 0;
    // Test with empty array
    int[] emptyArr = {};
    BT emptyTree = BT.buildTree(emptyArr);
    if(emptyTree.toString().equals("Node(-1, Nil, Nil)")) {
      passing++;
    } 

    // Test with non-empty array
    int[] arr = {3, 1, 4, 2};
    BT tree = BT.buildTree(arr);
    if(tree.toString().equals("Node(3, Node(1, Nil, Node(2, Nil, Nil)), Node(4, Nil, Nil))")){

      passing++;
    }

    int[] arr2 = {12, 3, 1, 4, 2, 5, 6, 7};
    BT tree2 = BT.buildTree(arr2);
    if(tree2.toString().equals("Node(12, Node(3, Node(1, Nil, Node(2, Nil, Nil)), Node(4, Nil, Node(5, Nil, Node(6, Nil, Node(7, Nil, Nil))))), Nil)")){ 
      passing++;
    }

    System.out.println("Passed " + passing + " out of 3 tests");
    
  }


}
