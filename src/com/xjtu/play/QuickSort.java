package com.xjtu.play;

import java.util.Random;

public class QuickSort {
	public static int N=10;
//	int []nums={4,6,4,6,1,7,2,3,8,4};
	public static void quickSort(int []nums,int start,int end){
		int left=start;
		int right=end;
		if(left-right>=1){
			return ;
		}
		int seperate=nums[left];//获得一个初始值，也就是初值所在的位置相当于空了，所以后面要做的是不断的往空位置填写数据，直到左指针和右指针碰见
		
		while(left<right){//如果添加了等号的话，就会出现问题，也就是出现了 right x left 情形，而我们需要保证的是当左右指针相遇的时候，停止
			while(left<right && seperate<=nums[right]){//找到右侧交换点
				right--;
			}
			nums[left]=nums[right];//把右侧较小值放到左侧
			
			while(left<right && seperate>=nums[left]){//找到左侧交换点
				left++;
			}
			nums[right]=nums[left];//把左侧较大值放在右侧
		}
		nums[left]=seperate;//为什么要把初值放在这？？看前面25行，因为已经将left写入到了num[right]之中，所以空出来了一个位置，刚好可以写入
		
		quickSort(nums,start,left-1);//递归实现
		quickSort(nums,left+1,end);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random=new Random();
		int []nums=new int[N];
		for(int i=0;i<N;i++){
			nums[i]=random.nextInt(N);
		}
		//test para
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
		quickSort(nums,0,nums.length-1);
		//test para 
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+"\t");
		}
	}
}
