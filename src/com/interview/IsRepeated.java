package com.interview;

public class IsRepeated {

	/**
	 * ʹ��bitmap�ķ���ʵ���ַ������ַ��ظ����ж�
	 * @param s String 
	 * @return boolean
	 */
	public static boolean isRepeated(String s){
		//int����4B==32bit������ֻ��Ҫ8�����͵�Ԫ�ؼ��ɱ�ʾ256��
		int []table=new int[8];
		for(int i=0; i<s.length(); i++){
			char temp=s.charAt(i);
			//���ַ�ӳ�䵽�����ĳ��λ��
			int index=(int)temp/32;
			//����������ڵ�ƫ��ֵ
			int offset=(int)temp%32;
			//�ж�bitmap�и�λ���Ƿ�Ϊ1���Ϊ1��ô˵��Ԫ���ظ��ˣ�����false
			if((table[index]&(1<<offset))!=0){
				return false;
			}
			table[index] |=(1<<offset);
		}
		return true;
	}
	
	/**
	 * ʹ��bitmap�ķ����жϸ�����������ʱ�����ظ���Ԫ��
	 * @param array int[]
	 * @return	boolean
	 */
	public static boolean isRepeated(int []array){
		//�����������ֵ��ȷ��������£��Ⱦ��������ҵ����ֵȻ���ٽ���bitmap
		if(array.length==0){
			return false;
		}
		int max=Integer.MIN_VALUE;
		for(int i=0; i<array.length; i++){
			if(max<array[i]){
				max=array[i];
			}
		}
		int nums=max/32;
		int []table=new int[nums+1];
		//�ڶ���ѭ���˿�ʼѰ���ظ�Ԫ����
		for(int i=0; i<array.length; i++){
			//������Ϊ���������п��Դ��32����������������±��ƫ����Ҫʹ��32���Ԫ��
			int index=array[i]/32;
			int offset=array[i]%32;
			//�жϵ�ǰԪ���Ƿ��Ѿ����ֹ�
			if((table[index] & (1<<offset))!=0){
				return false;
			}
			table[index] |= (1<<offset);
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s="abcaabbc";
//		boolean res=isRepeated(s);
//		System.out.println(res);
		int []array={2,7,4,9,1,10,5,8,1};
		boolean res=isRepeated(array);
		System.out.println(res);
	}

}
