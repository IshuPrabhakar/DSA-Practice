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
