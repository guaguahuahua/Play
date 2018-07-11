package com.interview;

import java.util.ArrayList;
import java.util.List;



public class GenerateParethese {

	private static String combinations="(";
	/**
	 * 生成匹配括号的所有种类
	 * @param n int
	 * @return List<String>
	 */
    public static List<String> generateParenthesis_1(int n) {
    	List<String> res=new ArrayList<String>();
    	generate(res, "", 0, 0, n);
        return res;
    }
    
    public static void generate(List<String>res, String cur, int left, int right, int max){
    	if(cur.length()==2*max){
    		res.add(cur);
    		return ;
    	}
    	if(left<max){
    		generate(res, cur+"(", left+1, right, max);
    	}
    	if(right<left){
    		generate(res, cur+")", left, right+1, max);
    	}
    }
    
    public static List<String> generateParenthesis_2(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		List<String>res=generateParenthesis_1(n);
		for(int i=0; i<res.size(); i++){
			System.out.println(res.get(i));
		}
		System.out.println(res.size());
	}

}
