package com.xjtu.play;

public class MaxandMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums={5,8,9,2,4};
		int []nums={1,1,1,1,9,1};
		maxAndMin(nums);
	}
	/**
	 * ����һ��ֱ����⣬������ͷֱ��β����ʱ�临�Ӷ�Ϊo(2n)
	 * @param nums
	 */
	public static void maxAndMin_direct(int []nums){
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++){///һ��ѭ�����ж���2�Σ��ֱ�����ֵ����Сֵ���бȽϣ���������ֵ����߱���СֵС����ô�͸���max��min
			if(nums[i]>max){
				max=nums[i];
			}
			if(nums[i]<min){
				min=nums[i];
			}
		}
		System.out.println("min="+min);
		System.out.println("max="+max);
	}
	
	public static void maxAndMin(int []nums){
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		if(nums.length>>1<<1==nums.length){//Ҳ�������������ż����Ԫ��
			for(int i=0;i<nums.length;){
				if(nums[i]>nums[i+1]){///ѡ��ÿ���еĽϴ�ֵ
					if(nums[i]>max){//�Ƚ�ÿ���еĽϴ�ֵ��Сֵ��max��min���ж��Ƿ�Ҫ����
						max=nums[i];
					}
					if(nums[i+1]<min){
						min=nums[i+1];
					}
				}else{
					if(nums[i+1]>max){
						max=nums[i+1];
					}
					if(nums[i]<min){
						min=nums[i+1];
					}
				}
				i+=2;
			}
		}else{//��������������Ԫ��
			for(int i=0;i<nums.length-1;i+=2){
				if(nums[i]>nums[i+1]){///ѡ��ÿ���еĽϴ�ֵ
					if(nums[i]>max){//�Ƚ�ÿ���еĽϴ�ֵ��Сֵ��max��min���ж��Ƿ�Ҫ����
						max=nums[i];
					}
					if(nums[i+1]<min){
						min=nums[i+1];
					}
				}else{
					if(nums[i+1]>max){
						max=nums[i+1];
					}
					if(nums[i]<min){
						min=nums[i+1];
					}
				}
			}
			//�Ƚ�ʣ�µ����һ��Ԫ��
			if(nums[nums.length-1]>max){
				max=nums[nums.length-1];
			}
			if(nums[nums.length-1]<min){
				min=nums[nums.length-1];
			}
		}
		System.out.println("min="+min);
		System.out.println("max="+max);
	}
}
