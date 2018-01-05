package com.leetcode;

public class SearchForARange {
	/**
	 * 寻找目标值的索引范围，如果不存在那么返回-1，-1
	 * @param nums
	 * @param target
	 * @return
	 */
    public static int[] searchRange(int[] nums, int target) {
    	int index=binSearch(nums,target);
    	System.out.println("最初索引为："+index);
    	if(index!=-1){//如果该元素存在
    		int left=index,right=index;
    		while(left>=0 && nums[left]==nums[index]){
    			left--;
    		}
    		left++;//这是为了解决不相等时多出的移位
    		while(right<=nums.length-1 &&nums[right]==nums[index]){
    			right++;
    		}
    		right--;
    		return new int[]{left,right};
    	}else{//如果不存在，直接返回空位置信息
    		return new int[]{-1,-1};
    	}
    }
    /**
     * 二分法寻找target的位置，如果不存在，那么直接返回-1
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
