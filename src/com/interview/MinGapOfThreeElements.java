package com.interview;

public class MinGapOfThreeElements {

	/**
	 * �����Ԫ�����С���룬����Ķ���Ϊ��max{abs(Ai-Bi), abs(Ai-Ci), abs(Bi-Ci)}
	 * @param a
	 * @param b
	 * @param c
	 * @return int
	 */
	private static int minGapOfThreeElements(int []a, int []b, int []c){
		//���������С����
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
	 * ����������֮�����С���
	 * @param a
	 * @param b
	 * @param c
	 * @return int ��С�ľ���
	 */
	private static int minGapOfThreeElements_1(int []a, int []b, int []c){
		int i=0, j=0, k=0;
		//�����С����ֵ
		int minDis=Integer.MAX_VALUE;
		
		while(true){
			//��ŵ�ǰ�����ֵ
			int curDis=max(Math.abs(a[i]-b[j]), Math.abs(a[i]-c[k]), Math.abs(b[j]-c[k]));
			//�����ǰ�ľ���ֵ��С����ô������С����ֵ
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
	 * ���������е���Сֵ
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
	 * ���������е����ֵ
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
