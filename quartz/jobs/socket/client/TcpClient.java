package com.tianqiauto.quartz.jobs.socket.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;


/**
 * 利用tcp交互数据的工具类
 * @author 白炯威
 * @version 1.0
 *
 */
public class TcpClient {
	
	/**
	 * 服务器端IP地址
	 */
	private String serverIp;
	
	/**
	 * 服务器端接收数据端口
	 */
	private int serverPort;
	
	/**
	 * 设置超时时长，如果超出这个时间没有响应数据，强制断开链接
	 */
	private int timeout;

	public TcpClient(String serverIp, int serverPort) {
		this.serverIp = serverIp;
		this.serverPort = serverPort;
	}
		
	/**
	 * 发送报文
	 * @param msg
	 * @return
	 * @throws Exception
	 */
	public void invokeFront(String msg) throws Exception {
		InetSocketAddress addr = new InetSocketAddress(this.serverIp, this.serverPort);
		SocketChannel sc = null;
		try {
			sc = SocketChannel.open();
			sc.connect(addr);
			sc.socket().setSoTimeout(this.timeout);
		} catch (IOException e) {
			e.printStackTrace();
			close(sc,null);
			throw new Exception("网络连接出错." + e.getMessage());
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sc.socket().getOutputStream()));
		bw.write(msg);
		bw.newLine();
		bw.flush();			
		close(sc,bw);
	}

	private void close(SocketChannel sc,BufferedWriter bw) throws Exception {
		if(bw != null){
			try {
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("BufferedWriter关闭出错." + e.getMessage());
			}
		}
		if (sc != null) {
			try {
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new Exception("关闭连接出错." + e.getMessage());
			}
		}
	}
}
