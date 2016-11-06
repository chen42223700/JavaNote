package test.student_cxc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class changeCharset {

	public static void main(String[] args) throws IOException {
		ServerSocket server = null;
		Socket socket = null;
		BufferedReader br_gbk = null;
		InputStream is = null;
		PrintWriter pw = null;
		int port = 8080;
		
		try {
	
			//将接收的消息以GBK方式解码
			br_gbk = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("D:\\sql笔记.txt"),"gbk"));
			
			String file = "";
			
			//循环读取接收的消息并放入file中
			while (true) {
				String str_gbk = br_gbk.readLine();
				//当读完最后一行，结束循环
				if (str_gbk == null) {
					break;
				}
				
				
				//将字符串已gbk方式解码
				byte[] b = str_gbk.getBytes("gbk");
				//将字节已"utf-8"方式编码
				String str_utf8 = new String(b,"utf-8");
				
				//把编码后的字符串放入file中
				file += str_utf8;
				
			}
			
			pw = new PrintWriter(
					new OutputStreamWriter(
							new FileOutputStream("D:\\changeCharset.txt"),"utf-8"));
			
			pw.println(file);
			
			//将file转为InputStream流
//			is = new ByteArrayInputStream(file.getBytes("utf-8"));		
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			br_gbk.close();
//			is.close();
			pw.close();
		}
	}
}
