package com.interview;

public class FindMinValue {
	    public int minNumberInRotateArray(int [] array) {
	        if(array.length==0){
	            return 0;
	        }        
	        return find(array, 0, array.length-1);
	    }
	    
	    public int find(int []nums, int left, int right){
	        while(left<right){
	            int m=left+(right-left)/2;
	            if(nums[left]<nums[m]){
	                left=m;
	            }else if(nums[m]<nums[right]){
	                right=m;
	            }else{
	            	break;
	            }
	        }
	        return nums[left+1];
	    }
	    
	    public static void main(String []args){
//	    	int []nums={3,4,5,6,7,1,2};
	    	int []nums={1,1,1,1,0,1};
	    	FindMinValue f=new FindMinValue();
	    	int res=f.minNumberInRotateArray(nums);
	    	System.out.println(res);
	    }
}
