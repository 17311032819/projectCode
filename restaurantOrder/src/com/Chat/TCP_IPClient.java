package com.Chat;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;

public class TCP_IPClient extends JFrame{
	private PrintWriter writer; // 声明PrintWriter类对象
	Socket socket; // 声明Socket对象
	private JTextArea ta = new JTextArea(); // 创建JtextArea对象
	private JTextField tf = new JTextField(); // 创建JtextField对象
	Container cc; // 声明Container对象
	public TCP_IPClient(String title) { // 构造方法
		super(title); // 调用父类的构造方法
		cc = this.getContentPane(); // 实例化对象
		cc.add(ta, "North"); // 将文本域放在窗体的上部
		cc.add(tf, "South"); // 将文本框放在窗体的下部
		tf.addActionListener(new ActionListener() { // 绑定事件
					public void actionPerformed(ActionEvent e) {
						writer.println(tf.getText()); // 将文本框中信息写入流
						ta.append(tf.getText() + '\n'); // 将文本框中信息显示在文本域中
						tf.setText(" "); // 将文本框清空
					}
				});
	}
	private void connect() { // 连接套接字方法
		ta.append("尝试连接"); // 文本域中信息信息
		try { // 捕捉异常
			socket = new Socket("127.0.0.1", 8998); // 实例化Socket对象
			writer = new PrintWriter(socket.getOutputStream(), true);
			ta.append("完成连接"); // 文本域中提示信息
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
	}
	public static void main(String[] args) { // 主方法
		TCP_IPClient clien = new TCP_IPClient("向服务器送数据"); // 创建本例对象
		clien.setSize(200, 200); // 设置窗体大小
		clien.setExtendedState(JFrame.MAXIMIZED_BOTH);
		clien.setVisible(true); // 将窗体显示
		clien.connect(); // 调用连接方法
	}

}
