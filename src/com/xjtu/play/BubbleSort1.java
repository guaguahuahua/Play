package com.xjtu.play;

public class BubbleSort1 {
	/**
	 * ð������
	 * @param nums
	 */
	public static void bubbleSort(int []nums){
		for(int i=0;i<nums.length;i++){
			int max=nums[0];
			int index=0;
			for(int j=0;j<nums.length-i;j++){//��ǰ�������Ԫ����Ѱ��
				if(nums[j]>max){
					max=nums[j];
					index=j;
				}
			}
			int tmp=nums[nums.length-i-1];
			nums[nums.length-i-1]=nums[index];
			nums[index]=tmp;
		}
		show(nums);
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
		bubbleSort(nums);
	}

}
