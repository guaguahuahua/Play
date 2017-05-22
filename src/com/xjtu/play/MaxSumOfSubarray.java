package com.xjtu.play;

public class MaxSumOfSubarray {
	/**
	 * ��һ�������У�������������
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={2,8,-5,9,10};
		int r=maxSubarray_2(nums);
		System.out.println(r);
	}
	/**
	 * ֱ�ӷ���ֱ��ͨ�����ص�forѭ�����������
	 * @param nums
	 */
	public static void maxSubarray(int []nums){
		int sum=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++){
			for(int j=i;j<nums.length;j++){
				int count=0;			//ÿ�����������֮ǰ�Ƚ�count��0
				for(int k=i;k<=j;k++){
					count+=nums[k];
				}
				sum=count>sum ? count : sum ;
			}
		}
		System.out.println(sum);
	}
	/**
	 * ��ֱ�ӷ����Ż�����ֱ�ӷ��У�������forѭ�����ǴӴ��ʼ��λ�ñ����ۼӣ��������ظ��ģ�����ͨ��
	 * ʹ���ϴεļ���ֵ�����ټ�������Ҳ����ֻҪ���ϴε�ֵ������ϱ��ε�ֵ������ʵ�ִ�ͷ��β���ۼӹ���
	 * @param nums
	 * @return
	 */
	public static int maxSubarray_1(int []nums){
		
		int sum=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++){
			int count=0;
			for(int j=i;j<nums.length;j++){//��Ϊ�����ÿ����Ҫ�Ǻ���һ��ָ�룬�����ϴεĿ���ʹ���ϴε�ֵ
				count+=nums[j];
				sum=count>sum ? count : sum;
			}
		}
		return sum;
	}
	/**
	 * ���������еĽϴ�ֵ
	 * @param x
	 * @param y
	 * @return
	 */
	public static int bigger(int x,int y){
		return x>y ? x : y ;
	}
	/**
	 * ʹ�ö�̬�滮�ķ�ʽ�������������������
	 * @param nums
	 * @return
	 */
	public static int maxSubarray_2(int []nums){
		int length=nums.length;
		int []start=new int[length];
		int []all=new int[length];
		start[length-1]=nums[length-1];
		all[length-1]=nums[length-1];
		
		for(int i=length-2;i>=0;i--){
			start[i]=bigger(nums[i],nums[i]+start[i+1]);
			all[i]=bigger(all[i+1],start[i]);
		}
		return all[0];
	}
}
