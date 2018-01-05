package com.leetcode;

public class SearchForARange {
	/**
	 * Ѱ��Ŀ��ֵ��������Χ�������������ô����-1��-1
	 * @param nums
	 * @param target
	 * @return
	 */
    public static int[] searchRange(int[] nums, int target) {
    	int index=binSearch(nums,target);
    	System.out.println("�������Ϊ��"+index);
    	if(index!=-1){//�����Ԫ�ش���
    		int left=index,right=index;
    		while(left>=0 && nums[left]==nums[index]){
    			left--;
    		}
    		left++;//����Ϊ�˽�������ʱ�������λ
    		while(right<=nums.length-1 &&nums[right]==nums[index]){
    			right++;
    		}
    		right--;
    		return new int[]{left,right};
    	}else{//��������ڣ�ֱ�ӷ��ؿ�λ����Ϣ
    		return new int[]{-1,-1};
    	}
    }
    /**
     * ���ַ�Ѱ��target��λ�ã���������ڣ���ôֱ�ӷ���-1
     * @param nums
     * @param target
     * @return
     */
    public static int binSearch(int []nums,int target){
    	int left=0,right=nums.length-1;
    	int mid=left+(right-left)/2;
    	while(left<=right){
    		if(nums[mid]==target){
    			return mid;
    		}else if(nums[mid]<target){
    			left=mid+1;
    		}else if(nums[mid]>target){
    			right=mid-1;
    		}
    		mid=left+(right-left)/2;
    	}
    	return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={5,7,7,8,8,10};
//		int []nums={};
		int target=1;
		int []re=searchRange(nums,target);
		System.out.println(re[0]+","+re[1]);
//		int r=binSearch(nums,target);
//		System.out.println(r);
	}

}
