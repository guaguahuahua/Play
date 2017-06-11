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
 * 对当前文本进行解压，解压过程一定要保证正确性，否则压缩和解压都是空话，因为正确率太低，根本就无法使用
 * @author 22847
 */
public class Decompression {
	/**
	 * 解压方法，通过已经构建好的huffman树，进行解压，注意根节点是节点数组的最后一个，
	 * @param node
	 * @param inFilePath
	 */
	public static void decompression(HuffNode []node,String inFilePath,String outFilePath){
		String line="";
		try {
			//读入压缩文件
			BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(new File(inFilePath))));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(outFilePath))));
			String tmp="";//这个变量主要是为了捕捉到遍历的过程中最后没有输出的编码，需要将这部分的编码与后面的编码进行连接
			while((line=bf.readLine())!=null){//读入一行
				StringBuilder sb=new StringBuilder();
				for(int i=0;i<line.length();i++){//将这行文本转化为二进制串
					char ch=line.charAt(i);
					String huff=decToBinary(ch);
					sb.append(huff);//将所有的文本转化为了二进制串的形式
				}
				//为了防止溢出，我们在一行转化结束之后就直接根据编码得到相应的字符
				HuffNode root=node[node.length-1];
//				System.out.println("huffman解压编码："+tmp+sb.toString());
				System.out.println();
				int i=0;
				String connected=tmp+sb.toString();//将当前的编码与上一步的编码进行
				
				tmp="";//这是为了保证下面的tmp变量不受影响
				while(i<connected.length()){
					if(root.leftChild!=-1 && root.rightChild!=-1){
						if(connected.charAt(i)=='0'){
							tmp=tmp+'0';
							root=node[root.leftChild];
						}else if(connected.charAt(i)=='1'){
							root=node[root.rightChild];
							tmp=tmp+'1';
						}
					}else{
						System.out.print(root.value);
						bw.write(root.value);
						bw.flush();
						root=node[node.length-1];//重新从根节点开始
						i--;	//至关重要，因为在这一步，并没有进行遍历应该将i向后退一位
						tmp="";
					}
					i++;
				}
				System.out.println("最后剩下的编码：："+tmp);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据读入的字符值将字符转换为二进制串并将长度补足至七位
	 * @param ascii
	 * @return
	 */
	public static String decToBinary(int ascii){
		String result="";
		int yu=0;
		while(ascii!=0){
			yu=ascii%2;
			result=yu+result;
			ascii/=2;
		}
		/**
		 * 为什么要进行补位？
		 * 原因很简单，因为在压缩的时候是将所有的编码进行拼接成8位，也就是除了最高位是0以外，
		 * 其余都是有效的数字，包括0，但是在读出的时候，直接找到了该编码的ascii，然后转化为
		 * 二进制，所以转化结果可能会丢掉前面有用的0元素，所以在解压缩的时候必须进行补位将丢失
		 * 的0元素补回来
		 */
		String mend="00000000";
		if(result.length()<7){//将结果补足为7位后在进行返回
			result=mend.subSequence(0,7-result.length())+result;
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath="D:/Temp/eclipseTemp/huffman.txt";
		String outFilePath="D:/Temp/eclipseTemp/compression.txt";
		String inFile="D:/Temp/eclipseTemp/compression.txt";
		String outFilePath1="D:/Temp/eclipseTemp/newDecompression.txt";
		Scanning scan=new Scanning();
		Extract extract=new Extract();
		Initiation init=new Initiation();
		Encoding encode=new Encoding();
		Compression com=new Compression();
		List r1=extract.extractInfor(scan.scanning(filePath));
		HuffNode []nodes=init.initHuffTree(r1);
		HuffNode []node=init.treeBuilding(nodes);
		Code[] code=encode.encoding(node);
		com.compression(code,filePath,outFilePath);
		decompression(node,inFile,outFilePath1);
	}

}
