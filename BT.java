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

  /* ======================================================================= */
  /* This method searches for the node with the given key
   * and removes it from the tree.
   * 
   * @param key the key of the node to remove
   * @param treeRoot the root of the BST
   */
  public static BT delete(int key, BT treeRoot) {
    BT z = search(key,treeRoot);
    
    if(z instanceof Nil) return treeRoot;
    else if(treeRoot.height() == 0) return Nil.getNil();
    else if(z.num() == treeRoot.num()) {
      BT newRoot;
      if(z.right() instanceof Nil) newRoot = treeMax(z.left());
      else newRoot = treeMin(z.right());
      int temp = newRoot.num();
      delete(temp, treeRoot);
      treeRoot.setNum(temp);
      return treeRoot;
    }
    
    if(z.left() instanceof Nil) {
      transplant(z, z.right(), treeRoot);
    }
    else if(z.right() instanceof Nil) {
      transplant(z, z.left(), treeRoot);
    }
    else {
      BT y = treeMin(z.right());

      if(y.num() != z.right().num()) {
        transplant(y,y.right(),treeRoot);
        y.setRight(z.right());
      }
      transplant(z, y, treeRoot);
      y.setLeft(z.left());
    }
    return treeRoot;
  }

  public static void transplant(BT u, BT v, BT treeRoot) {
    BT uParent = findParent(u.num(), treeRoot);
    if(u.num() == uParent.left().num()) {
      uParent.setLeft(v);
    }
    else {
      uParent.setRight(v);
    }
  }

  public static BT treeMax(BT root) {
    if(root.right() instanceof Nil) return root;
    return treeMax(root.right());
  }

  public static BT treeMin(BT root) {
    if(root.left() instanceof Nil) return root;
    return treeMin(root.left());
  }

  public static BT search(int key, BT root) {
    if(root.num() == key) return root;
    else if(root instanceof Nil) return Nil.getNil();
    else if(root.num() < key) return search(key, root.right());
    else return search(key, root.left());
  }

  public static BT findParent(int key, BT root) {
    if(root.left().num() == key || root.right().num() == key) return root;
    else if(root instanceof Nil) return Nil.getNil();
    else if(root.num() < key) return findParent(key, root.right());
    else return findParent(key, root.left());
  }
}
