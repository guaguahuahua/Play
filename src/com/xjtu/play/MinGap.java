package com.xjtu.play;

import java.util.Arrays;

/**
 * ����С�ļ��
 * @author 22847
 *
 */
public class MinGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={5,3,2,7,0};
		minGap(nums);
	}
	/**
	 * ������һά����ʱ��ֱ��ͨ�������������ҵ����ʵ�
	 * @param nums
	 */
	public static void minGap_direct(int []nums){
		int min=Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				int gap=Math.abs(nums[i]-nums[j]);
				if(gap<min){
					min=gap;
				}
			}
		}
		System.out.println("min="+min);
	}
	/**
	 * ʹ�������򷨣�Ҳ�����Ƚ���������ʹ��ʱ�临�Ӷ�Ϊo(n*Log2(n)),֮���ٱ���һ�����飬ʱ�临�Ӷ�O(n)���Եó��ܵ�ʱ�临�Ӷ�Ϊo(n*(log2(n)+1))��
	 * �����ֱ�ӷ�������һ�������Ƶġ�
	 * @param nums
	 */
	public static void minGap(int []nums){
		Arrays.sort(nums);
		//����������
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
		int min=Integer.MAX_VALUE;
		for(int i=1;i<nums.length;i++){
			if((nums[i]-nums[i-1])<min){
				min=nums[i]-nums[i-1];
			}
		}
		System.out.println("min="+min);
	}
}
