package com.interview;

public class StringCalculate {

	public static int stringCalculate(String str){
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<str.length(); i++){
			//�Ƚ��г˳�������
			if(str.charAt(i)=='*' || str.charAt(i)=='/'){
				//�Ƚ��������߱�����ɾ��
				sb.deleteCharAt(sb.length()-1);
				if(str.charAt(i)=='*'){
					int temp=(str.charAt(i-1)-'0')*(str.charAt(i+1)-'0');
					sb.append(temp);
					i++;
				}else{
					int temp=(str.charAt(i-1)-'0')/(str.charAt(i+1)-'0');
					sb.append(temp);
					i++;
				}
			//����мӼ���	
			}else{
				sb.append(str.charAt(i));
			}
		}
		System.out.println(sb.toString());
		String s=sb.toString();
		String temp="";
		int count=0;
		
		//��ʵǰ���ڴ���Ĺ����п��Խ����ź����ַ��ڶ��л��߶�ջ�н��д���
		//���ڽ��мӼ�������
		for(int i=0; i<s.length(); ){
			if(s.charAt(i)=='+' || s.charAt(i)=='-'){
				int j=i;
				//���ڻ���ұߵڶ�����
				String t=s.charAt(i+1)+"";
				i++;
				if(i+1<s.length()){
					if(s.charAt(i+1)>='0' && s.charAt(i+1)<='9'){
						t=t+s.charAt(i+1);
						i+=2;
					}
				}
				//���ϵ�һ����
				if(temp!=""){
					count+=Integer.parseInt(temp);
					temp="";
				}
				count=(s.charAt(j)=='+') ? count+Integer.parseInt(t) : count-Integer.parseInt(t);
			}else{
				temp=temp+s.charAt(i);
				i++;
			}
		}
		System.out.println(count);
		return count;
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="8+7*2-9/3";
		stringCalculate(str);
	}

}
