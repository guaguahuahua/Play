package com.interview;

public class Test2 {

	public static String transfer(String s){
		//��׼���ұ�
		String str1="QWERTYUIOPASDFGHJKLZXCVBNM";
		String str2="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//������յĽ��
		StringBuilder sb=new StringBuilder();
		//�������ҵ�ÿһ���ַ��ڷ���Ȼ�����µ�����λ��
		for(int i=0; i<s.length(); i++){
			//��ȡһ��λ���ϵ��ַ�
			char temp=s.charAt(i);
			char c = ' ';
			//������ַ�����ô���в��ң����ַ�ֱ�����
			if((temp>='a' && temp<='z') || (temp>='A' && temp<='Z')){
				//�Ƿ�ΪСд��ĸ
				boolean flag=false;
				char temp1;
				//�����Сд��ĸ
				if(temp>='a' && temp<='z'){
					//���ַ�ת��Ϊ��д�ַ����в���
					temp1=Character.toUpperCase(temp);	
					flag=true;
				}else{
					temp1=temp;					
				}
				//�ҵ�����Ȼ�����ϵ�λ��
				int index=str2.indexOf(temp1);
				//�ҵ���Ȼ�����ϵĶ�Ӧλ�õ��ַ�
				if(flag){
					c=Character.toLowerCase(str1.charAt(index));
				}else{
					c=str1.charAt(index);	
				}
				sb.append(c);
			}else{
				sb.append(temp);
			}			
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="H kz k xif.";
//		String s="xif H kz k .";
		String res=transfer(s);
		System.out.println(res);
	}

}
