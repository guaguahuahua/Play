package com.interview;

public class Test3 {

	public static int maxSubArray(int []nums){
		//�������������ĺ�
		int max=Integer.MIN_VALUE;
		//��ʱ��
		int sum=0;
		//����Ѱ������������
		for(int i=0; i<nums.length; i++){
			sum+=nums[i];
			//������Ϊ��������ʱ����Ϊ0
			if(sum<0){
				sum=0;
			//����������������͵�ֵ	
			}else{
				if(sum>max){
					max=sum;
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums={2, -3, 4, 11, -5, 8, 3, -6};
		int []nums={-1,-1,-1};
		int res=maxSubArray(nums);
		System.out.println(res);
	}

}
