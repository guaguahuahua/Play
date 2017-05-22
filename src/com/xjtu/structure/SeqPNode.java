package com.xjtu.structure;

/**
 * ˳�����ȼ�����
 * ����˳�����ȶ���ÿ�γ���֮�󶼻Ὣ�����ȼ������Ԫ��ȫ�����ε�ǰ�ƣ����Բ�����ּ����������Ϊÿ��������ǰ�ƶ�һ��Ԫ��
 * @author 22847
 */
public class SeqPNode {
	private static int N=10;
	
	SeqNode []array=new SeqNode[N];
//	int front;//֮���Բ�ʹ��ͷָ���βָ���ԭ����ͷָ��ɾ��Ԫ�ص�ʱ���ǰ������ȼ����еĲ��ǰ���ԭ���ĴӶ���ͷ��ʼ��
//	int rear;//��ʹ��βָ�룬����Ϊÿ�ο��Ը��ݶ��еĴ�С������λ�ò���Ԫ�ؼ���
	int size;
	
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @param pqueue
	 * @return
	 */
	public static boolean isEmpty(SeqPNode pqueue){
		if(pqueue.size==0){
			System.out.println("����Ϊ��");
			return true;
		}
		System.out.println("���зǿ�");
		return false;
	}
	/**
	 * ˳�����ȼ��������
	 * @param pqueue ���нṹ
	 * @param node ��ӵ�Ԫ�أ����а�����ֵ�����ȼ�2����
	 * @return
	 */
	public static boolean append(SeqPNode pqueue,SeqNode node){
		if(pqueue.size==N){
			System.out.println("��������");
			return false;
		}
		int index=pqueue.size;//�ҵ��������Ĳ����
		pqueue.array[index]=node;
		pqueue.size++;//���еĳ�������
		return true;
	}
	/**
	 * ˳�����ȶ��г��ӣ�������ȼ��Ķ���������������ԽС�����ȼ�Խ��
	 * @param pqueue
	 * @return
	 */
	public static SeqNode delete(SeqPNode pqueue){
		int i;
		int index=0;
		int prior=pqueue.array[0].prior;//�ٶ���һ��Ԫ�ص����ȼ�����ߵ�
		for(i=0;i<pqueue.size;i++){
			if(pqueue.array[i].prior<prior){//Ѱ�Ҹ����ȼ�
				prior=pqueue.array[i].prior;
				index=i;
			}
		}
//		System.out.println(pqueue.array[index].prior+", "+pqueue.array[index].value);
		SeqNode tmp=pqueue.array[index];
//		pqueue.array[index].prior=Integer.MAX_VALUE;
//		pqueue.array[index].value=0;
		//Ѱ�ҵ������ȼ���ߵ�Ԫ�أ�������ӣ����ҽ������Ԫ����ǰ�ƶ����λ
		for(int j=index+1;j<pqueue.size;j++){
			pqueue.array[j-1]=pqueue.array[j];
		}
		pqueue.size--;//����֮�󽫶��еĳ��ȼ�С
		return tmp;//���ҵ������ȼ���ߵ�Ԫ�س��ӣ�����
	}
	/**
	 * ȡ�ö��������ȼ���ߵ�Ԫ��
	 * @param pqueue
	 * @return
	 */
	public static SeqNode getHPrior(SeqPNode pqueue){
		int prior=pqueue.array[0].prior;
		int index=0;
		for(int i=0;i<pqueue.size;i++){
			if(pqueue.array[i].prior<prior){
				prior=pqueue.array[i].prior;
				index=i;
			}
		}
		return pqueue.array[index];
	}
	public static int getSize(SeqPNode pqueue){
		return pqueue.size;
	}
}
