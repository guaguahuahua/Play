package com.interview;

public class RegularExpressionMatching {
	
	/**
	 * 判定两个字符串是否匹配,其中包含了特殊符号的替代
	 * @param s String
	 * @param p String
	 * @return boolean
	 */ 
    public boolean isMatch(String s, String p) {
    	//如果字符串p中没有特殊字符
    	if(p.indexOf('.')==-1 && p.indexOf('*')==-1){
    		//比较长度,不相等直接返回false
    		if(p.length()==s.length()){
    			//比较每一个字符，一旦不相等返回false
    			for(int i=0; i<p.length(); i++){
        			if(p.charAt(i)!=s.charAt(i)){
        				return false;
        			}
        		}
    		}else{
    			return false;
    		}
    	//存在特殊字符的字符串
    	}else{
    		
    	}
    	
    	return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
