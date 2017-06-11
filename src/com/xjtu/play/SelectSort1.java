package com.xjtu.play;

public class SelectSort1 {
	/**
	 * 直接选择排序
	 * @param nums
	 */
	public static void selectSort(int []nums){
		int index=0;
		for(int i=0;i<nums.length;i++){
			int min=nums[i];
			for(int j=i;j<nums.length;j++){//从剩余的部分找打最小值，
				if(nums[j]<min){
					min=nums[j];
					index=j;
				}
			}
			//将找到的最小值和初始位置进行交换
			int tmp=nums[i]; 
			nums[i]=min;
			nums[index]=tmp;
		}

	}
//	
//	public static void show(int []nums){
//		for(int i=0;i<nums.length;i++){
//			System.out.print(nums[i]+"\t");
//		}
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={64,34,25,87,12,38,56,46,14,77,92,23};
		selectSort(nums);
	}

}
