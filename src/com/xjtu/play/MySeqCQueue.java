package com.xjtu.play;

import com.xjtu.structure.SeqCQueue;

public class MySeqCQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeqCQueue queue=new SeqCQueue();
		//����isEmpty����
		boolean r=queue.isEmpty(queue);
		System.out.println(r);
		//�������
		queue.append(queue, 2);
		queue.append(queue, 3);
		queue.append(queue, 5);
		System.out.println(queue.getSize(queue));
		//���Գ���
		queue.delete(queue);
		System.out.println("��ǰ��ͷԪ��Ϊ��"+queue.getFront(queue));
		System.out.println("��ǰ���г���Ϊ��"+queue.getSize(queue));
		//����ȡ��ͷԪ��
		queue.delete(queue);
		System.out.println("��ͷԪ��Ϊ��"+queue.getFront(queue));
	}
}
