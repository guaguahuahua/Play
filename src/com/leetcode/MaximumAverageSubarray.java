package com.leetcode;

public class MaximumAverageSubarray {
	
	/**
	 * ��������������������飬
	 * @param nums
	 * @param k
	 * @return
	 */
    public static double findMaxAverage(int[] nums, int k) {
        double max=Integer.MIN_VALUE;
        int i=0,j=0; //ʹ��i,j����Ǽ�λ�úͼ�λ��
        int temp=0,times=k;
        while(times-- > 0){ //���ȵõ��ʼ��ǰk��Ԫ�صĺ�
        	temp+=nums[j++];
        }
        System.out.println("j:"+j);
        System.out.println(temp);
        max= temp > max ? temp : max; 
    	for(int l=1;l<nums.length-k+1;l++){ //�������������Ԫ��
    		temp=temp-nums[i]+nums[j];
    		System.out.println("tmp:"+temp);
    		max= temp > max ? temp : max; //����ֻ��������kԪ��ĺ�
    		System.out.println("max:"+max);
    		i++; //���������α����
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
