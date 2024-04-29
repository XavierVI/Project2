abstract class BT {
  public abstract int height();

  public abstract int num();
  public abstract BT left();
  public abstract BT right();
  public abstract void setNum(int num);
  public abstract void setLeft(BT left);
  public abstract void setRight(BT right);

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

  /* This method searches for the node with the given key
   * and removes it from the tree.
   * 
   * @param key the key of the node to remove
   * @param treeRoot the root of the BST
   */
  public static void delete(int key, BT treeRoot) {
    BT z = search(key,treeRoot);
    if(z.num() == treeRoot.num()) { // if the node to be deleted is the root
      BT newRoot = (z.right() instanceof Nil) ? z.left() : 
                   (z.left() instanceof Nil) ? z.right() : treeMin(z.right());
      int temp = newRoot.num();
      delete(temp, treeRoot);
      treeRoot.setNum(temp); // replace the root's value with the new root's value
      return;
    }
    if(z.left() instanceof Nil) {
      transplant(z, z.right(), treeRoot);
    }
    else if(z.right() instanceof Nil) {
      transplant(z, z.left(), treeRoot);
    }
    else { // both are not nil
      BT y = treeMin(z.right());

      if(y.num() != z.right().num()) {
        transplant(y,y.right(),treeRoot);
        y.setRight(z.right());
      }
      transplant(z, y, treeRoot);
      y.setLeft(z.left());
    }
  }

  /* Helper method for delete(), moves subtrees around. */
  private static void transplant(BT u, BT v, BT treeRoot) {
    BT uParent = findParent(u.num(), treeRoot);

    // if there is no parent, set the root node to v
    // if(uParent instanceof Nil) { // => there is no parent
    //   int temp = v.num();
    //   delete(v.num(), treeRoot);
    //   u.setNum(temp);
    // }
    // if the deleted node is in the left child of the parent
    if(u.num() == uParent.left().num()) {
      uParent.setLeft(v); // set the parent's left child to v
    }
    // else the deleted node is in the right subtree of the parent
    else {
      uParent.setRight(v);
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
    else if(root.num() < key) return search(key, root.right());
    else if(root.num() > key) return search(key, root.left());
    return Nil.getNil();
  }

  /* Helper method for delete(). Locates the parent of the node with the given key. */
  private static BT findParent(int key, BT root) {
    BT left = root.left();
    BT right = root.right();
    if(left.num() == key || right.num() == key) return root;
    else if(root.num() < key) return findParent(key, root.right());
    else if(root.num() > key) return findParent(key, root.left());
    return Nil.getNil();
  }
}
