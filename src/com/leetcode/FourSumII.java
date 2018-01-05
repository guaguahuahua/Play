package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourSumII {

	/**
	 * �ڸ������ĸ������У���ÿ�������и�ȡһ��Ԫ�أ�ʹ�����ǵĺ�Ϊ0��
	 *����������ϵĸ��� 
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return �������п��ܵĸ���
	 * ˼·������forѭ����ɣ����TLE�Ļ����ٸĽ��㷨
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
     * ǰ�������������ͣ�����ڵ��ĸ������н��ж��ַ�����
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
        			if(binSearch(D,-tmp)){//������ڣ���ô��������һ
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
     * ������㷨���ǲ��У���Ϊ�Ǻ�������ͬԪ�ص����Σ�����ͳ�Ƹ�������
     * ������㷨������������Ҫ�ǽ�4��ѭ�������˷ֽ⣬�ǳ��ĸ�Ч����Ϊ�����Ϊ0
     * ����ֻҪ����2�����2��ѭ���ֿ���ͬʱʹ����map���ظ��ĺ͵Ĵ���ͳ�ƺ������value����
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    	
    	Map<Integer,Integer>ma=new HashMap<Integer,Integer>();
    	int result=0;
    	for(int f=0;f<A.length;f++){//�����ǰ����������Ԫ�صĺͣ�������ͬ�ĺ����������ۼ�
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
		System.out.println("���������ĸ�����"+result);
		//���Զ��ַ�����
/*		int []test={1,2,5,7,8};
		int tmp=7;
		boolean re=binSearch(test,tmp);
		System.out.println(re);*/		
	}

}
