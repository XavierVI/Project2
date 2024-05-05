# Project 2 - Singleton Pattern & Binary Trees

## Binary Tree Implementation

### BT Class
- height() - Calculate the height of a tree 
- isBST() - Verify a tree follows the BST theorem 
- delete() - deletes a node with a given key
- buildTree() - build a valid BST with a given input of an array of integers 
- insert() - creates a new node with the given value at the correct position in the BST

### Nil Class
- class used to represetn an empty tree, implements multiple BT methods, and uses the singleton pattern to ensure only one instance of Nil exists

### Node Class 
- implements BT
- toString() - override toString to give proper formatting 
- treeMax() - find the maximum value in the tree 
- treeMin() - find the minimum value in the tree 
- search() - searches for the node with a given key in the tree
- findParent() - finds the parent of the node of a given key in the tree

### Main Class
The main class is used to run the tests to verify all the above methods are working properly