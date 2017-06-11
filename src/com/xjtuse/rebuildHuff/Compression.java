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
 * 已经获得了所有字符的huffman编码，现在要做的就是进行压缩，每7进行处理，并且在前面添加上0
 * @author 22847
 *
 */
public class Compression {

	/**
	 * 进行压缩过程
	 * @param code
	 */
	public static void compression(Code []code,String filePath,String outFilePath){
		File file=new File(filePath);
		String line="";
//		StringBuilder sb=new StringBuilder();
		try {
			BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String tmp="0";//移动到这个位置主要是为了将所有行连接起来，因为本行的最后可能不到8个元素，无法写入，那么会和下一行的元素连接至8位后再写入
			while((line=bf.readLine())!=null){//读入文件中的一行
				
				StringBuilder sb=new StringBuilder();
				for(int i=0;i<line.length();i++){//将这一行文本转换为二进制表示
					char ch=line.charAt(i);//取出一个字符
					for(int j=0;j<code.length;j++){//搜索编码集，找到与该字符对应的编码
						if(ch==code[j].ch){
							sb.append(code[j].bincode);//将找到的编码传给写函数
						}
					}
					
				}
				//对这行的文本进行压缩处理
				
				for(int j=0;j<sb.length();j++){
					tmp=tmp+sb.charAt(j);
					if(tmp.length()==8){
						int ascii=binToDec(tmp);//将二进制串重新组合后得到一个ascii值，将该值输出到压缩文件中
						writeBack(ascii,outFilePath);
						tmp="0";
					}
				}
				System.out.println("huffman编码形式："+sb.toString());	
			}
			//这块处理最后未成型的二进制码，也就是最后还没有到8位，但是整个文本已经读完了
			System.out.println("最后没有成型的bincode："+tmp);
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
	 * 将重新组合过的huffman编码转化为整数，并输出来
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
	 * 将文本写回到压缩文件中去，
	 * @param ascii
	 * @param outFilePath
	 */
	public static void writeBack(int ascii,String outFilePath){
		try {
			//注意这里的第二个参数 true，因为它标志着是否追加写，如果是false，那么表示不可以追加，也就是每次都是将整个文件先清空再写入
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(outFilePath),true)));
			bw.write((char)ascii); //这块是将压缩文件写回
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
