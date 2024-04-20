public class Main {

  public static void main(String[] args) {
    BT nil = Nil.getNil();
    BT tree =  new Node(3, new Node(1, nil, new Node(4, nil, nil)), new Node(2, nil, nil));
    System.out.println("Tree height: " + tree.height());
    System.out.println(tree);
    // tests if tree is correct
    System.out.println("Tree string test:");
    System.out.println(tree.toString().equals("Node(3, Node(1, Nil, Node(4, Nil, Nil)), Node(2, Nil, Nil))"));
  }
}
