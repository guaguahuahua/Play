package com.leetcode;

public class InitiateTest {
	/**
	 * 使用bitmap 的方式进行排序
	 * @param nums int[]
	 * @return int
	 */
	public static int findRepeatedEle(int []nums){
		//找到数组中的最大值,假设数据没有重复，
		int max=Integer.MIN_VALUE;
		for(int K:nums){
			if(K>max){
				max=K;
			}
		}
		//int 占用的字节大小是4B
		int length=max/32;
		int []map=new int[length+1];
		for(int i=0; i<nums.length; i++){
			int loc=nums[i]/32;
			int pia=nums[i]%32;
			map[loc]=map[loc]|(1<<pia);
		}
		//输出排序之后的结果
		for(int i=0; i<map.length; i++){
			for(int j=0; j<32; j++){
				if((map[i]&(1<<j))!=0){
					System.out.print(i*32+j+"\t");
				}
			}
		}
		System.out.println();
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={5,8,1,12,6,2};
		findRepeatedEle(nums);
	}

}
