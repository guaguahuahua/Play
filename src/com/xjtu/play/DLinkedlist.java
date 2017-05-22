package com.xjtu.play;

/**
 * ���˫��ѭ���������룬ɾ������
 * @author 22847
 *
 */
public class DLinkedlist {

	class Dnode{
		int value;
		Dnode pre;
		Dnode post;
		
		public Dnode(int value){
			this.value=value;
			this.pre=null;
			this.post=null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�������̵Ĳ���
		DLinkedlist dl=new DLinkedlist();
		Dnode head=dl.new Dnode(0);
		boolean r=dl.insert(head, 0, 23);
		System.out.println(r);
		
	}
	/**
	 * ˫��ѭ������Ĳ�������
	 * @param head
	 * @param position
	 * @param value
	 * @return
	 */
	public boolean insert(Dnode head,int position,int value){
		if(position<0){
			System.out.println("λ��Խ��");
			return false;
		}
		int count=0;
		Dnode point=head.post;//��ָ���쳣��ԭ������飬��Ҫ����Ϊhead����һ��λ���ǿյģ����Ե���
		while(point!=head && count<position){//Ѱ�Ҳ����λ��
			point=point.post;
			count++;
		}
		if(count!=position){
			System.out.println("λ��Խ��");
			return false;
		}
		Dnode node=new Dnode(value);
		node.post=point.post;
		point.post.pre=node;
		node.pre=point;
		point.post=node;
		return true;
	}

}
