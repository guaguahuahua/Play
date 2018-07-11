package com.interview;

public class MedianOfTwoSortedArrays {

	/**
	 * 找到两个有序数组的中值
	 * 使用合并的思想，将两个数组合并为一个数组，返回中间值
	 * @param nums1 int[]
	 * @param nums2 int []
	 * @return double 中值
	 */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //用来存放两个数组
    	int []all=new int[nums1.length+nums2.length];
    	int i, j, k;
    	//将两个数组放到一个数组中
    	for(i=0, j=0, k=0; i<nums1.length && j<nums2.length; ){
    		if(nums1[i]<=nums2[j]){
    			all[k++]=nums1[i++];
    		}else{
    			all[k++]=nums2[j++];
    		}
    	}
    	//将剩余的元素继续添加到大的数组中
    	while(i<nums1.length){
    		all[k++]=nums1[i++];
    	}
    	while(j<nums2.length){
    		all[k++]=nums2[j++];
    	}
    	//如果是奇数个元素
    	if((all.length>>1<<1)!=all.length){
    		return (double)all[(all.length-1)/2];
    	}else{
    	//偶数个元素
    		return ((double)all[all.length/2]+(double)all[all.length/2-1])/2;
    	}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums1={1,3};
//		int []nums2={2};
		
//		int []nums1={1,2};
//		int []nums2={3,4};
		
		int []nums1={1,3,4,5};
		int []nums2={2,8};
		
		double res=findMedianSortedArrays(nums1, nums2);
		System.out.println(res);
	}

}
