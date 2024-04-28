abstract class BT {
  public abstract int height();

  /**
   * Builds a BT based on the given array
   * @param arr the array to build the tree from
   * @return root node of the tree
   */
  public static Node buildTree(int [] arr){
    if(arr.length == 0) return new Node(-1, Nil.getNil(), Nil.getNil());

    Node root = new Node(arr[0], Nil.getNil(), Nil.getNil());
    for(int i = 1; i < arr.length; i++){
      insert(arr[i], root);
    }
    return root;

  }

  /**
   * Inserts a number into the tree by traversing to the correct leaf node position
   * @param num the number to insert
   * @param root the root of the tree
   */
  public static void insert (int num, Node root){
    if(num < root.num){
      if(root.left == Nil.getNil()){
        root.left = new Node(num, Nil.getNil(), Nil.getNil());
      }else{
        insert(num, (Node)root.left);
      }
    }else{
      if(root.right == Nil.getNil()){
        root.right = new Node(num, Nil.getNil(), Nil.getNil());
      }else{
        insert(num, (Node)root.right);
      }
    }
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
