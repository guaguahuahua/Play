package com.interview;

public class CompareArray {

	/**
	 * ����������һ��Ԫ�ؿ�ʼ�Ƚ������в�ͬԪ�صĸ���
	 * @param array1	��һ�����飬int[]
	 * @param array2	�ڶ�������	int[]	
	 * @return int	��ͬԪ�ظ���
	 */
	public static int compareArray(int []array1, int []array2){
		
		int count=0;
		for(int i1=array1.length-1; i1>=0; i1--){
			for(int i2=array2.length-1; i2>=0; i2--){
				if(array1[i1]==array2[i2]){
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []array1={77,21,1,3,5};
		int []array2={1,3,5};
		int res=compareArray(array1, array2);
		System.out.println(res);
	}

}
