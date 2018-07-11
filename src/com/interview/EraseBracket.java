package com.interview;

public class EraseBracket {

	/**
	 * ����Ƕ�׵�����
	 * @param s String
	 * 			�������ŵ��ַ���
	 * @return String
	 * 			�������ⲿ���ŵĴ�
	 */
	public String eraseBracket(String s){
		int a1=0;
		int a2=0;
		int a3=0;
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='('){
				a1++;
			}else if(s.charAt(i)==')'){
				a1--;
			}else if(s.charAt(i)=='['){
				a2++;
			}else if(s.charAt(i)==']'){
				a2--;
			}else if(s.charAt(i)=='{'){
				a3++;
			}else if(s.charAt(i)=='}'){
				a3--;
			//����������ʱ������Ԫ����ӵ��ַ�����	
			}else{
				sb.append(s.charAt(i));
			}
		}
		//�������������ƥ���
		if(a1==0 && a2==0 && a3==0){
			if(s.charAt(0)=='('){
				sb.append(')');
				return '('+sb.toString();
			}else if(s.charAt(0)=='['){
				sb.append(']');
				return '['+sb.toString();
			}else if(s.charAt(0)=='{'){
				sb.append('}');
				return '{'+sb.toString();
			}
			
		}
		return "wrong combination of brackets";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s="(1,(2,3),(4,(5,6),7))";
//		String s="(1,(2,3),(4,(5,6),7)";
//		String s="[1,(2,3),(4,[5,6],7)]";
		String s="{1,{2,3},(4,[5,6],7)}";
		EraseBracket eraseBracket=new EraseBracket();
		String res=eraseBracket.eraseBracket(s);
		System.out.println(res);
	}

}
