package com.xjtu.structure;

/**
 * 顺序优先级队列
 * 由于顺序优先队列每次出队之后都会将高优先级后面的元素全部依次的前移，所以不会出现假溢出现象，因为每次至少向前移动一个元素
 * @author 22847
 */
public class SeqPNode {
	private static int N=10;
	
	SeqNode []array=new SeqNode[N];
//	int front;//之所以不使用头指针和尾指针的原因是头指针删除元素的时候是按照优先级进行的不是按照原来的从队列头开始的
//	int rear;//不使用尾指针，是因为每次可以根据队列的大小在最后的位置插入元素即可
	int size;
	
	/**
	 * 判断队列是否为空
	 * @param pqueue
	 * @return
	 */
	public static boolean isEmpty(SeqPNode pqueue){
		if(pqueue.size==0){
			System.out.println("队列为空");
			return true;
		}
		System.out.println("队列非空");
		return false;
	}
	/**
	 * 顺序优先级队列入队
	 * @param pqueue 队列结构
	 * @param node 入队的元素，其中包括了值和优先级2部分
	 * @return
	 */
	public static boolean append(SeqPNode pqueue,SeqNode node){
		if(pqueue.size==N){
			System.out.println("队列已满");
			return false;
		}
		int index=pqueue.size;//找到队列最后的插入点
		pqueue.array[index]=node;
		pqueue.size++;//队列的长度增加
		return true;
	}
	/**
	 * 顺序优先队列出队，这块优先级的定义是整数，整数越小，优先级越高
	 * @param pqueue
	 * @return
	 */
	public static SeqNode delete(SeqPNode pqueue){
		int i;
		int index=0;
		int prior=pqueue.array[0].prior;//假定第一个元素的优先级是最高的
		for(i=0;i<pqueue.size;i++){
			if(pqueue.array[i].prior<prior){//寻找高优先级
				prior=pqueue.array[i].prior;
				index=i;
			}
		}
//		System.out.println(pqueue.array[index].prior+", "+pqueue.array[index].value);
		SeqNode tmp=pqueue.array[index];
//		pqueue.array[index].prior=Integer.MAX_VALUE;
//		pqueue.array[index].value=0;
		//寻找到了优先级最高的元素，将其出队，并且将后面的元素向前移动填补空位
		for(int j=index+1;j<pqueue.size;j++){
			pqueue.array[j-1]=pqueue.array[j];
		}
		pqueue.size--;//出队之后将队列的长度减小
		return tmp;//将找到的优先级最高的元素出队，返回
	}
	/**
	 * 取得队列中优先级最高的元素
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
