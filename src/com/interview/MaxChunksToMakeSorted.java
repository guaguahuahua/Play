package com.interview;

import java.util.ArrayList;
import java.util.List;

public class MaxChunksToMakeSorted {

	/**
	 * ʹ������ĸ������ָ�����
	 * ����㷨��{1��2��0��3}��ס
	 * @param arr int[]
	 * @return int
	 */
    public static int maxChunksToSorted_1(int[] arr) {
    	//�����α�
    	int start=0, pointer=1;
    	//������
    	int count=0;
    	for(int i=0; i<arr.length; i++){
    		if(pointer<arr.length && arr[start]>arr[pointer]){
    			pointer+=1;
    		}else{
    			count+=1;
    			start=pointer;
    			pointer=start+1;
    		}
    	}
        return count;
    }
    
    /**
     * ʹ�ôӺ���ǰ��������ʽ�������Ļ����Ա���©��Ԫ��
     * @param arr int[]
     * @return int
     */
    public static int maxChunksToSorted_2(int []arr){
    	
    	int start=0, pointer=arr.length-1;
    	int count=0;
    	while(start<arr.length){
        	while(start<=pointer){
        		if(arr[start]<arr[pointer]){
        			pointer-=1;
        		}else{        			
        			//�ҵ������ڵ����ֵ������Ѱ����ֵ
        			List res=findMax(arr, start, pointer);
        			int lMax=(int) res.get(0);
        			int lIndex=(int) res.get(1);
        			//������ֵ�͵�ǰֵһ�£���ô��������Ѱ����ֵ,��һ����ô����Ѱ��
        			if(lMax==arr[start]){
            			start=pointer+1;
            			pointer=arr.length-1;
            			count+=1;
            			break;
        			}else{
        				start=lIndex;
        				pointer=arr.length-1;
        				continue;
        			}
        		}
        	}
    	}
    	return count;
    }
    
    /**
     * �ڸ������������ҵ������ڵ����ֵ
     * @param array int[]
     * @param begin int 
     * @param end int
     * @return List
     */
    public static List<Integer> findMax(int []array, int begin, int end){
    	int max=Integer.MIN_VALUE;
    	int index=-1;
    	for(int i=begin; i<=end; i++){
    		if(array[i]>max){
    			max=array[i];
    			index=i;
    		}
    	}
    	List<Integer> res=new ArrayList<Integer>();
    	res.add(max);
    	res.add(index);
    	return res;
    }
	
    /**
     * ʹ�ôӺ���ǰ��������ʽ�������Ļ����Ա���©��Ԫ��
     * @param arr int[]
     * @return int
     */
    public static int maxChunksToSorted(int []arr){
    	
    	int start=0, pointer=arr.length-1;
    	int count=0;
    	while(start<arr.length){
        	while(start<=pointer){
        		if(arr[start]<arr[pointer]){
        			pointer-=1;
        		}else{        			
        			//�����ǳ�����arr[start]>=arr[pointer]�����Σ���Ԫ�����ظ����������ǿ��Խ�����������ظ��������±�������ж�
        			//�����ж��ǲ���Ԫ�ط������ظ��ظ����������ж�ͨ���������������ԭ����ʽ����
        			if(start!=pointer && arr[start]==arr[pointer]){
        				pointer-=1;
        				continue;
        			}
        			//�ҵ������ڵ����ֵ������Ѱ����ֵ
        			List res=findMax(arr, start, pointer);
        			int lMax=(int) res.get(0);
        			int lIndex=(int) res.get(1);
        			//������ֵ�͵�ǰֵһ�£���ô��������Ѱ����ֵ,��һ����ô����Ѱ��
        			if(lMax==arr[start]){
            			start=pointer+1;
            			pointer=arr.length-1;
            			count+=1;
            			break;
        			}else{
        				start=lIndex;
        				pointer=arr.length-1;
        				continue;
        			}
        		}
        	}
    	}
    	return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []array={4, 3, 2, 1, 0};
//		int []array={1,0,2,3,4};
//		int []array={4,2,0,1,3};
//		int []array={1,2,0,3};
//		int []array={1,4,0,2,3,5};
//		int []array={2,1,3,4,4};
		int res=maxChunksToSorted_2(array);
		System.out.println(res);
	}

}
