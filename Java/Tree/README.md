### IMPORTANT

### Flatten binary tree to linked list

Approach:

The algorithm can be described as:

At a node(say cur) if there exists a left child, we will find the rightmost node in the left subtree(say prev).
- We will set prev’s right child to cur’s right child,
- We will then set cur’s right child to it’s left child.
- We will then move cur to the next node by assigning cur it to its right child
- We will stop the execution when cur points to NULL.

![sol-3-intuition-1](https://user-images.githubusercontent.com/72759521/184534883-52601904-c7a4-4ce3-97ea-74658181fb3f.jpg)


![105-Page-2](https://user-images.githubusercontent.com/72759521/184075598-97f5a4a8-1e3c-4f51-9397-d5641dff4b7c.png)


- Must remember
```java
        Depth of the tree and height of the tree both are different
        but in case oof maximum depth and height both are same
```


![image_1556551007](https://user-images.githubusercontent.com/72759521/181272416-e27844dc-2d08-4781-a64d-ef056734f864.png)

Preorder: Node -> Left -> Right

```java
public void preorder(TreeNode root, List<Integer> nums) {
  if (root == null) return;
  nums.add(root.val);
  preorder(root.left, nums);
  preorder(root.right, nums);
}

```
Inorder : Left -> Node -> Right

```java
public void inorder(TreeNode root, List<Integer> nums) {
  if (root == null) return;
  inorder(root.left, nums);
  nums.add(root.val);
  inorder(root.right, nums);
}
```
Postorder : Left -> Right -> Node

```java
public void postorder(TreeNode root, List<Integer> nums) {
  if (root == null) return;
  postorder(root.left, nums);
  postorder(root.right, nums);
  nums.add(root.val);
}
```
