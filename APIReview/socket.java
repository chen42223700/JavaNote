package test.student_cxc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class socket {
	
	public static void main(String[] args) throws IOException {
		
		Socket socket = null;
		BufferedReader br =null;
		//path:报文路径（格式不限）
		String path = "D:\\mylog.txt";
		//IP:要发送的IP地址
		String IP = "255.255.255.1";
		//port:要发送的端口
		int port = 8080;
		//charset:要发送的字符集编码
		String charset = "utf-8"; 
		PrintWriter pw =null;
		
		
		try {
			socket = new Socket(IP,port);
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"gbk"));
			pw = new PrintWriter(socket.getOutputStream());
			
			while (true) {
				String msg = br.readLine();
				if (msg == null) {
					break;
				}
				//将字符串已gbk方式解码
				byte[] b = msg.getBytes("gbk");
				//将字节已"utf-8"方式编码
				String str_utf8 = new String(b,charset);
				
				//把编码后的字符串放入file中
				pw.println(str_utf8);
	
			}
			
			pw.flush();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (socket != null) {
				socket.close();
			}
			
			if (br != null) {
				br.close();
			}
		}
	}
}
