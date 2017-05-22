package com.xjtu.play;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={1,2,3,7,4,11};
		int value=9;
		int []r=twoSum(nums,value);
		System.out.println(r[0]+", "+r[1]);
		
		//3 sum
		int []num={-1,0,1,2,-1,-4};
		int v=0;
		List re=threeSum(num,v);
		for(int i=0;i<re.size();i++){
			System.out.println(re.get(i));
		}
	}
	/**
	 * 求数组中两个数的索引，使得这两个数的和是给定的sum，每个元素只能使用一次，
	 * 直接法是双层的for循环，但是时间复杂度太高o(n*n)，效率很低
	 * 现在采用的是先排序后寻找的方式，时间复杂度为o[n*(log2(n)+1)]
	 * @param nums
	 * @param sum
	 * @return
	 */
	public static int []twoSum(int []nums,int sum){
		Arrays.sort(nums);
		int left=0,right=nums.length-1;
		while(left<right){
			if(nums[left]+nums[right]==sum){
				return new int[]{nums[left],nums[right]};
			}else if(nums[left]+nums[right]<sum){
				left++;
			}else if(nums[left]+nums[right]>sum){
				right--;
			}
		}
		return new int[]{nums[left],nums[right]};
	}
	/**
	 * 求三个元素的和的情形
	 * 但是有点没有处理，就是重复情形，也就是说，[-1, 0, 1],[0, 1, -1]认为是一个情形，虽然他们的排序有所不同，但是
	 * 结果是一样的，所以需要做的就是直接在后面一层过滤将含有相同元素的组合过滤掉。
	 * @param nums
	 * @param value
	 * @return
	 */
	public static List threeSum(int []nums,int value){
		List <List> result=new ArrayList<List>();
		for(int i=0;i<nums.length-2;i++){
			if(i>0 && nums[i]==nums[i-1]){//这块主要是排除相同的情形
				continue;
			}
			for(int j=i+1;j<nums.length-1;j++){
				if(j>i+1 && nums[j]==nums[j-1]){
					continue;
				}
				for(int k=j+1;k<nums.length;k++){
					if(k>j+1 && nums[k]==nums[k-1]){
						continue;
					}
					if(nums[i]+nums[j]+nums[k]==value){
						List inner=new ArrayList<Integer>();
						inner.add(nums[i]);
						inner.add(nums[j]);
						inner.add(nums[k]);
						result.add(inner);
					}
				}
			}
		}
		return result;
	}
}
