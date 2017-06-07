package com.xjtu.play;

public class InsertSort {

	public static void insertSort(int []nums){
		
		for(int i=1;i<nums.length;i++){
			int tmp=nums[i];
			int j=i-1;
			while(j>-1 && nums[j]>tmp){//如果元素较小，准备移位
				nums[j+1]=nums[j];
				j--;
			}
			nums[j+1]=tmp;
		}
		show(nums);
	}
	public static void show(int []nums){
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+"\t");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={64,5,7,89,6,24};
		insertSort(nums);
	}
}
