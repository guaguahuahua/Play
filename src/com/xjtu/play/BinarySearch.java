package com.xjtu.play;

public class BinarySearch {

	/**
	 * 二分法完成查找过程
	 * @param nums
	 * @param value
	 * return 如果找到该元素，返回该元素的索引，如果没有找到，那么直接返回-1； 
	 */
	public static int binarySearch(int []nums,int value){
		int left=0,right=nums.length-1;
		int mid=left+(right-left)/2;//获得中间值
		while(left<=right){
			if(nums[mid]==value){
				return mid;
			}else if(nums[mid]<value){
				left=mid+1;
			}else if(nums[mid]>value){
				right=mid-1;
			}
			mid=left+(right-left)/2;//获得中间值
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={12,14,23, 25,	34,	38,	46,	56,	64,	77,	87,	92};
		int value=89;
		int r=binarySearch(nums,value);
		System.out.println("result:"+r);
	}

}
