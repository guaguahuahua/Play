package com.xjtu.play;

import java.util.Arrays;

/**
 * ��������֮�����ѭ����λ
 * @param nums
 */
public class ReverseArray {

	/**
	 * ֱ�ӷ��������������ת�Ƶ���������λ��
	 * @param nums
	 * @param k
	 */
	public static void reverse(int []nums,int k){
		k%=nums.length;//�����Ҫ��Ϊ�˽��ƫ�ƶȳ��������鳤�ȵ����Σ���Ϊ����ÿ����λ��Ԫ�أ����k==nums.length���Ǿ�˵����Ԫ��û���ƶ�
		for(int i=0;i<k;i++){
			int tmp=nums[nums.length-1];//���Ƚ����һ������ȡ����
			for(int j=nums.length-1;j>0;j--){
				nums[j]=nums[j-1];
			}
			nums[0]=tmp;
		}
		show(nums);
	}
	/**
	 * ������ת��Ϊ�ַ���������O(1)���ӶȵĲ���֮���ٽ��ַ���ת��Ϊ����
	 * shishi:֤�����������в�ͨ�ģ���Ϊ��󻹵�ת����Ϊ�ַ������������������ӻ���
	 * @param nums
	 * @param k
	 */
	public static void reverse_1(int []nums,int k){
		String str=Arrays.toString(nums);
		System.out.println(str);
		String tmp1=str.substring(0,nums.length-k);
		System.out.println(tmp1);
		String tmp2=str.substring(nums.length-k);
		System.out.println(tmp2);
		for(int i=0;i<(tmp1+tmp2).length();i++){
			nums[i]=(tmp1+tmp2).charAt(i)-'0';
		}
		show(nums);
	}
	
	/**
	 * ��������Ԫ�ؾֲ��������ã��ٽ�Ԫ�ش�β��ͷ��������һ��
	 * @param nums
	 * @param k
	 */
	public static void reverse_2(int []nums,int k){
		k%=nums.length;
		localReverse(nums,0,nums.length-k-1);
		localReverse(nums,nums.length-k,nums.length-1);
		localReverse(nums,0,nums.length-1);
	}
	/**
	 * ��������оֲ�������,����㷨�������Һܳ�ʱ�䣬�Ҿ���ƽʱ����Ŵ����˼·�ˣ�û�й�ע��ϸ�ڣ�
	 * һ��ʵ��ϸ�ھ����׳�����	
	 * @param nums
	 * @param begin
	 * @param end
	 */
	public static void localReverse(int []nums,int begin,int end){
		while(begin<end){
			int tmp=nums[begin];
			nums[begin]=nums[end];
			nums[end]=tmp;
			begin++;
			end--;
		}
		show(nums);
	}
	public static void show(int []nums){
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []nums={2,4,3,1,5,8};
		reverse_2(nums,3);
	}

}
