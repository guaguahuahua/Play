package com.interview;

public class MedianOfTwoSortedArrays {

	/**
	 * �ҵ����������������ֵ
	 * ʹ�úϲ���˼�룬����������ϲ�Ϊһ�����飬�����м�ֵ
	 * @param nums1 int[]
	 * @param nums2 int []
	 * @return double ��ֵ
	 */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //���������������
    	int []all=new int[nums1.length+nums2.length];
    	int i, j, k;
    	//����������ŵ�һ��������
    	for(i=0, j=0, k=0; i<nums1.length && j<nums2.length; ){
    		if(nums1[i]<=nums2[j]){
    			all[k++]=nums1[i++];
    		}else{
    			all[k++]=nums2[j++];
    		}
    	}
    	//��ʣ���Ԫ�ؼ�����ӵ����������
    	while(i<nums1.length){
    		all[k++]=nums1[i++];
    	}
    	while(j<nums2.length){
    		all[k++]=nums2[j++];
    	}
    	//�����������Ԫ��
    	if((all.length>>1<<1)!=all.length){
    		return (double)all[(all.length-1)/2];
    	}else{
    	//ż����Ԫ��
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
