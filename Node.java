public class Node extends BT {
  int num;
  BT left;
  BT right;

  public Node(int num, BT left, BT right) {
    this.num = num;
    this.left = left;
    this.right = right;
  }

  @Override
  public int height() {
    int leftHeight = left.height();
    int rightHeight = right.height();
    return (leftHeight < rightHeight ? rightHeight : leftHeight) + 1;
  }

  public boolean isBST(BT input, int min, int max) {
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

  public BT delete(int key) {
    BT z = search(key,this);
    Node zNode;
    
    if(z instanceof Nil) return this;
    else if(this.height() == 0) return Nil.getNil();    
    else if(((Node) z).num == this.num) {
      zNode = (Node) z;
      BT newRoot;
      if(zNode.right instanceof Nil) newRoot = (Node) treeMax(zNode.left);
      else newRoot = (Node) treeMin(zNode.right);
      int temp = ((Node) newRoot).num;
      this.delete(temp);
      this.num = temp;
      return this;
    }
    else if(((Node) z).left instanceof Nil) {
      zNode = (Node) z;
      transplant(z, zNode.right);
    }
    else if(((Node) z).right instanceof Nil) {
      zNode = (Node) z;
      transplant(z, zNode.left);
    }
    else {
      zNode = (Node) z;
      Node y = (Node) treeMin(zNode.right);
      Node zRight = (Node) zNode.right;
      Node zLeft = (Node) zNode.left;
      if(y.num != zRight.num) {
        transplant(y,y.right);
        y.right = zRight;
      }
      transplant(z, y);
      y.left = zLeft;
    }
    return this;
  }

  public void transplant(BT u, BT v) {
    Node uNode = (Node) u;
    Node uParent = (Node) findParent(uNode.num, this);
   
    if(uParent.left instanceof Node) {
      Node uParentLeft = (Node) uParent.left;
      if(uNode.num == uParentLeft.num) {
        uParent.left = v;
      }
      else {
        uParent.right = v;
      }
    }
    else if(uParent.right instanceof Node) {
      Node uParentRight = (Node) uParent.right;
      if(uNode.num == uParentRight.num) {
        uParent.right = v;
      }
      else {
        uParent.left = v;
      }
    }
  }

  public BT treeMax(BT root) {
    Node rootNode = (Node) root;
    if(rootNode.right instanceof Nil) return root;
    return treeMax(rootNode.right);
  }

  public BT treeMin(BT root) {
    Node rootNode = (Node) root;
    if(rootNode.left instanceof Nil) return root;
    return treeMin(rootNode.left);
  }

  public BT search(int key, BT root) {
    if(root instanceof Nil) return Nil.getNil();
    else {
      Node rootNode = (Node) root;
      if(rootNode.num == key) return root;
      else if(rootNode.num < key) return search(key, rootNode.right);
      else return search(key, rootNode.left);
    }
  }

  public BT findParent(int key, BT root) {
    Node rootNode;
    Node rootNodeLeft;
    Node rootNodeRight;
    if(root instanceof Nil) return Nil.getNil();
    rootNode = (Node) root;

    if(!(rootNode.left instanceof Nil)) {
      rootNodeLeft = (Node) rootNode.left;
      if(rootNodeLeft.num == key) return root;
      else if(rootNode.num > key) return findParent(key, rootNodeLeft);
    }
    if(!(rootNode.right instanceof Nil)) {
      rootNodeRight = (Node) rootNode.right;
      if(rootNodeRight.num == key) return root;
      else if(rootNode.num < key) return findParent(key, rootNodeRight);
    }

    return Nil.getNil();
  }

  @Override
  public String toString() {
    if(height() <= 0) return String.format("Node(%d, Nil, Nil)",num);
    return String.format("Node(%d, %s, %s)",
                         num,left.toString(),right.toString());    
  }
}
