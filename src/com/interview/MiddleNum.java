package com.interview;

/**
 * 求数据流中的中位数
 * @author 22847
 *
 */
public class MiddleNum {

	/**
	 * 用数组模拟数据流，我们使用插入排序的方式
	 * @param nums
	 * @return
	 */
	public static int middleNum(int []nums){
		//我们申请一个相当大的数组，用于存放插入排序的结果
		int []sort=new int[100];
		sort[0]=nums[0];
		int index=0;
		int middle;
		//模拟数据流
		for(int i=1; i<nums.length; i++){
			int t=nums[i];
			int j=index;
			while(j>=0 && t<sort[j]){
				sort[j+1]=sort[j];
				j--;
			}
			if(j<0){
				j=0;
			}
			sort[j]=t;
			//如果是偶数
			if(index>>1<<1==index){
				System.out.print(sort[index/2]+"\t");
			//如果是奇数	
			}else{
				System.out.print((sort[index/2]+sort[index/2+1])/2+"\t");
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={5,3,7,2,4,6,8};
		middleNum(nums);
	}

}
