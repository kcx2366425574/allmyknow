package socket.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @date 2019-11-05
 * @author kcx
 * @description 
 */
public class ChatClient extends JFrame {
	Socket socket;
	PrintWriter pWriter;
	BufferedReader br;
	JPanel panel;
	JScrollPane sPane;
	JTextArea txtContent;
	JLabel lblName,lblSend;
	JTextField txtName,txtSend;
	JButton btnSend;
	
	public ChatClient() {
		super("QST聊天室");
		txtContent = new JTextArea();
		
		/**
		 * 设置文本域只读
		 */
		txtContent.setEditable(false);
		
		sPane = new JScrollPane(txtContent);
		
		lblName = new JLabel("昵称：");
		txtName = new JTextField(5);
		lblSend = new JLabel("发言：");
		txtSend = new JTextField(20);
		btnSend = new JButton("发送");
		
		panel = new JPanel();
		panel.add(lblName);
		panel.add(txtName);
		panel.add(txtSend);
		panel.add(lblSend);
		panel.add(btnSend);
		this.add(panel,BorderLayout.SOUTH);
		
		this.add(sPane);
		this.setSize(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		try {
			/**
			 * 创建一个套接字
			 */
			socket = new Socket("127.0.0.1", 28888);
			
			/**
			 * 创建一个从套接字中写数据的通道，即输出流，给服务器发送信息
			 */
			pWriter = new PrintWriter(socket.getOutputStream());
			
			/**
			 * 创建一个从套接字中读数据的通道，即输入流，读服务器的返回信息
			 */
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * 注册监听
		 */
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				/**
				 * 获取用户输入的文本
				 */
				String name = txtName.getText();
				String msg = txtSend.getText();
				if(!msg.equals("")) {
					/**
					 * 通过输出流将数据发送给服务器
					 */
					pWriter.println(name+"说："+msg);
					pWriter.flush();
					
					/**
					 * 清空文本框
					 */
					txtSend.setText("");
				}
			}
		});
		
		/**
		 * 启动线程
		 */
		new getMsgFromServer().start();
		
	}
	
	/**
	 * 接收服务器的返回信息的线程
	 */
	class getMsgFromServer extends Thread{
		public void run() {
			while(this.isAlive()) {
				try {
					String msg = br.readLine();
					if(msg!=null) {
						/**
						 * 在文本域中显示聊天信息
						 */
						txtContent.append(msg+"\n");
					}
					Thread.sleep(50);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		/**
		 * 创建聊天客户端窗口实例，并显示
		 */
		new ChatClient().setVisible(true);
	}

}
