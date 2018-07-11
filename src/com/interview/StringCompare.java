package com.interview;

public class StringCompare {

	public static char[] stringCompare(String str1, String str2){
		StringBuilder sb=new StringBuilder();
		//遍历循环两个字符串
		for(int i1=0, i2=0; i1<str1.length(); i1++){
			//两个字符串开头都不一样，并且字符串2的首字符和第一个字符串也不同，也不是通配符
			if(str1.charAt(i1)!=str2.charAt(i2) && str2.charAt(i2)!='*'){
				return new char[]{};
			//如果str2开始就是通配符	
			}else if(str1.charAt(i1)!=str2.charAt(i2) && str2.charAt(i2)=='*'){
				sb.append(str1.charAt(i1));
				//如果通配符之后的字符和比较的str1的下一字符相同，那么比较结束
				if(i1+1<str1.length() && i2+1<str2.length()){
					if(str2.charAt(i2+1)==str1.charAt(i1+1)){
						sb.append(str1.charAt(i1+1));
						break;
					}
				}
			//如果两个字符串开始相等，	
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
