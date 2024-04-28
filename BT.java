abstract class BT {
  public abstract int height();

  public static Node buildTree(int[] arr) {
    Node root = null;
    for (int i = 0; i < arr.length; i++) {
      root = insert(arr[i], root);
    }
    return root;

  }

  public static Node insert(int num, Node root) {
    if (root == null) {
      return new Node(num, null, null);
    }
    if (num < root.num) {
      root.left = insert(num, (Node) root.left);
    } else if (num > root.num) {
      root.right = insert(num, (Node) root.right);
    }
    return root;

  }

  public Boolean isBST(BT input, int min, int max) {
    if (input == null || input instanceof Nil) {
      return true; // nil case
    } else if (input instanceof Node) {
      Node node = (Node) input;
      int val = node.num;

      if (val < min || val > max) {
        // System.out.println("\n-----------------");
        // System.out.println("Was False Because:");
        // System.out.println("val: " + val);
        // System.out.println("min: " + min);
        // System.out.println("max: " + max);
        // System.out.println("-----------------\n");
        return false;
      }

      // System.out.println("\n-----------------");
      // System.out.println("Current");

      // System.out.println("-----------------");
      // System.out.println("Recursive recursing");
      // System.out.println("Left");
      // System.out.println(node.left.toString());
      // System.out.println("Right");
      // System.out.println(node.right.toString());
      // System.out.println("Min: " + min);
      // System.out.println("Max: " + max);
      // System.out.println("-----------------\n");

      // Recurse
      return isBST(node.left, min, node.num - 1) &&
        isBST(node.right, node.num + 1, max);
    } else {
      // System.out.println("\n-----------------");
      // System.out.println("Was False Because:");
      // System.out.println("Hit the other false");
      // System.out.println("-----------------\n");
      return false;
    }
  }

}
