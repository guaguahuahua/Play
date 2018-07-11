package com.interview;

public class IsRepeated {

	/**
	 * 使用bitmap的方法实现字符串中字符重复的判断
	 * @param s String 
	 * @return boolean
	 */
	public static boolean isRepeated(String s){
		//int类型4B==32bit，所以只需要8个整型的元素即可表示256个
		int []table=new int[8];
		for(int i=0; i<s.length(); i++){
			char temp=s.charAt(i);
			//将字符映射到数组的某个位置
			int index=(int)temp/32;
			//获得在数组内的偏移值
			int offset=(int)temp%32;
			//判断bitmap中该位置是否为1如果为1那么说明元素重复了，返回false
			if((table[index]&(1<<offset))!=0){
				return false;
			}
			table[index] |=(1<<offset);
		}
		return true;
	}
	
	/**
	 * 使用bitmap的方法判断给定的数组中时候有重复的元素
	 * @param array int[]
	 * @return	boolean
	 */
	public static boolean isRepeated(int []array){
		//在数组中最大值不确定的情况下，先经过遍历找到最大值然后再建立bitmap
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
		//第二次循环了开始寻找重复元素了
		for(int i=0; i<array.length; i++){
			//这是因为整形数组中可以存放32个数，所以数组的下标和偏移需要使用32这个元素
			int index=array[i]/32;
			int offset=array[i]%32;
			//判断当前元素是否已经出现过
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
