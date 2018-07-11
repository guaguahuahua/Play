package com.leetcode;

public class InitiateTest {
	/**
	 * ʹ��bitmap �ķ�ʽ��������
	 * @param nums int[]
	 * @return int
	 */
	public static int findRepeatedEle(int []nums){
		//�ҵ������е����ֵ,��������û���ظ���
		int max=Integer.MIN_VALUE;
		for(int K:nums){
			if(K>max){
				max=K;
			}
		}
		//int ռ�õ��ֽڴ�С��4B
		int length=max/32;
		int []map=new int[length+1];
		for(int i=0; i<nums.length; i++){
			int loc=nums[i]/32;
			int pia=nums[i]%32;
			map[loc]=map[loc]|(1<<pia);
		}
		//�������֮��Ľ��
		for(int i=0; i<map.length; i++){
			for(int j=0; j<32; j++){
				if((map[i]&(1<<j))!=0){
					System.out.print(i*32+j+"\t");
				}
			}
		}
		System.out.println();
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={5,8,1,12,6,2};
		findRepeatedEle(nums);
	}

}
