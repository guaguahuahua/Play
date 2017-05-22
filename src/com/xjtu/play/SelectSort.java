package com.xjtu.play;

import java.util.Random;

public class SelectSort {
	private static int N=90000;
	
	public static void selectSort(int []nums){
		
		int index=0;
		for(int i=0;i<nums.length;i++){
			int max=0;
			int j;
			for(j=0;j<nums.length-i;j++){//ÿ�α����Ķ��������ǰ�������Ԫ��
				
				if(nums[j]>max){//Ѱ�����ֵ
					max=nums[j];
					index=j;
				}
			}
			int tmp=nums[j-1];//���ҵ������ֵ�������е����һ��Ԫ�ؽ��н���
			nums[j-1]=nums[index];
			nums[index]=tmp;
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
		//����ǰ
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
		selectSort(nums);
	}

}
