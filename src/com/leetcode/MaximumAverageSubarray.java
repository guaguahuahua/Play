package com.leetcode;

public class MaximumAverageSubarray {
	
	/**
	 * 求给定长度连续的子数组，
	 * @param nums
	 * @param k
	 * @return
	 */
    public static double findMaxAverage(int[] nums, int k) {
        double max=Integer.MIN_VALUE;
        int i=0,j=0; //使用i,j来标记减位置和加位置
        int temp=0,times=k;
        while(times-- > 0){ //首先得到最开始的前k个元素的和
        	temp+=nums[j++];
        }
        System.out.println("j:"+j);
        System.out.println(temp);
        max= temp > max ? temp : max; 
    	for(int l=1;l<nums.length-k+1;l++){ //遍历数组的所有元素
    		temp=temp-nums[i]+nums[j];
    		System.out.println("tmp:"+temp);
    		max= temp > max ? temp : max; //最终只保存最大的k元组的和
    		System.out.println("max:"+max);
    		i++; //左右两个游标后移
    		j++;
    	}
    	return max/k;
    }
	public static void main(String []args){
//		int []nums={1,12,-5,-6,50,3};
		int []nums={5};
//		int []nums={4,2,1,3,3};
		int k=1;
		double res=findMaxAverage(nums,k);
		System.out.print(res+"\t");
	}
}
