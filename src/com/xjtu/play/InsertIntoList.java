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
	 * ����Ϊ����һ���൱�����㷨����Ϊ���������������в������ݣ����ղ��������ô��������ݿ��ܻᵼ��ǰ�����������Ϊ�ƶ�����ʧ
	 * ��������ĳ���һֱ����Ҳ����˵���������鳤�����ӣ����ƶ���Ԫ���ڼ��١�
	 * @param array 	����Ķ���
	 * @param location  ����λ��
	 * @param value		�����ֵ
	 * @return
	 */
	public static boolean insert(Node array,int location,int value){
		
		if(location<0 || location>array.nums.length-1){
			System.out.println("index out of boundary!");
		}
		if(array.size>=N){
			System.out.println("����");
			return false;
		}
		//����ƶ���λ�ú����Ԫ��,Ҳ����˵���м�������ǻḲ�Ǻ����Ԫ��
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
