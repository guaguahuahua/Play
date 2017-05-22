package com.xjtu.play;

public class TopN {

	
	public static void topN(int n){
		int[]array=new int[n];
		int []nums={153256,783945,38,7678,325,3537389,1755,9878,153,87677};
		for(int i=0;i<nums.length;i++){//执行失败，因为仅仅循环一次是不足以完成的，前面的较大值可能会漏掉
			
			for(int j=0;j<array.length;j++){
				if(nums[i]>array[j]){
					array[j]=nums[i];
					break;
				}
			}
		}
		//输出TopN
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"  ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		topN(n);
	}

}
