package com.xjtu.play;

import com.xjtu.structure.SeqNode;
import com.xjtu.structure.SeqPNode;

/**
 * ����˳�����ȼ�����
 * @author 22847
 *
 */
public class MySeqPQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeqPNode pqueue=new SeqPNode();
		SeqNode node =new SeqNode(22,3);
		SeqNode node1 =new SeqNode(33,2);
		SeqNode node2 =new SeqNode(44,1);
		//����isEmpty����
		boolean r=pqueue.isEmpty(pqueue);
		System.out.println(r);
		//������ӷ���
		pqueue.append(pqueue, node1);
		pqueue.append(pqueue, node);
		pqueue.append(pqueue,node2);
		boolean r2=pqueue.isEmpty(pqueue);
		System.out.println(r2);
		System.out.println("��ǰ���еĳ���Ϊ��"+pqueue.getSize(pqueue));
		//���Գ��ӷ���,ȡ������ȼ�����
		SeqNode r1=pqueue.getHPrior(pqueue);
		System.out.println("���ȼ���ߵĽڵ�"+", ���ȼ���"+r1.getPrior()+"�� ֵΪ��"+r1.getValue());
		SeqNode r5=pqueue.delete(pqueue);
		System.out.println("ɾ���ڵ㣺"+r5.getValue()+", "+r5.getPrior());
		int r4=pqueue.getSize(pqueue);
		System.out.println("��ǰ���еĳ���Ϊ��"+r4);
		SeqNode r3=pqueue.getHPrior(pqueue);
		System.out.println("���ȼ���ߵĽڵ�"+", ���ȼ���"+r3.getPrior()+"�� ֵΪ��"+r3.getValue());
	}

}
