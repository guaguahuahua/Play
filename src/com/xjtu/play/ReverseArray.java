package com.xjtu.play;

import java.util.Arrays;

/**
 * 给定数组之后进行循环移位
 * @param nums
 */
public class ReverseArray {

	/**
	 * 直接法：将数据逐个的转移到数组的左侧位置
	 * @param nums
	 * @param k
	 */
	public static void reverse(int []nums,int k){
		k%=nums.length;//这块主要是为了解决偏移度超出了数组长度的情形，因为对于每个移位的元素，如果k==nums.length，那就说明钙元素没有移动
		for(int i=0;i<k;i++){
			int tmp=nums[nums.length-1];//首先将最后一个数据取出来
			for(int j=nums.length-1;j>0;j--){
				nums[j]=nums[j-1];
			}
			nums[0]=tmp;
		}
		show(nums);
	}
	/**
	 * 将数组转化为字符串，进行O(1)复杂度的操作之后，再将字符串转化为整型
	 * shishi:证明这样做是行不通的，因为最后还得转化成为字符数组来处理，反而复杂化了
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
	 * 将给定的元素局部进行逆置，再将元素从尾到头进行逆置一次
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
	 * 对数组进行局部的逆置,这个算法折腾了我很长时间，我觉得平时光顾着大体的思路了，没有关注到细节，
	 * 一落实到细节就容易出问题	
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
