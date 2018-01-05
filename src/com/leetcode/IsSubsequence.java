package com.leetcode;

public class IsSubsequence {

	/**
	 * �ж���s�ǲ���t���Ӵ�
	 * @param s �Ӵ�
	 * @param t ĸ��
	 * @return
	 */
    public static boolean isSubsequence1(String s, String t) {
    	int []table=new int[128];
    	for(int i=0;i<t.length();i++){//��hash�����������
    		table[t.charAt(i)]++;
    	}
//    	show(table);
//    	System.out.println("first");
    	int i=0;
    	int ahead=0;//ֻ�ܴӸ�λ�����������������ǰ����
    	while(i<s.length()){
    		if(ahead<=s.charAt(i) && table[s.charAt(i)]>0){
    			table[s.charAt(i)]--;
    		}else{
    			return false;
    		}
    		ahead=s.charAt(i);
    		i++;
    	}
    	
    	/*int i=0;    	
    	while(i<s.length()){
    		if(table[s.charAt(i)]>0){
    			table[s.charAt(i)]--;
    		}else{
    			return false;
    		}
    		i++;
    	}*/
//    	System.out.println("seconde");
//    	show(table);
    	return true;
    }
    public static void show(int []nums){
    	for(int i=0;i<nums.length;i++){
    		System.out.print(nums[i]+"\t");
    	}
    	System.out.println();
    }
    /**
     * �����Ƿ�ƥ��
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
    	int j=0;//������ǱȽϵ����������Ǵ��ϸ�λ�ÿ�ʼ
		int len=0;//������¼��ĸ����ƥ��Ԫ�صĳ���
    	for(int i=0;i<s.length();i++){
    		
    		while(j<t.length()){
    			if(s.charAt(i)==t.charAt(j++)){
    				len++;
    				break;
    			}
    		}
    	}
    	if(len!=s.length()){
    		return false;
    	}
    	return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "abc";
//		String t = "ahbgdc";
		
//		String s = "axc", t = "ahbgdc";
		
//		String s="", t="fsf";
		
//		String s="aaa", t="aac";
		
//		String s="acb",t="ahbgdc";
		
		String s="twn",t="xxxtxxxwxxxxn";
		boolean result=isSubsequence(s,t);
		
		System.out.println("�жϽ���ǣ�"+result);
	}
}
