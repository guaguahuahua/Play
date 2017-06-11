package com.xjtu.play;

public class QuickSort1 {
	/**
	 * 快速排序
	 * @param nums
	 */
	public static void quickSort(int []nums,int low,int high){
		
		if(high<low){
			return ;
		}
		int left=low,right=high;//这块的技巧行很强，		
		int mid=nums[low];//选择中间值，一般的选数组的第一个元素
		while(high>low){	
			while(high>low && nums[high]>mid){//左移右指针，得到比左边小的值
				high--;
			}
			nums[low]=nums[high];//将右边较小的数覆盖左边指针位置的数
			while(high>low && nums[low]<mid){//右移左边的指针，直到找到一个大于中间值的元素
				low++;
			}
			nums[high]=nums[low];
		}
		nums[low]=mid;
		quickSort(nums,left,low-1);
		quickSort(nums,low+1,high);
//		System.out.println("after:");
//		show(nums);
	}
	/**
	 * 输出函数
	 * @param nums
	 */
	public static void show(int []nums){
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={64,34,25,87,12,38,56,46,14,77,92,23};
		System.out.println("before");
		show(nums);
		int high=nums.length-1;
		int low=0;
		quickSort(nums,low,high);
	}
}
