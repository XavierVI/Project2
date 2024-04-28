abstract class BT {
  public abstract int height();

  public abstract int num();
  public abstract BT left();
  public abstract BT right();

  public abstract boolean isBST(BT input, int min, int max);

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

  /* 
   * 
   */
  public static void delete(int key, BT treeRoot) {
    BT z = search(key,treeRoot);
    if(z.left() instanceof Nil) {
      transplant(z, z.right(), treeRoot);
    }
    else if(z.right() instanceof Nil) {
      transplant(z, z.left(), treeRoot);
    }
    else { // both are not nil
      BT y = treeMin(z.right());
      BT yRight = y.right();
      BT yLeft = y.left();
      BT yRightParent = findParent(y.right().num(), treeRoot);
      BT yLeftParent = findParent(y.left().num(), treeRoot);

      if(y.num() != z.right().num()) {
        transplant(y,y.right(),z);
        yRight = z.right();
        yRightParent = y;
      }
      transplant(z, y, treeRoot);
      yLeft = z.left();
      yLeftParent = y;
    }
  }

  /* Helper method for delete()
   * Sorts out the tree after the node is deleted.
   * 
   * You need the parent to u and v, thus you would need
   * to call search() twice.
   */
  private static void transplant(BT u, BT v, BT treeRoot) {
    BT uParent = findParent(u.num(), treeRoot);
    BT vParent = findParent(u.num(), treeRoot);
    BT uParentLeft = uParent.left();
    BT uParentRight = uParent.right();

    // if there is no parent, set the root node to v
    if(uParent == null) { // => there is no parent
      treeRoot = v; // replace root node with v
    }
    // else, if the deleted node is in the left child of the parent
    else if(u.num() == uParentLeft.num()) {
      uParentLeft = v; // set the parent's left child to v
    }
    // else the deleted node is in the right subtree of the parent
    else {
      uParentRight = v;
    }
    if(v instanceof Nil) {
      vParent = uParent;
    }
  }

  private static BT treeMin(BT root) {
    if(root.left() instanceof Nil) return root;
    return treeMin(root.left());
  }

  /* Helper method for delete(). Searches for the node with the given key.
   * For now, it's going to return null if it doesn't find it.
   */
  private static BT search(int key, BT root) {
    if(root.num() == key) return root;
    else if(root.num() < key) return search(key,(Node) root.right());
    else if(root.num() > key) return search(key,(Node) root.left());
    return null;
  }

  private static BT findParent(int key, BT root) {
    BT left = root.left();
    BT right = root.right();
    if(left.num() == key || right.num() == key) return root;
    else if(root.num() < key) return findParent(key,(Node) root.right());
    else if(root.num() > key) return findParent(key,(Node) root.left());
    return Nil.getNil();
  }
}
