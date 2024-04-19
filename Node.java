public class Node extends BT {
  int num;
  BT left;
  BT right;

  public Node(int num, BT left, BT right) {
    this.num = num;
    this.left = left;
    this.right = right;
  }

  public int height() {
    int leftHeight = left.height();
    int rightHeight = right.height();
    return (leftHeight < rightHeight ? rightHeight : leftHeight) + 1;
  }
}
