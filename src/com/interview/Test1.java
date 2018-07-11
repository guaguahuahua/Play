package com.interview;

public class Test1 {

	/**
	 * 输入数组，找到相邻最大的四个元素，并返回索引
	 * @param nums
	 * @param size	滑动窗口大小
	 * @return
	 */
	public static int maxEnergy(int []nums, int size){
		int max=Integer.MIN_VALUE;
		int index=-1;
		for(int i=0; i<nums.length-size+1; i++){
			int sum=nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
			if(sum>max){
				max=sum;
				index=i;
			}
		}		
		return index;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,17,1,1,12};
		int res=maxEnergy(nums, 4);
		System.out.println(res);
	}

}
