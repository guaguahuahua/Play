package com.xjtuse.rebuildHuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ��Ҫ��ɨ���ⲿ���ļ����Թ��ɵ�Ԫ�ؽ��м�������Ϊhuffman��������Ȩֵ����
 * @author 22847
 *
 */
public class Scanning {
	/**
	 * ���ݴ��������ļ���·���������ļ���ɨ��ͳ�ƹ���
	 * @param filePath �ļ���·��
	 * return ���ض��ļ����ַ���ͳ�ƽ��
	 */
	public static int[] scanning(String filePath){
		int []hash=new int [128];//���������飬��ΪӢ���ַ�����0--127֮�䣬����ʹ��ASCII���Ӧ��������Ϊ����ֱ�Ӵ洢
		File file=new File(filePath);
		String line="";
		try {
			BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while((line=bf.readLine())!=null){//ÿ�ζ���һ�н���������һ���ı�����ͳ��
				for(int i=0;i<line.length();i++){
					hash[line.charAt(i)]++;
				}
				//������Բ���
				System.out.println(line);
				System.out.println(line.length());
			}
			bf.close();//����֮�󣬽��йر�
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ͳ�ƽ����������鿴
		for(int i=0;i<hash.length;i++){
			System.out.print(hash[i]+"\t");
		}
		return hash;
	}
	
	/**
	 * ����Բ��֣��ṩ�˲�����Ҫ�Ĳ���
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath="D:/Temp/eclipseTemp/huffman.txt";
		scanning(filePath);
	}

}
