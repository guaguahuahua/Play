package com.interview;

public class MinGapOfThreeElements {

	/**
	 * 求解三元组的最小距离，距离的定义为：max{abs(Ai-Bi), abs(Ai-Ci), abs(Bi-Ci)}
	 * @param a
	 * @param b
	 * @param c
	 * @return int
	 */
	private static int minGapOfThreeElements(int []a, int []b, int []c){
		//用来存放最小距离
		int dis=Integer.MAX_VALUE; 
		for(int ai=0; ai<a.length; ai++){
			for(int bi=0; bi<b.length; bi++){
				for(int ci=0; ci<c.length; ci++){
					int temp=Math.max(Math.max(Math.abs(a[ai]-b[bi]), Math.abs(a[ai]-c[ci])), Math.abs(b[bi]-c[ci]));
					if(temp<dis){
						dis=temp;
					}
				}
			}
		}
		return dis;
	}
	
	
	/**
	 * 求三个数组之间的最小差距
	 * @param a
	 * @param b
	 * @param c
	 * @return int 最小的距离
	 */
	private static int minGapOfThreeElements_1(int []a, int []b, int []c){
		int i=0, j=0, k=0;
		//存放最小距离值
		int minDis=Integer.MAX_VALUE;
		
		while(true){
			//存放当前距离的值
			int curDis=max(Math.abs(a[i]-b[j]), Math.abs(a[i]-c[k]), Math.abs(b[j]-c[k]));
			//如果当前的距离值更小，那么更新最小距离值
			if(curDis<minDis){
				minDis=curDis;
			}
			int tmp=min(a[i], b[j], c[k]);
			if(tmp==a[i]){
				i++;
				if(i>=a.length){
					break;
				}
			}else if(tmp==b[j]){
				j++;
				if(j>=b.length){
					break;
				}
			}else if(tmp==c[k]){
				k++;
				if(k>=c.length){
					break;
				}
			}
		}
		return minDis;
	}
	
	/**
	 * 求三个数中的最小值
	 * @param a
	 * @param b
	 * @param c
	 * @return int
	 */
	private static int min(int a, int b, int c){
		int temp=Math.min(a, b);
		return Math.min(temp, c);
	}
	
	/**
	 * 求三个数中的最大值
	 * @param a
	 * @param b
	 * @param c
	 * @return int
	 */
	private static int max(int a, int b, int c){
		int temp=Math.max(a, b);
		return Math.max(temp, c);
	}
	
	public static void main(String []args){
		int []a={3, 4, 5, 7};
		int []b={10, 12, 14, 16, 17};
		int []c={20, 21, 23, 24, 37, 30};
		int distance=MinGapOfThreeElements.minGapOfThreeElements_1(a, b, c);
		System.out.println(distance);
	}
}
