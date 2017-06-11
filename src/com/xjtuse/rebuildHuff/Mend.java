package com.xjtuse.rebuildHuff;

public class Mend {

	public static String mend(String str){
		String mend="00000000";
		str=mend.substring(0,8-str.length())+str;
		return str;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="01";
		String r=mend(str);
		System.out.println(r);
	}

}
