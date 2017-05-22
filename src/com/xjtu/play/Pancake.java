package com.xjtu.play;

public class Pancake {
	
	private static int count=0;//用来统计递归被调用的次数
	/**
	 * 对于递归调用的函数最好的优化方式就是剪枝，尽量减少调用的次数
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums={1,5,3,4,2};
//		int []nums={6,3,2,1,5,4,0};
		long begin=System.currentTimeMillis();
		int []nums={3,2,1,6,5,4,9,8,7,0};
		int param=10;
		turnAround(nums,param);
		long end=System.currentTimeMillis();
		for(int K:nums){
			System.out.print(K+" ");
		}
		System.out.println();
		System.out.println(count);
		System.out.println("timeCost:"+(end-begin));
	}
	/**
	 * 翻转函数
	 * @param nums 数据存放原数组
	 * @param end 翻转结束位置
	 */
	public static void turnAround(int []nums,int end){
		count++;
		//出口条件:最多翻转2*(n-1)次
		if(end==0){
			return;
		}
		int index=find(nums,end);
		//将最大值之前的元素进行逆置
		reverse(index,nums);
		//将顶端的最大元素交换到最后面去
		reverse(end-1,nums);
		//递归调用，将前n-1个元素再次翻转，使之有序
		turnAround(nums,--end);
	}
	/**
	 * 逆置函数，给出需要逆置部分最后的索引
	 * @param end  从end到0都是需要进行逆置
	 * @param nums
	 */
	public static void reverse(int end,int []nums){
		for(int i=0;i<=end;i++){
			int tmp=nums[i];
			nums[i]=nums[end];
			nums[end--]=tmp;
		}
	}
	/**
	 * 寻找最大值函数
	 * @param nums 元数据
	 * @param length 数组的查找长度
	 * @return 返回最大值的索引
	 */
	public static int find(int []nums,int length){
		int max=0,index=0;//初始化最大元素和位置
		for(int i=0;i<length;i++){
			if(nums[i]>max){
				max=nums[i];
				index=i;
			}
		}
		return index;
	}
}
