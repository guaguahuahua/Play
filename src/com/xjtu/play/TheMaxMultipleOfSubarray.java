package com.xjtu.play;

public class TheMaxMultipleOfSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={2,4,6};
		maxMultiple(nums);
	}
	/**
	 * ��Ҫ�Ǹ���һ������Ϊn���������飬Ȼ��������������г���Ϊ��n-1���������������ĳ˻�
	 * ��Ҫ�������������飬����һ����������ֱ����˴���ߵ��ұߣ��ұߵ���ߵ�����Ԫ�صĳ˻����е�������fabonacci��ֻ��������˳˷�����ʽ
	 * �����������һ��λ�ã�ֻҪ��left��right������ȥ�ҵ���λ�������Ԫ�س��������ɣ���Ϊ���������Ԫ���Ѿ���������ۼƳ˻�
	 * left rightԪ�ص���ѧ���ʽ����д����
	 * @param nums
	 * @return
	 */
	public static int maxMultiple(int []nums){
		
		int length=nums.length;
		int []left=new int[length];
		int []right=new int[length];
		left[0]=nums[0];
		right[length-1]=nums[length-1];
		
		for(int i=1;i<nums.length;i++){
			left[i]=nums[i]*left[i-1];
			right[length-i-1]=nums[length-i-1]*right[length-i];
		}
		int max=0;//����������ֵ
		for(int i=0;i<length;i++){
			if(i==0){
				max=right[i+1]>max ? right[i+1]: max;
			}else if(i==length-1){
				max=left[i-1]>max ? left[i-1] : max;
			}else{
				max=left[i-1]*right[i+1]>max ? left[i-1]*right[i+1]:max;
			}
		}
		
/*		for(int K:left){
			System.out.print(K+"\t");
		}
		System.out.println("right");
		for(int K:right){
			System.out.print(K+"\t");
		}*/
		System.out.println("max:"+max);
		return max;
	}
}
