## Tasks
[X] Override the method toString in the Node class, such that the structure of the binary tree can be 
translated to the following string format:  
Node(num, string_of_left_subtree, string_of_right_subtree). 
For example, the tree showed above is translated to the string 
Node(3, Node(1, Nil, Node(4, Nil, Nil)), Node(2, Nil, Nil)) 

[] (5 points) Add an abstract method isBST to the BT class and override it in the subclasses, it verifies if the binary 
tree is a binary search tree. Restrictions: You are not allowed to use loops or checking if a reference is null or 
not. 

[] Write a static method in the BT class. It takes an array of integer values and creates a binary search 
tree by consecutively inserting these values to an empty tree (Nil). The method is required to return a reference 
of a Node object. You need to implement a helper function for inserting a new node to a binary search tree. 

[] Write a method to delete the node which has the given key. We assume that the binary tree is a 
binary search tree. 