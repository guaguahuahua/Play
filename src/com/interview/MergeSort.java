package com.interview;

/**
 * 二路归并算法的实现
 * 基于分治思想
 * @author 22847
 */
public class MergeSort {
	
	private static int count=0;	
	/**
	 * 一次归并排序的过程
	 * @param array
	 * @param start
	 * @param mid
	 * @param end
	 */
	private static void mergeSort(int []array, int start, int mid, int end){
		int i,j,k;
		//合并段的长度
		int len1=mid-start+1;
		int len2=end-mid;
		int []left=new int[len1];
		int []right=new int[len2];
		//将需要归并的代码段单独存放起来
		for(i=start, k=0; i<start+len1; i++, k++){
			left[k]=array[i];
		}
		for(j=mid+1, k=0; j<mid+1+len2; j++, k++){
			right[k]=array[j];
		}
		//从小到大的将元素放置到原数组array中去
		for(i=0, j=0, k=start; i<len1 && j<len2; ){
			if(left[i]<=right[j]){
				array[k]=left[i];
				i++;
				k++;
			}else{
				array[k]=right[j];
				j++;
				k++;
				count+=mid-i+1;
			}
		}
		//将两个缓存数组中没有清空的元素全部输出到arary数组中
		while(i<len1){
			array[k++]=left[i++];
		}
		while(j<len2){
			array[k++]=right[j++];
		}		
	}

	/**
	 * 递归排序
	 * @param array
	 * @param start
	 * @param end
	 */
	private static void merge(int []array, int start, int end){
		if(start<end){
			int mid=start+(end-start)/2;
			merge(array, 0, mid);
			merge(array, mid+1, end);
			mergeSort(array, 0, mid, end);
		}
//		int mid=start+(end-start)/2;
//		mergeSort(array, 0, mid, end);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []array={1, 5, 3, 2, 6};
//		int []array={1, 3, 5, 2, 6};
		int []array={5,4,3,2,1};
		for(int K:array){
			System.out.print(K+"\t");		
		}
		System.out.println();
		System.out.println("after sorting");
		merge(array, 0, array.length-1);
		for(int K:array){
			System.out.print(K+"\t");		
		}
		System.out.println();
		System.out.println("逆序数："+count);
	}

}
