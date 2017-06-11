package com.xjtu.play;

public class QuickSort1 {
	/**
	 * ��������
	 * @param nums
	 */
	public static void quickSort(int []nums,int low,int high){
		
		if(high<low){
			return ;
		}
		int left=low,right=high;//���ļ����к�ǿ��		
		int mid=nums[low];//ѡ���м�ֵ��һ���ѡ����ĵ�һ��Ԫ��
		while(high>low){	
			while(high>low && nums[high]>mid){//������ָ�룬�õ������С��ֵ
				high--;
			}
			nums[low]=nums[high];//���ұ߽�С�����������ָ��λ�õ���
			while(high>low && nums[low]<mid){//������ߵ�ָ�룬ֱ���ҵ�һ�������м�ֵ��Ԫ��
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
	 * �������
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
