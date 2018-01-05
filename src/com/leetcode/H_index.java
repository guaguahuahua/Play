package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H_index {

	/**
	 * Ѱ��һ���������������������鳤�ȼ�ȥ��������������ǰ�����ĸ���������������ĸ������������
	 * @param citations
	 * @return
	 */
    public static int hIndex1(int[] citations) {
    	if(citations.length==0){
    		return 0;
    	}
//    	if(citations.length==1 && citations[0]!=1){
//    		return 0;
//    	}
    	Arrays.sort(citations);
    	List<Integer> result=new ArrayList<Integer>();
    	int len=citations.length;
    	boolean flag=false;
    	for(int i=0;i<citations.length;i++){
    		if(len-citations[i]==i && citations[i]==len-i){
    			System.out.println(citations[i]);
    			result.add(citations[i]);
    			flag=true;
    		}
    	}
    	if(flag){
    		return result.get(result.size()-1);
    	}else{
    		return 0;
    	}
    }
    /**
     * h-index�Ĺٷ������ǣ�������nƪ���ı����õĴ����ֱ���n�Σ�
     * ���Բ��õķ����Ǵӽ���������֮�󣬴ӽϴ�ֵ���£�ֱ��ĳ��������
     * С���±�ֵ���±��1��ʼ�ģ�����ʱ �±�i-1��λ�õ��������������ҵ�h-index
     * @param citations
     * @return
     */
    public static int hIndex(int[] citations) {
    	Arrays.sort(citations);
    	int index=1;
    	int i=citations.length-1;
    	while(i>=0){//�Ӹߵ��͵�Ѱ����������±�
    		if(citations[i]<index){
    			return index-1;
    		}
    		i--;
    		index++;
    	}
    	return index-1; //��һ����Ϊ��whileѭ���л�����1
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []citations={3,0,6,1,5};
//		int []citations={0};//0
//		int []citations={0,0};//0
//		int []citations={100};//1
//		int []citations={100,110,12};//3
		int []citations={};//0
		
		int r=hIndex(citations);
		System.out.println(r);
	}
}
