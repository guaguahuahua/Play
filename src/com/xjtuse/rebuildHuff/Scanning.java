package com.xjtuse.rebuildHuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 主要是扫描外部的文件，对构成的元素进行计数，作为huffman树构建的权值依据
 * @author 22847
 *
 */
public class Scanning {
	/**
	 * 根据传进来的文件的路径，进行文件的扫描统计过程
	 * @param filePath 文件的路径
	 * return 返回对文件中字符的统计结果
	 */
	public static int[] scanning(String filePath){
		int []hash=new int [128];//结果存放数组，因为英文字符处于0--127之间，可以使用ASCII码对应的整数作为索引直接存储
		File file=new File(filePath);
		String line="";
		try {
			BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while((line=bf.readLine())!=null){//每次读入一行进来，对这一行文本进行统计
				for(int i=0;i<line.length();i++){
					hash[line.charAt(i)]++;
				}
				//输出测试部分
				System.out.println(line);
				System.out.println(line.length());
			}
			bf.close();//读完之后，进行关闭
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//对统计结果进行输出查看
		for(int i=0;i<hash.length;i++){
			System.out.print(hash[i]+"\t");
		}
		return hash;
	}
	
	/**
	 * 类测试部分，提供了测试需要的参数
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath="D:/Temp/eclipseTemp/huffman.txt";
		scanning(filePath);
	}

}
