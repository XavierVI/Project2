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

  @Override
  public int num() {
    return num;
  }

  @Override
  public BT left() {
    return left;
  }

  @Override
  public BT right() {
    return right;
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

  @Override
  public String toString() {
    if(height() == 0) return String.format("Node(%d, Nil, Nil)",num);
    return String.format("Node(%d, %s, %s)",
                         num,left.toString(),right.toString());    
  }
}
