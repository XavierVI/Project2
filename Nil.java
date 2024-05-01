public class Nil extends BT {

  public static Nil nil = new Nil(); // reference to singleton

  // dummy constructor
  private Nil() {}

  public static Nil getNil() {
    if (nil == null) nil = new Nil();
    return nil;
  }

  public int height() {
    return -1;
  }

  public boolean isBST(BT input, int min, int max) {
    return true;
  }

  public BT delete(int key) {
    return Nil.getNil();
  }

  public String toString() {
    return "Nil";
  }
}
