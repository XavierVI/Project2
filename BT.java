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

    if (input == null) {
      return true;
    }

    if (input instanceof Node) {

      int val = ((Node) input).num;

      if (val < min || val > max) {
        return false;
      }

      // Recurse
      return isBST(((Node) input).left, min, ((Node) input).num - 1) &&
          isBST(((Node) input).right, ((Node) input).num + 1, max);
    } else {
      // Handle casting to NIL error
      return true;
    }
  }

}
