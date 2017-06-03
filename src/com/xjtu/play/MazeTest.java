package com.xjtu.play;

import com.xjtu.structure.Maze;
import com.xjtu.structure.PointPos;

/**
 * ʵ���Թ��㷨��
 * @author 22847
 *
 */
public class MazeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�Թ��ĵ�ͼ������2��ʾ��ڣ�3��ʾ����
		int map[][]={   
	            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },  
	            { 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },  
	            { 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1 },  
	            { 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1 },  
	            { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },  
	            { 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },  
	            { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1 },  
	            { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1 },  
	            { 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1 },  
	            { 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 },  
	            { 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1 },  
	            { 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 },  
	            { 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },  
	            { 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 1 },  
	            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }  
	            };
		Maze maze=new Maze();
		PointPos []r=maze.findMarkedPos(map);
//		System.out.println("entrance:"+r[0].getX()+", "+r[0].getY()+";;"+" exit:"+r[1].getX()+", "+r[1].getY());
		int [][]m1=maze.DFstack(r, map);
		maze.markWay(r, m1);
	}

}
