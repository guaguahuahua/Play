package com.leetcode;

public class SearchInSortedRotateArray {
	/**
	 * 首先寻找那个分割点，然后判断目标值在前一段还是后一段，判断再前一段还是后一段
	 * 那么使用二分法
	 * @param nums
	 * @param target
	 * @return
	 */
    public static int search(int[] nums, int target) {
    	int i;
    	for(i=1;i<nums.length;i++){
    		if(nums[i]<nums[i-1]){
    			break;
    		}
    	}
    	//找到了旋转点，旋转点左边的都是比较大的，右边都是比较小的
//    	System.out.println(i);
    	if(i<nums.length){//这说明有旋转点
    		if(nums[i]==target){//首先判断旋转点是不是目标值
    			return i;
    		}
    		if(nums[i]<target && nums[nums.length-1]>=target){//旋转点右侧，都是比较小的，如果目标再右侧范围内
    			return binSearch(nums,i,nums.length-1,target);
    		}
    		if(nums[i-1]>=target){//说明在旋转点的左侧，而且都是比较大的
    			return binSearch(nums,0,i-1,target);
    		}else{//目标值大于数组的最大值，返回不存在
    			return -1;
    		}
    		
    	}else{//这说明数组中没有旋转点，可以直接使用二分法查找了
    		return binSearch(nums,0,nums.length-1,target);
    	}
    }
    /**
     * 从旋转点的两侧进行二分查找
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static int binSearch(int []nums,int left,int right,int target){
    	
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
    	return -1;//最终啥都没有找到
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums={4,5,6,7,0,1,2};
		int []nums={};
		int target=5;
		int r=search(nums,target);
		System.out.println("查找结果："+r);
		/*int []nums={0,1,2,4,5,6,7};
		int r=binSearch(nums,0,nums.length-1,3);
		System.out.println("查找结果："+r);*/
	}

}
