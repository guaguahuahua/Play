package com.xjtu.play;

public class BinarySearch {

	/**
	 * ���ַ���ɲ��ҹ���
	 * @param nums
	 * @param value
	 * return ����ҵ���Ԫ�أ����ظ�Ԫ�ص����������û���ҵ�����ôֱ�ӷ���-1�� 
	 */
	public static int binarySearch(int []nums,int value){
		int left=0,right=nums.length-1;
		int mid=left+(right-left)/2;//����м�ֵ
		while(left<=right){
			if(nums[mid]==value){
				return mid;
			}else if(nums[mid]<value){
				left=mid+1;
			}else if(nums[mid]>value){
				right=mid-1;
			}
			mid=left+(right-left)/2;//����м�ֵ
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={12,14,23, 25,	34,	38,	46,	56,	64,	77,	87,	92};
		int value=89;
		int r=binarySearch(nums,value);
		System.out.println("result:"+r);
	}

}
