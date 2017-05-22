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
		int seperate=nums[left];//���һ����ʼֵ��Ҳ���ǳ�ֵ���ڵ�λ���൱�ڿ��ˣ����Ժ���Ҫ�����ǲ��ϵ�����λ����д���ݣ�ֱ����ָ�����ָ������
		
		while(left<right){//�������˵ȺŵĻ����ͻ�������⣬Ҳ���ǳ����� right x left ���Σ���������Ҫ��֤���ǵ�����ָ��������ʱ��ֹͣ
			while(left<right && seperate<=nums[right]){//�ҵ��Ҳཻ����
				right--;
			}
			nums[left]=nums[right];//���Ҳ��Сֵ�ŵ����
			
			while(left<right && seperate>=nums[left]){//�ҵ���ཻ����
				left++;
			}
			nums[right]=nums[left];//�����ϴ�ֵ�����Ҳ�
		}
		nums[left]=seperate;//ΪʲôҪ�ѳ�ֵ�����⣿����ǰ��25�У���Ϊ�Ѿ���leftд�뵽��num[right]֮�У����Կճ�����һ��λ�ã��պÿ���д��
		
		quickSort(nums,start,left-1);//�ݹ�ʵ��
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
