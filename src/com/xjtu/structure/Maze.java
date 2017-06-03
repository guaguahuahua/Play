package com.xjtu.structure;

import java.util.Stack;

public class Maze {

	/**
	 * Ѱ����ںͳ���
	 * @param map
	 * @return
	 */
	public static PointPos[] findMarkedPos(int [][]map){
		PointPos exit = new PointPos();
		PointPos entrance = new PointPos();
		boolean f1=true,f2=true;
		for(int row=0;row<map.length;row++){
			for(int col=0;col<map[row].length;col++){
				if(map[row][col]==2 && f1){//�������ڣ���ô���
					entrance.x=row;
					entrance.y=col;
					f1=false;
				}else if(map[row][col]==3 && f2){//����ǳ��ڣ����
					exit.x=row;
					exit.y=col;
					f2=false;
				}
				if(!f1 && !f2){//����ҵ�����ںͳ���
					return new PointPos[]{entrance,exit};
				}
			}
		}
		return null;//û�ҵ�������null
	}
	/**
	 * ������ںͳ��ڲ����Լ��Թ���ͼ
	 * @param pos ���������������������ںͳ��ڣ�����ǵ�һ��������ʱ�ڶ���
	 * @param map
	 */
	public static int[][] DFstack(PointPos []pos,int [][]map){
		//�����洢�����Ŀ���ͨ�еĽڵ�
		Stack <PointPos>stack=new Stack<PointPos>();
		PointPos pointtmp;
//		PointPos pointPos=new PointPos();//�����������Ϊȫ�ֱ�����������ջ��ʱ������ýڵ��ж��·�ڣ���ô�����·����Ϣ�����ǰ���·����Ϣ
		//������һ����ջԪ�ؽ��޸����е�ջ��Ԫ����Ϣ��
		int flag=4;//��Ҫ��������Ǳ�������Ԫ��
		stack.push(pos[0]);//�����Ԫ�ط����ջ֮��
		
		while(!stack.isEmpty()){//����ջ��Ϊ��ʱѭ��ִ��
			pointtmp=stack.peek();
			stack.pop();//��ջ��Ԫ�س�ջ���ж�
			System.out.println("ջ����Ϊ��"+stack.size());
			int row=pointtmp.x;
			int col=pointtmp.y;
			System.out.println("��ջ����Ϊ��"+pointtmp.x+", "+pointtmp.y);
			int count=0;
			//�����Ҫ�ǽ���ջ��Ԫ�أ�Ҳ�����Ѿ���������Ԫ�ؽ��б�ǣ�������ֵΪflag,���Ա����ظ��ж��Ƿ�����������ƵȵȵĲ���
			if(map[row][col]==0){
				map[row][col]=flag;
			}
			//�ж��Ƿ��������ƶ�
			if(row<map.length-1 && row>=1){
				//�ж��Ƿ��������
				if(map[row-1][col]==0){//����������ƣ���ô��ӵ���ջ��
					PointPos pointPos=new PointPos();
					pointPos.x=row-1;
					pointPos.y=col;
					System.out.println("��ջ����Ϊ��"+pointPos.x+", "+pointPos.y);
					stack.push(pointPos);
					++count;
				}else if(map[row-1][col]==3){//�����Ҫ��3������Ϊ���ڵ�ֵ
					break;
				}
				//�ж��Ƿ��������
				if(map[row+1][col]==0){
					PointPos pointPos=new PointPos();
					pointPos.x=row+1;
					pointPos.y=col;
					System.out.println("��ջ����Ϊ��"+pointPos.x+", "+pointPos.y);
					stack.push(pointPos);
					++count;
				}else if(map[row+1][col]==3){//����ǵ��˳��ڣ���ôֱ�ӽ���ѭ��
					break;
				}
			}
			//�ж��Ƿ���Խ��������ƶ�
			if(col>=1 && col<map[0].length-1){//��Ϊ�Թ��ǹ���ľ��Σ����Կ���ֱ��ʹ�õ�һ�е���������������е�����
				//������
				if(map[row][col-1]==0){
					PointPos pointPos=new PointPos();
					pointPos.x=row;
					pointPos.y=col-1;
					System.out.println("��ջ����Ϊ��"+pointPos.x+", "+pointPos.y);
					stack.push(pointPos);
					++count;
				}else if(map[row][col-1]==3){
					break;
				}
				//������
				if(map[row][col+1]==0){
					PointPos pointPos=new PointPos();
					pointPos.x=row;
					pointPos.y=col+1;
					System.out.println("��ջ����Ϊ��"+pointPos.x+", "+pointPos.y);
					stack.push(pointPos);
					++count;
				}else if(map[row][col+1]==3){
					break;
				}
			}
			if(count>1){
				++flag;
			}
		}
		System.out.print("Ѱ�����к��ʵ�·����"+"\n");
		show(map);
		return map;
	}
	/**
	 * ��������������������Թ����
	 * @param map
	 */
	public static void show(int [][]map){
		for(int row=0;row<map.length;row++){
			for(int col=0;col<map[row].length;col++){
				
				System.out.print(map[row][col]+"\t");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	/**
	 * ��������֮���Թ��е�·�������������ұ�ǹ��ˣ�����Ҫ���ľ�������Щ��ǹ���·�����ҵ�����ͨ����ڵ�·��
	 * �����Ƚϼ򵥣�ԭ�����ڿ�ʼ�������п���·����ʱ��·������Ķ�����ǹ�������Խ�����·������ǵ�����ֵԽ��
	 * ���ֻҪ����ڿ�ʼÿ��Ѱ�ҽϴ��ֵ�ķ������Ѱ�Ҽ����ҵ�����
	 * @param r ��ڣ����ڵ�λ��
	 * @param map �Թ��ĵ�ͼ
	 */
	public static void markWay(PointPos []r,int [][]map){
		int px,py,nx = 0,ny = 0;
		px=r[0].x;//����ʼ�ڵ���������
		py=r[0].y;
		int max=map[px][py];//�ٶ���ڽڵ��ֵ������,�ڵ����ֵ�� 2
		
		//Ѱ��ͨ����ڵ�·���������������ĸ��������εģ�Ѱ�ҵ�����ֵ
		while(map[px][py]!=3){
			//�ж��Ƿ���������ƶ�
			if(px>0 && px<map.length-1){//Ҳ��˵����������������ǽ�ڵģ���ν��ǽ�������Թ��ı߽磬��Ϊ������˵�
				//�ж�����Ľڵ��Ƿ�Ϊ·����һ����
				if(map[px+1][py]>max){
					nx=px+1;
					ny=py;
					max=map[nx][ny];
				}else if(map[px+1][py]==3){
					break;
				}
				//�ж�����Ľڵ��Ƿ�Ϊ·����һ����
				if(map[px-1][py]>max){
					nx=px-1;
					ny=py;
					max=map[nx][ny];
				}else if(map[px-1][py]==3){
					break;
				}
			}
			//�ж������Ƿ���·����һ����
			if(py>0 && py<map[0].length-1){
				//�ж�����Ƿ�Ϊ·��
				if(map[px][py-1]>max){
					nx=px;
					ny=py-1;
					max=map[nx][ny];
				}else if(map[px][py-1]==3){
					break;
				}
				//�ж��ұ��Ƿ�Ϊ·��
				if(map[px][py+1]>max){
					nx=px;
					ny=py+1;
					max=map[nx][ny];
				}else if(map[px][py+1]==3){
					break;
				}
			}
			map[nx][ny]=-1;//������ͨ����ڵ�·�����Ϊ-1
			max=3;
			px=nx;//�Ե�ǰ�ڵ�Ϊ��ʼ�ٴα���
			py=ny;
		}
		System.out.print("·����-1�����"+"\n");
		show(map);
	}
	
}
