package com.interview;

public class J3 {

	//���ɸ��ֳ��ȵ��ַ���
	public static int count_1(String str){
		//����Ϊ1���ַ������ǻ���
		int count=str.length();
		//�ӳ���Ϊ2���ַ�����ʼ����
		for(int len=2; len<=str.length(); len++){
			
			for(int i=0; i<str.length()-len+1; i++){
				String temp=str.substring(i, i+len);
//				System.out.println(temp);
				if(isHui(temp)){
					count++;
				}
			}
			
		}
		System.out.println(count);
		return count;
	}
	
	public static void count(String str){
		//��������ַ����ĸ���
		int count=0;
		int all=(int) Math.pow(2, str.length());
		for(int i=1; i<all; i++){
			//�������ҵ�1Ԫ��λ�ö�Ӧ���ַ�
			int pos=0;
			String s="";
			int kinds=i;
//			while(kinds!=0){
//				int temp=kinds&1;
//				if(temp==1 && pos<str.length()){
//					s=s+str.charAt(pos);
//					pos++;
//				}
//				
//				kinds=kinds>>1;
//			}
			for(int j=0; j<str.length(); j++){
				int temp=kinds&(1<<j);
				if(temp==1){
					s=s+str.charAt(j);
				}
			}
			if(isHui(s)){
				count++;
			}
		}
		System.out.println(count);
	}
	

	public static boolean isHui(String str){		
		if(str.length()==0){
			return false;
		}
		int left=0, right=str.length()-1;
		
		while(left<right){
			
			if(str.charAt(left)!=str.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="ABA";
		count(str);
//		boolean res=isHui(str);
//		System.out.println(res);
	}

}
