# 学习笔记
### 二叉树

前序遍历 pre-order 根左右

中序遍历 in-order 左根右

后序遍历 post-order 左右根

### 二叉搜索树 

没有平衡，
best O(logn) worst O(n)退化成一个链表


#### 递归遍历经典代码段

```
if(root == null){
	return;
}
list.add(root.val); // 前序遍历
preorder(root.left, list);
list.add(root.val); // 中序遍历
preorder(root.right, list);
list.add(root.val); // 后序遍历
```

#### 栈遍历经典代码段

 ```
 Stack<Node> stack = new Stack();
 Node temp = root;
 List<Integer> list = new ArrayList();
 while(temp != null || !stack.isEmpty() ){
         while(temp != null){
         	stack.add(temp);
         	// list.add(temp.val); 前序遍历
         	//list.add(0,node.val); 后续遍历  需要反序的前序
         	temp = temp.left;
         }
         
         Node node = stack.pop();
         temp = node.right;
         //list.add(node.val); 中序遍历
 }
 
 ```

在里面的while 循环中，优先处理的一边是方向的开始、结束的一边是方向的具体指向。左->右和右-〉左都无法处理 左右中的情况，只能反序。 另外一个后续遍历 反序的例子：

```
Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode c = treeNode;
        stack.push(treeNode);
        while (c != null || !stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
            list.add(0,node.val);
        }
        
```
这种倒着来的方式只能用于 前序遍历和后续遍历；因为只有一个循环、能控制的是 中 - 左右 还是中 - 右左 由于栈的性质、left和right谁后放先读谁。

### 字母异位词分组

这个分组不是大问题，关键是分组的key怎么选取，我开始想到的是charArray排序得到一个新的string作为key、过了。但是这样需要对每个str做排序，感觉不是特别好，看看题解，有通过字母计数器的方式，解题时间变长了。可以改进的是 int[]能用char[]来做。时间变快了。

评论中有一个很有意思的回答，数学基础是 一个正整数能写成几个质数之积。每一个字母对应一个质数，每出现一个字母，key乘以对应的质数，最终一个字符串能得到一个inteher，除非另一个字符串有和他一样的字符和出现次数。


这个做法能用作于字符串比较。发散想想！只要是比较、不考虑顺序好像都能用。


### 丑数 
没看懂动态规划

###  K个高频元素

我的思路：用Double end linkedlist 实现了一个优先“队列”，但是性能很低。最差情况下是每次读取元素，都需要将node往前移动。

这样做的问题是效率低。每次移动链表需要遍历队列，复杂度是O（n^2）

看完解法：
java的优先队列：用二叉堆实现的优先队列。

优先队列分析：http://blog.lovelycheng.tech/archives/priorityqueue










