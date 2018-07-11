package com.interview;

public class Test2 {

	public static String transfer(String s){
		//标准查找表
		String str1="QWERTYUIOPASDFGHJKLZXCVBNM";
		String str2="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//存放最终的结果
		StringBuilder sb=new StringBuilder();
		//遍历，找到每一个字符在非自然键盘下的索引位置
		for(int i=0; i<s.length(); i++){
			//获取一个位置上的字符
			char temp=s.charAt(i);
			char c = ' ';
			//如果是字符，那么进行查找，非字符直接添加
			if((temp>='a' && temp<='z') || (temp>='A' && temp<='Z')){
				//是否为小写字母
				boolean flag=false;
				char temp1;
				//如果是小写字母
				if(temp>='a' && temp<='z'){
					//将字符转化为大写字符进行查找
					temp1=Character.toUpperCase(temp);	
					flag=true;
				}else{
					temp1=temp;					
				}
				//找到非自然键盘上的位置
				int index=str2.indexOf(temp1);
				//找到自然键盘上的对应位置的字符
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
