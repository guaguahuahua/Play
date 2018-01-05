package com.interview;

/**
 * ͳ�Ƹ����������е��������
 * ����ʹ�õĹ鲢������㷨����֤ʱ�临�Ӷ�ΪO(logn)
 * @author 22847
 *
 */
public class CountTheReverseCouples {
	
	private static int count=0;
	/**
	 * һ�ζ�·�鲢����Ĺ���
	 * @param array
	 * @param begin
	 * @param mid
	 * @param end
	 */
	private static void mergeSort(int []array, int begin, int mid, int end){
		int l1=mid-begin+1; //�������ĳ���
		int l2=end-mid; //�Ҳ�����ĳ���
		int []L=new int[l1]; //����������������
		int []R=new int[l2];
		int i, j, k; //ָ��ֱ�ָ�������飬�����飬ԭ����
		//�����������
		for(i=0, k=begin; i<l1; i++, k++){
			L[i]=array[k];
		}
		for(j=0, k=mid+1; j<l2; j++, k++){
			R[j]=array[k];
		}

		//���ж�·�鲢�Ĺ��̣��鲢�Ĺ���Ҳ��Ҫ�ӹ鲢�εĳ�������ʼ����
		for(i=0, j=0, k=begin; i<l1 && j<l2; k++){
			//��֤��С�����˳������
			if(L[i]<R[j]){
				array[k]=L[i];
				i++;
			}else{
				int index=i;
				count += mid-(index+begin)+1; //�������⣬ԭ���ǲ�����ֱ��ʹ��i����Ϊ�鲢��ʱ����һ��һ�εĽ��У�����λ�ò����Ǵ�i=0��ʼ
				array[k]=R[j];
				j++;
			}
		}
		//��ʣ���Ԫ�ػ��ԭ������ȥ
		while(i<l1){
			array[k++]=L[i++];
		}
		while(j<l2){
			array[k++]=R[j++];
		}
	}
	
	
	/**
	 * ͳ������ĸ������������
	 * �ݹ�ķ�ʽ����
	 * @param array
	 * @param begin
	 * @param end
	 */
	private static void countTheReverseCouples(int []array, int begin, int end){
		//�ݹ�ĳ���
		if(begin<end){
			int mid=begin+(end-begin)/2; //������д��Ŀ����Ϊ�˷�ֹ����ֵ���
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
