package com.interview;

/**
 * 统计给定的数组中的逆序对数
 * 这里使用的归并排序的算法，保证时间复杂度为O(logn)
 * @author 22847
 *
 */
public class CountTheReverseCouples {
	
	private static int count=0;
	/**
	 * 一次二路归并排序的过程
	 * @param array
	 * @param begin
	 * @param mid
	 * @param end
	 */
	private static void mergeSort(int []array, int begin, int mid, int end){
		int l1=mid-begin+1; //左侧数组的长度
		int l2=end-mid; //右侧属组的长度
		int []L=new int[l1]; //定义左右两个数组
		int []R=new int[l2];
		int i, j, k; //指针分别指向左数组，右数组，原数组
		//填充左右数组
		for(i=0, k=begin; i<l1; i++, k++){
			L[i]=array[k];
		}
		for(j=0, k=mid+1; j<l2; j++, k++){
			R[j]=array[k];
		}

		//进行二路归并的过程，归并的过程也是要从归并段的初索引开始进行
		for(i=0, j=0, k=begin; i<l1 && j<l2; k++){
			//保证从小到大的顺序排列
			if(L[i]<R[j]){
				array[k]=L[i];
				i++;
			}else{
				int index=i;
				count += mid-(index+begin)+1; //问题在这，原因是不可以直接使用i，因为归并的时候是一段一段的进行，索引位置不总是从i=0开始
				array[k]=R[j];
				j++;
			}
		}
		//将剩余的元素回填到原数组中去
		while(i<l1){
			array[k++]=L[i++];
		}
		while(j<l2){
			array[k++]=R[j++];
		}
	}
	
	
	/**
	 * 统计逆序的个数，方法入口
	 * 递归的方式调用
	 * @param array
	 * @param begin
	 * @param end
	 */
	private static void countTheReverseCouples(int []array, int begin, int end){
		//递归的出口
		if(begin<end){
			int mid=begin+(end-begin)/2; //这样书写的目的是为了防止过大值溢出
			countTheReverseCouples(array, begin, mid);
			countTheReverseCouples(array, mid+1, end);
			mergeSort(array, begin, mid, end);
		}		
	}
	
	public static void main(String []args){
		int []array={1,5,3,6,2}; //1, 5, 3, 6, 2
		CountTheReverseCouples.countTheReverseCouples(array, 0, array.length-1);
		
		for(int K:array){
			System.out.print(K+"\t");			
		}
		System.out.println();
		System.out.println(count);
	}

}
