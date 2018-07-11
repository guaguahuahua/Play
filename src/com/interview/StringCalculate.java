package com.interview;

public class StringCalculate {

	public static int stringCalculate(String str){
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<str.length(); i++){
			//先进行乘除法运算
			if(str.charAt(i)=='*' || str.charAt(i)=='/'){
				//先将乘数或者被除数删除
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
			//后进行加减法	
			}else{
				sb.append(str.charAt(i));
			}
		}
		System.out.println(sb.toString());
		String s=sb.toString();
		String temp="";
		int count=0;
		
		//其实前面在处理的过程中可以将符号和数字放在队列或者堆栈中进行处理
		//现在进行加减法运算
		for(int i=0; i<s.length(); ){
			if(s.charAt(i)=='+' || s.charAt(i)=='-'){
				int j=i;
				//现在获得右边第二个数
				String t=s.charAt(i+1)+"";
				i++;
				if(i+1<s.length()){
					if(s.charAt(i+1)>='0' && s.charAt(i+1)<='9'){
						t=t+s.charAt(i+1);
						i+=2;
					}
				}
				//加上第一个数
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
