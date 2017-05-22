package com.xjtu.play;

public class InsertIntoList {
	private static int N=20; 
	//node's structure
	class Node{
		int []nums=new int[N];
		int size;
	}
	public static void initial(Node node){
		node.size=0;
	}
	/**
	 * 我认为这是一个相当糟糕的算法，因为如果随机的往数组中插入数据，按照插入规则，那么后面的数据可能会导致前面插入数据因为移动而丢失
	 * 但是数组的长度一直增大，也就是说，随着数组长度增加，所移动的元素在减少。
	 * @param array 	插入的对象
	 * @param location  插入位置
	 * @param value		插入的值
	 * @return
	 */
	public static boolean insert(Node array,int location,int value){
		
		if(location<0 || location>array.nums.length-1){
			System.out.println("index out of boundary!");
		}
		if(array.size>=N){
			System.out.println("已满");
			return false;
		}
		//向后移动该位置后面的元素,也就是说从中间插入总是会覆盖后面的元素
		for(int i=array.size;i>location;i--){
			array.nums[i]=array.nums[i-1];
		}
		array.nums[location]=value;
		array.size++;
		return true;
	}
	
	public static void main(String []args){
		
		InsertIntoList insert=new InsertIntoList();
		Node nums=insert.new Node();
		insert.initial(nums);
		for(int i=0;i<20;i++){
			insert.insert(nums, 19, i);
		}
		
		for(int i=0;i<nums.nums.length;i++){
			System.out.print(nums.nums[i]+"\t");
		}
		
//		insert.insert(nums,5,88);
		
//		for(int i=0;i<nums.nums.length;i++){
//			System.out.print(nums.nums[i]+"\t");
//		}
	}
}
