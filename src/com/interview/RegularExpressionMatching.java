package com.interview;

public class RegularExpressionMatching {
	
	/**
	 * �ж������ַ����Ƿ�ƥ��,���а�����������ŵ����
	 * @param s String
	 * @param p String
	 * @return boolean
	 */ 
    public boolean isMatch(String s, String p) {
    	//����ַ���p��û�������ַ�
    	if(p.indexOf('.')==-1 && p.indexOf('*')==-1){
    		//�Ƚϳ���,�����ֱ�ӷ���false
    		if(p.length()==s.length()){
    			//�Ƚ�ÿһ���ַ���һ������ȷ���false
    			for(int i=0; i<p.length(); i++){
        			if(p.charAt(i)!=s.charAt(i)){
        				return false;
        			}
        		}
    		}else{
    			return false;
    		}
    	//���������ַ����ַ���
    	}else{
    		
    	}
    	
    	return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
