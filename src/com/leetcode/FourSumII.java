package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourSumII {

	/**
	 * 在给定的四个数组中，从每个数组中各取一个元素，使得它们的和为0，
	 *求这样的组合的个数 
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return 返回所有可能的个数
	 * 思路：四重for循环完成，如果TLE的话，再改进算法
	 */
    public static int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        int result=0;
    	for(int f=0;f<A.length;f++){
        	for(int s=0;s<B.length;s++){
        		for(int t=0;t<C.length;t++){
        			for(int fo=0;fo<D.length;fo++){
        				if(A[f]+B[s]+C[t]+D[fo]==0){
        					result++;
        				}
        			}
        		}
        	}
        }
    	return result;
    }
    /**
     * 前三个数组进行求和，最后在第四个数组中进行二分法查找
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public static int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
    	Arrays.sort(D);
    	int result=0;
    	for(int f=0;f<A.length;f++){
        	for(int s=0;s<B.length;s++){
        		for(int t=0;t<C.length;t++){
        			int tmp=A[f]+B[s]+C[t];
        			if(binSearch(D,-tmp)){//如果存在，那么计数器加一
        				result++;
        			}
        		}
        	}
    	}
    	return result;
    }
    
    public static boolean binSearch(int []D,int tmp){
    	int left=0,right=D.length-1;
    	int mid=left+(right-left)/2;
    	while(left<=right){
    		if(D[mid]==tmp){
    			return true;
    		}else if(D[mid]<tmp){
    			left=mid+1;
    		}else if(D[mid]>tmp){
    			right=mid-1;
    		}
    		mid=left+(right-left)/2;
    	}
    	return false;
    }
    /**
     * 上面的算法还是不行，因为是忽略了相同元素的情形，导致统计个数减少
     * 下面的算法来自社区，主要是将4重循环进行了分解，非常的高效，因为是求和为0
     * 所以只要将外2层和内2层循环分开，同时使用了map将重复的和的次数统计后放置在value里面
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    	
    	Map<Integer,Integer>ma=new HashMap<Integer,Integer>();
    	int result=0;
    	for(int f=0;f<A.length;f++){//先求解前两个数组中元素的和，并对相同的和数量进行累加
        	for(int s=0;s<B.length;s++){
        		int sum=A[f]+B[s];
        		ma.put(sum,ma.getOrDefault(sum, 0)+1);
        	}
    	}
    	for(int t=0;t<C.length;t++){
    		for(int fo=0;fo<D.length;fo++){
    			int s=C[t]+D[fo];
    			result+=ma.get(-s)==null ? 0:ma.get(-s);
    		}
    	}
    	return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []A={1,2};
		int []B={-2,-1};
		int []C={-1,2};
		int []D={0,2};
		int result=fourSumCount(A,B,C,D);
		System.out.println("满足条件的个数："+result);
		//测试二分法查找
/*		int []test={1,2,5,7,8};
		int tmp=7;
		boolean re=binSearch(test,tmp);
		System.out.println(re);*/		
	}

}
