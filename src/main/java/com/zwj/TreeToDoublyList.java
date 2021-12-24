package com.zwj;
/*** 
 * description: 二叉搜索树与双向链表
 * @param: LeetCodeLink：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * @return:
 * @author zwj
 * @date: 2021/3/30 19:13
 */
public class TreeToDoublyList {
	private void mian() {
		Node root=null;
		Node result = solution(root, 1);
		Node lastNode=root;
		while (lastNode.right!=null) {
			lastNode=lastNode.right;
		}
		root.left=lastNode;
		lastNode.right=root;
	}

	Node solution(Node root,int leftOrRight) {
		if (root==null) {
			return null;
		}
		Node leftReturn = solution(root.left, 0);
		Node rightReturn = solution(root.right, 1);
		if (leftReturn==null&&rightReturn==null) {
			return root;
		}
		else if (leftReturn!=null&&rightReturn==null) {
			leftReturn.right=root;
			root.left=leftReturn;
			if (leftOrRight==0) {
				return root;
			}else {
				while(root.left!=null) {
					root=root.left;
				}
				return root;
			}
		}
		else if (leftReturn==null&&rightReturn!=null) {
			rightReturn.left=root;
			root.right=rightReturn;
			if (leftOrRight==1) {
				return root;
			}else {
				while(root.right!=null) {
					root=root.right;
				}
				return root;
			}
		}
		else {
			root.left=leftReturn;
			root.right=rightReturn;
			leftReturn.right=root;
			rightReturn.left=root;
			if (leftOrRight==0) {
				while(root.right!=null) {
					root=root.right;
				}
				return root;
			}
			else{
				while(root.left!=null) {
					root=root.left;
				}
				return root;
			}


		}

	}



	class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val,Node _left,Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	}


}
