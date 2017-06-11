package com.xjtu.play;

public class ShellSort {
	/**
	 * ϣ�������㷨
	 * @param nums
	 * @param distance ÿ�β���
	 * @param times ѭ���Ĵ���
	 */
	public static void shellSort(int []nums,int[]distance){
		int span=0;
		for(int total=0;total<distance.length;total++){//�ܹ�ѭ���Ĵ�������Ҫ���ɲ����ļ��������Ƶ�
			span=distance[total];//��ȡ��һ������
			for(int i=0;i<span;i++){//�������е�����
				for(int j=i;j<nums.length-span;j+=span){//����ֱ�Ӳ�������
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
