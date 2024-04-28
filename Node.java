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

  @Override
  public String toString() {
    if(height() == 0) return String.format("Node(%d, Nil, Nil)",num);
    return String.format("Node(%d, %s, %s)",
                         num,left.toString(),right.toString());    
  }
}
