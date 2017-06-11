package com.xjtu.play;

public class ShellSort {
	/**
	 * 希尔排序算法
	 * @param nums
	 * @param distance 每次步长
	 * @param times 循环的次数
	 */
	public static void shellSort(int []nums,int[]distance){
		int span=0;
		for(int total=0;total<distance.length;total++){//总共循环的次数，主要是由步长的集合来控制的
			span=distance[total];//获取第一个步长
			for(int i=0;i<span;i++){//遍历所有的组数
				for(int j=i;j<nums.length-span;j+=span){//进行直接插入排序
					int tmp=nums[j+span];
					int k=j;
					while(k>-1 && nums[k]>tmp){
						nums[k+span]=nums[k];
						k-=span;
					}
					nums[k+span]=tmp;
				}
			}
//			show(nums);	
//			System.out.println();
		}
	}
	public static void show(int []nums){
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+"\t");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={64,34,25,87,12,38,56,46,14,77,92,23};
		int []distance={6,3,1};
		shellSort(nums,distance);
	}
}
