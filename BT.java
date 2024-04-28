abstract class BT {
  public abstract int height();

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
