package com.interview;

import java.util.ArrayList;
import java.util.List;

public class MaxChunksToMakeSorted {

	/**
	 * 使用逆序的个数来分割数组
	 * 这个算法被{1，2，0，3}卡住
	 * @param arr int[]
	 * @return int
	 */
    public static int maxChunksToSorted_1(int[] arr) {
    	//两个游标
    	int start=0, pointer=1;
    	//计数器
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
     * 使用从后向前的搜索方式，这样的话可以避免漏掉元素
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
        			//找到区间内的最大值，重新寻找右值
        			List res=findMax(arr, start, pointer);
        			int lMax=(int) res.get(0);
        			int lIndex=(int) res.get(1);
        			//如果最大值和当前值一致，那么不用重新寻找右值,不一致那么重新寻找
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
     * 在给定的区间内找到区间内的最大值
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
     * 使用从后向前的搜索方式，这样的话可以避免漏掉元素
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
        			//这里是出现了arr[start]>=arr[pointer]的情形，在元素无重复的情形下是可以解决，但是有重复的情形下必须进行判断
        			//现在判断是不是元素发生了重复重复的情形走判断通道，否则继续按照原来方式处理
        			if(start!=pointer && arr[start]==arr[pointer]){
        				pointer-=1;
        				continue;
        			}
        			//找到区间内的最大值，重新寻找右值
        			List res=findMax(arr, start, pointer);
        			int lMax=(int) res.get(0);
        			int lIndex=(int) res.get(1);
        			//如果最大值和当前值一致，那么不用重新寻找右值,不一致那么重新寻找
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
