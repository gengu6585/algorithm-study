package com.zwj;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
/**
 * 最接近原点的 K 个点
 * LeetCodeLink:https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * @author Administrator
 *
 */
public class KClosest {
	private int length=0;
	public static void main(String[] args) {
		int [][]points= {{68,97},{34,-84},{60,100},{2,31},{-27,-38},{-73,-74},{-55,-39}};
		
		int[][] solution = new KClosest().solution(points, 2);
		System.out.println(Arrays.deepToString(solution));
	}
	int [][] solution(int [][]point,int k){
		if (point==null) {
			return null;
		}
		if (k>point.length) {
			return null;
		}
		this.length=point.length;
		heapBuild(point);
		int [][]result=new int[k][];
		int index=0;
		for (int i = point.length-1; i >= point.length-k; i--) {
			swap(point,0, i);
			this.length--;
			result[index]=point[i];
			index++;
			sink(point, 0);
		}
		
		
		return result;
	}
	void heapBuild(int[][]nums) {
		for (int i = (nums.length-1)/2; i >= 0; i--) {
			sink(nums, i);
		}
	}
	void sink(int[][]nums,int pos) {
		while (2*pos+1<length) {
			boolean flag=false;
			if (2*pos+2<length) {
				
				if (bigThan(nums, 2*pos+1, 2*pos+2)) {
					if (bigThan(nums, pos, 2*pos+2)) {
						swap(nums,pos, 2*pos+2);
						pos=2*pos+2;
						flag=true;
					}
				}else {
					if (bigThan(nums, pos, 2*pos+1)) {
						swap(nums,pos, 2*pos+1);
						pos=2*pos+1;
						flag=true;
					}
				}
			}else {
				if (bigThan(nums, pos, 2*pos+1)) {
					swap(nums,pos, 2*pos+1);
					pos=2*pos+1;
					flag=true;
				}
			}
			if (!flag) {
				break;
			}
		}
	}
	boolean bigThan(int [][]nums,int i,int j) {
		return (Math.pow(nums[i][0], 2)+Math.pow(nums[i][1], 2)>Math.pow(nums[j][0], 2)+Math.pow(nums[j][1], 2));
	}
	
	void swap(int[][]nums,int x,int y) {
		int []temp=nums[x];
		nums[x]=nums[y];
		nums[y]=temp;
	}
	

}
