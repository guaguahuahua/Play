package com.interview;

/**
 * ���������е���λ��
 * @author 22847
 *
 */
public class MiddleNum {

	/**
	 * ������ģ��������������ʹ�ò�������ķ�ʽ
	 * @param nums
	 * @return
	 */
	public static int middleNum(int []nums){
		//��������һ���൱������飬���ڴ�Ų�������Ľ��
		int []sort=new int[100];
		sort[0]=nums[0];
		int index=0;
		int middle;
		//ģ��������
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
			//�����ż��
			if(index>>1<<1==index){
				System.out.print(sort[index/2]+"\t");
			//���������	
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
