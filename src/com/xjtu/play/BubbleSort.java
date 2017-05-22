package com.xjtu.play;

import java.util.Random;

public class BubbleSort {
	public static int N=100;
	
	public static void bubbleSort(int []nums){
		boolean flag=false;
		for(int i=0;i<nums.length;i++){
			for(int j=1;j<nums.length-i;j++){
				
				if(nums[j-1]>nums[j]){//进行交换，将较大的数交换到最后边
					int tmp=nums[j];
					nums[j]=nums[j-1];
					nums[j-1]=tmp;
					flag=true;//主要是为了针对元素有序的情形
				}
			}
			if(!flag){
				break;
			}
		}
		
		for(int K:nums){
			System.out.print(K+"\t");
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random=new Random();
		int []nums=new int[N];
		for(int i=0;i<N;i++){
			nums[i]=random.nextInt(N);
		}
		bubbleSort(nums);
		
	}

}
