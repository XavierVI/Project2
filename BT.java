abstract class BT {
  public abstract int height();

  public static Node buildTree(int [] arr){
    Node root = null;
    for(int i = 0; i < arr.length; i++){
      root = insert(arr[i], root);
    }
    return root;


  }
  public static Node insert (int num, Node root){
    if(root == null){
      return new Node(num, null, null);
    }
    if(num < root.num){
      root.left = insert(num, (Node) root.left);
    }else if(num > root.num){
      root.right = insert(num, (Node) root.right);
    }
    return root;
   
  }
}
