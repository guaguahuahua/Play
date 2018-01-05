package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H_index {

	/**
	 * 寻找一个数，在数组中满足数组长度减去这个数等于这个数前面数的个数，数组后面数的个数等于这个数
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
     * h-index的官方解释是，至少有n篇论文被引用的次数分别是n次，
     * 所以采用的方法是从将论文排序之后，从较大值向下，直到某个引用量
     * 小于下标值（下标从1开始的），这时 下标i-1个位置的引用量就是所找的h-index
     * @param citations
     * @return
     */
    public static int hIndex(int[] citations) {
    	Arrays.sort(citations);
    	int index=1;
    	int i=citations.length-1;
    	while(i>=0){//从高到低的寻找这个索引下标
    		if(citations[i]<index){
    			return index-1;
    		}
    		i--;
    		index++;
    	}
    	return index-1; //减一是因为在while循环中会多加上1
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
