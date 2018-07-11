package com.interview;

import java.util.ArrayList;
import java.util.List;

public class GenerateParathese_1 {

	/**
	 * 按照给定的数目，输出括号的所有满足闭合匹配条件的组合
	 * @param n	int
	 * @return List<String>
	 */
    public static List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<String>();
        String current="";
    	parethesis(0, 0, n, result, current);
    	return result;
    }
    
    public static void parethesis(int left, int right, int max, List<String> result, String current){
		if(current.length()==2*max){
			result.add(current);
			current="";
			return;
		}
		
    	if(left<max){
    		//这块的current是同样的道理，如果直接在当前的变量上修改，回溯的时候就会出现问题
//    		current+="(";
    		//这块不能使用++的方式完成增加，是因为在回溯的时候++操作会彻底改变值，导致回溯的时候值不会发生变化
//    		left++;	
    		parethesis(left+1, right, max, result, current+"(");
    	}
    	if(right<left){
//    		current+=")";
//    		right++;
    		parethesis(left, right+1, max, result, current+")");
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		ArrayList res=(ArrayList) generateParenthesis(n);
		for(int i=0; i<res.size(); i++){
			System.out.println(res.get(i));
		}
	}

}
