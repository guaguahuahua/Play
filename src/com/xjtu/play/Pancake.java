package com.xjtu.play;

public class Pancake {
	
	private static int count=0;//����ͳ�Ƶݹ鱻���õĴ���
	/**
	 * ���ڵݹ���õĺ�����õ��Ż���ʽ���Ǽ�֦���������ٵ��õĴ���
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
	 * ��ת����
	 * @param nums ���ݴ��ԭ����
	 * @param end ��ת����λ��
	 */
	public static void turnAround(int []nums,int end){
		count++;
		//��������:��෭ת2*(n-1)��
		if(end==0){
			return;
		}
		int index=find(nums,end);
		//�����ֵ֮ǰ��Ԫ�ؽ�������
		reverse(index,nums);
		//�����˵����Ԫ�ؽ����������ȥ
		reverse(end-1,nums);
		//�ݹ���ã���ǰn-1��Ԫ���ٴη�ת��ʹ֮����
		turnAround(nums,--end);
	}
	/**
	 * ���ú�����������Ҫ���ò�����������
	 * @param end  ��end��0������Ҫ��������
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
	 * Ѱ�����ֵ����
	 * @param nums Ԫ����
	 * @param length ����Ĳ��ҳ���
	 * @return �������ֵ������
	 */
	public static int find(int []nums,int length){
		int max=0,index=0;//��ʼ�����Ԫ�غ�λ��
		for(int i=0;i<length;i++){
			if(nums[i]>max){
				max=nums[i];
				index=i;
			}
		}
		return index;
	}
}
