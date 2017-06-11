package com.xjtuse.rebuildHuff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * �Ѿ�����������ַ���huffman���룬����Ҫ���ľ��ǽ���ѹ����ÿ7���д���������ǰ�������0
 * @author 22847
 *
 */
public class Compression {

	/**
	 * ����ѹ������
	 * @param code
	 */
	public static void compression(Code []code,String filePath,String outFilePath){
		File file=new File(filePath);
		String line="";
//		StringBuilder sb=new StringBuilder();
		try {
			BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String tmp="0";//�ƶ������λ����Ҫ��Ϊ�˽�������������������Ϊ���е������ܲ���8��Ԫ�أ��޷�д�룬��ô�����һ�е�Ԫ��������8λ����д��
			while((line=bf.readLine())!=null){//�����ļ��е�һ��
				
				StringBuilder sb=new StringBuilder();
				for(int i=0;i<line.length();i++){//����һ���ı�ת��Ϊ�����Ʊ�ʾ
					char ch=line.charAt(i);//ȡ��һ���ַ�
					for(int j=0;j<code.length;j++){//�������뼯���ҵ�����ַ���Ӧ�ı���
						if(ch==code[j].ch){
							sb.append(code[j].bincode);//���ҵ��ı��봫��д����
						}
					}
					
				}
				//�����е��ı�����ѹ������
				
				for(int j=0;j<sb.length();j++){
					tmp=tmp+sb.charAt(j);
					if(tmp.length()==8){
						int ascii=binToDec(tmp);//�������ƴ�������Ϻ�õ�һ��asciiֵ������ֵ�����ѹ���ļ���
						writeBack(ascii,outFilePath);
						tmp="0";
					}
				}
				System.out.println("huffman������ʽ��"+sb.toString());	
			}
			//��鴦�����δ���͵Ķ������룬Ҳ�������û�е�8λ�����������ı��Ѿ�������
			System.out.println("���û�г��͵�bincode��"+tmp);
			Mend mend=new Mend();
			String str=mend.mend(tmp);
			writeBack(binToDec(str),outFilePath);
			bf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ��������Ϲ���huffman����ת��Ϊ�������������
	 * @param bin
	 * @return
	 */
	public static int binToDec(String bin){
		int result=0;
		for(int i=bin.length()-1;i>=0;i--){
			if(bin.charAt(i)=='1'){
				result=(int) (result+Math.pow(2,bin.length()-i-1));
			}
		}
		return result;
	}
	/**
	 * ���ı�д�ص�ѹ���ļ���ȥ��
	 * @param ascii
	 * @param outFilePath
	 */
	public static void writeBack(int ascii,String outFilePath){
		try {
			//ע������ĵڶ������� true����Ϊ����־���Ƿ�׷��д�������false����ô��ʾ������׷�ӣ�Ҳ����ÿ�ζ��ǽ������ļ��������д��
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(outFilePath),true)));
			bw.write((char)ascii); //����ǽ�ѹ���ļ�д��
			bw.flush();
			bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String bin="00000110";
//		int r=binToDec(bin);
//		System.out.println("r: "+r);
		String filePath="D:/Temp/eclipseTemp/huffman.txt";
		String outFilePath="D:/Temp/eclipseTemp/compression.txt";
		Scanning scan=new Scanning();
		Extract extract=new Extract();
		Initiation init=new Initiation();
		Encoding encode=new Encoding();
		List r1=extract.extractInfor(scan.scanning(filePath));
		HuffNode []nodes=init.initHuffTree(r1);
		HuffNode []node=init.treeBuilding(nodes);
		Code[] code=encode.encoding(node);
		compression(code,filePath,outFilePath);
	}

}
