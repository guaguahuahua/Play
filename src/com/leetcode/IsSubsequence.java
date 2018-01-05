package com.leetcode;

public class IsSubsequence {

	/**
	 * 判断是s是不是t的子串
	 * @param s 子串
	 * @param t 母串
	 * @return
	 */
    public static boolean isSubsequence1(String s, String t) {
    	int []table=new int[128];
    	for(int i=0;i<t.length();i++){//给hash表中添加数据
    		table[t.charAt(i)]++;
    	}
//    	show(table);
//    	System.out.println("first");
    	int i=0;
    	int ahead=0;//只能从该位置向后搜索，不能向前搜索
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
     * 查找是否匹配
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
    	int j=0;//用来标记比较的索引，总是从上个位置开始
		int len=0;//用来记录在母串中匹配元素的长度
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
		
		System.out.println("判断结果是："+result);
	}
}
