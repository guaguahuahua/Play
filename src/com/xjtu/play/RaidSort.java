package com.xjtu.play;

import java.util.ArrayList;
import java.util.List;

public class RaidSort {
	/**
	 * 基数排序算法，
	 * @param nums	元素数组
	 * @param length 表征元素数组中的最大元素的长度
	 */
	public static void raidSort(int []nums,int length){
		List<Integer> []raid=new ArrayList[10];//用来存放每次的分类的数据
		for(int i=0;i<10;i++){//初始化数据结构，便于存放
			raid[i]=new ArrayList<Integer>();
		}
		int factor=1;
		for(int times=0;times<length;times++){//这是用来控制循环的次数
			//分类
			for(int i=0;i<nums.length;i++){
				
				int tmp=nums[i];
				if(times>0){
					tmp=nums[i]/factor;
				}
				tmp=tmp%10;//获得个位元素
				raid[tmp].add(nums[i]);//将该元素放到合适的桶
			}
			//收集
			int index=0;
			for(int i=0;i<raid.length;i++){
				for(int j=0;j<raid[i].size();j++){
					nums[index++]=raid[i].get(j);
				}
				raid[i].clear();
			}
			factor*=10;
		}
//		System.out.println("after");
//		show(nums);
	}
	/**
	 * 输出函数
	 * @param nums
	 */
	public static void show(int []nums){
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={710,342,45,686,6,41,429,134,68,264};
		System.out.println("before");
		show(nums);
		raidSort(nums,3);
	}

}
