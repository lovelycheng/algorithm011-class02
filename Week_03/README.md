学习笔记
### 第三周课时笔记

#### 分治

类似 fork-join 的方式，将大问题分解成几个小问题，小问题又再次分解成小问题，不断的向下，每个小问题将最终的结果返回，最终拼装成最终的返回结果。

#### 回溯

遍历所有可能性，检查有效性

1. 找到一个可能性的解
2. 或者遍历所有可能性的解，宣告不存在


#### 最近的公共祖先

前提：两节点死活都在同一颗树，最不济返回root，要么是root.left。要么是root.right。我的想法是从底向上遍历所有子节点，这样的好处是理论上找到第一个公共祖先就能返回。但是首先先压入栈凭空增加了复杂度，再然后递归，无疑也不是最好的解决方案。


模板代码

```
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root ==null){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        return left == null ? right : right == null ? left : root;
    }
```

#### 通过中序遍历和前序遍历构建树

中序遍历数组 + 前序遍历数组||后续遍历数组 能够唯一确定一颗树。

前序遍历的[0]是root；通过找到root在中序遍历的位置可以明确root的左子树和右子树***长度***；因为要通过找root的方式获取root的左右子树长度，使用HashMap 避免重复遍历寻找数据。

     更近一步，length的计算很复杂，能不能使用一些指针来做？length的计算：一个是左子树的右子树的左子树长度。。。在当层节点计算的时候，需要一个parent指针，用于计算当前current节点的左子树。
     
 ```
 
 TreeNode buildTree(int iStart,int iEnd,HashMap<Integer,Integer> val2index,int[] preorder,int[] inorder,int root) {
        // terminator
        if(iStart > iEnd){
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[root],null,null);
        int index = val2index.get(treeNode.val);
        
        TreeNode left = buildTree(iStart, index - 1, val2index, preorder, inorder,  root+1);
        TreeNode right = buildTree(index + 1,iEnd,val2index,preorder,inorder,root + (index - iStart) + 1);
        treeNode.left = left;
        treeNode.right = right;

        // reverse state
        return treeNode;
    }
    
 ```
 
#### 组合
     
     
回溯算法：

模板：

```


private void solve(ArrayDeque<Integer> stack, int[] nums, List<List<Integer>> lists, boolean[] used) {
         if (stack.size() == nums.length) {
            lists.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            used[i] = true;
            stack.addLast(nums[i]);
            solve(stack, nums, lists, used);
            stack.removeLast();
            used[i] = false;
        }
    }


```

时间复杂度：O(N*N!)；
     

组合问题：给n个数，取k个数，几种取法？k<=n;

```
if(stack.size() == k){
	add to answer;
}

stack.push(i: [1,n]);
recurse;
stack.pop();
```

这里有个优化，i <= n - (k-stack.size) + 1 ,这个需要归纳法归纳一下

回溯的方法感觉很多都是无差别遍历的，剪枝工作需要特别注意，这个是一个案例。

###  全排列 和全排列重复

可以使用 List 代替 stack；

只要模板里面的用法是栈的用法就行。使用额外的数组元素表示当前指针对应的元素是否被用过。

重复数据需要做人肉的数学归纳，有一些不要的数据要continue，这里的重复数据没有特别懂。












