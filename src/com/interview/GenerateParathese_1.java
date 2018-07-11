package com.interview;

import java.util.ArrayList;
import java.util.List;

public class GenerateParathese_1 {

	/**
	 * ���ո�������Ŀ��������ŵ���������պ�ƥ�����������
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
    		//����current��ͬ���ĵ������ֱ���ڵ�ǰ�ı������޸ģ����ݵ�ʱ��ͻ��������
//    		current+="(";
    		//��鲻��ʹ��++�ķ�ʽ������ӣ�����Ϊ�ڻ��ݵ�ʱ��++�����᳹�׸ı�ֵ�����»��ݵ�ʱ��ֵ���ᷢ���仯
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
