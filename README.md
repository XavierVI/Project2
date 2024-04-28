# Tasks 👄
#### [X] Override the method toString in the Node class, such that the structure of the binary tree can be translated to the following string format: **Node(num, string_of_left_subtree, string_of_right_subtree)**. For example, the tree showed above is translated to the string **Node(3, Node(1, Nil, Node(4, Nil, Nil)), Node(2, Nil, Nil))**.
- Already implemented in the Node class using recursion.

#### [x] Add an abstract method isBST to the BT class and override it in the subclasses, it verifies if the **binary tree** is a **binary search tree**. Restrictions: You are not allowed to use loops or checking if a reference is null or not.
**Notes and ideas**:
- A binary search tree is a binary tree where each node and it's children following this property: left.num < root.num < right.num.
- Use a modified version of pre-order-traversal.
  - The method will check the values of the nodes children and return false if they don't satisfy the BST property (left.num < root.num < right.num).
  - If both children are the **Nil** node, it will return true.
  - Otherwise, it will recursively call itself on the left and right children.

#### [] Write a static method in the BT class. It takes an array of integer values and creates a **binary search tree** by consecutively inserting these values to an empty tree (Nil). The method is required to return a reference of a Node object. You need to implement a helper function for inserting a new node to a binary search tree. 

#### [] Write a method to delete the node which has the given key. We assume that the binary tree is a binary search tree.
**Notes and ideas**:
- It is not specified the result has to be a balanced BT.


## Description of each class
#### Main
Used to create BTs and run tests.

#### BT
The abstract class from the instructions. Inherited by both Node and Nil.

#### Nil
This is the class that uses the singleton pattern. It creates one instance of itself and that one instance is placed in a BT to represent NIL (or nothing is there).

#### Node
This class represents a node in a BT.