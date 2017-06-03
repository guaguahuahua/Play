package com.xjtu.play;

import com.xjtu.structure.Maze;
import com.xjtu.structure.PointPos;

/**
 * 实现迷宫算法，
 * @author 22847
 *
 */
public class MazeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//迷宫的地图，其中2表示入口，3表示出口
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
