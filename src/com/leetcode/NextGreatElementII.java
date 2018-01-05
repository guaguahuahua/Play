package com.leetcode;

public class NextGreatElementII {

	/**
	 * 寻找下一个比当前元素大的元素，并将查找结果放置在数组中，如果没有找到该元素，那么直接置为-1
	 * @param nums
	 * @return
	 */
    public static int[] nextGreaterElements1(int[] nums) {
        int []result=new int[nums.length];
    	for(int i=0;i<nums.length;i++){
    		int index=i;
    		boolean flag=false;
    		while(index<nums.length){
    			if(nums[i]<nums[index]){
    				flag=true;
    				break;
    			}
    			index++;
    		}
    		if(flag){//这说明在左侧已经找到了这个元素
    			result[i]=nums[index];
    			flag=false;
    		}else{//否则在该元素的左侧寻找
    			index=0;
    			while(index<i){
    				if(nums[i]<nums[index]){
    					flag=true;
    					break;
    				}
    				index++;
    			}
    			if(flag){//说明在左侧找到了这个元素
    				result[i]=nums[index];
    				flag=false;
    			}else{
    				result[i]=-1;//标识为没有找到
    			}
    		}
    	}
        return result;
    }
    /**
     * 来自leetcode社区的改进算法，比上面的要简洁许多，人家不是遍历了左边和右边这种分类，而是使用了取余的思想
     * 很顺滑的遍历过了左右两侧，同时减少了大部分的冗余代码
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements(int[] nums) {
    	int []result=new int[nums.length];
    	for(int i=0;i<nums.length;i++){
    		boolean flag=false;
    		for(int j=0;j<nums.length;j++){
    			if(nums[(i+j)%nums.length]>nums[i]){
    				result[i]=nums[(i+j)%nums.length];
    				flag=true;
    				break;
    			}
    		}
    		if(!flag){
    			result[i]=-1;
    		}
    	}
    	return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums={1,2,1};
		int []nums={1,2,3,4};
//		int []nums={1,3,4,2};
		int []res=nextGreaterElements(nums);
		for(int K:res){
			System.out.print(K+", ");
		}
	}

}
