package com.interview;

public class StringCompare {

	public static char[] stringCompare(String str1, String str2){
		StringBuilder sb=new StringBuilder();
		//����ѭ�������ַ���
		for(int i1=0, i2=0; i1<str1.length(); i1++){
			//�����ַ�����ͷ����һ���������ַ���2�����ַ��͵�һ���ַ���Ҳ��ͬ��Ҳ����ͨ���
			if(str1.charAt(i1)!=str2.charAt(i2) && str2.charAt(i2)!='*'){
				return new char[]{};
			//���str2��ʼ����ͨ���	
			}else if(str1.charAt(i1)!=str2.charAt(i2) && str2.charAt(i2)=='*'){
				sb.append(str1.charAt(i1));
				//���ͨ���֮����ַ��ͱȽϵ�str1����һ�ַ���ͬ����ô�ȽϽ���
				if(i1+1<str1.length() && i2+1<str2.length()){
					if(str2.charAt(i2+1)==str1.charAt(i1+1)){
						sb.append(str1.charAt(i1+1));
						break;
					}
				}
			//��������ַ�����ʼ��ȣ�	
			}else if(str1.charAt(i1)==str2.charAt(i2)){
				sb.append(str1.charAt(i1));
				i2++;
			}
		}
		return sb.toString().toCharArray();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="defg";
		String str2="v*f";
		char []res=stringCompare(str1, str2);
		for(char c:res){
			System.out.print(c);
		}
		System.out.println();
	}

}
