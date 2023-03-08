package com.Chat;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;



public class Client {
	//1.����Ϊ�������ⲿ�����ı���
	
		//1.1 UI���
		JButton ConnectServer;//����
		JButton DisconnectServer;//�Ͽ�
		JButton SendMessageButton;//����
		JTextField NickNameText;//�ǳ�
		JTextField ServerIPAddressText;//������ip
		JTextField ServerPortText;//�������˿�
		JTextField InputContentText;//��������
		JList OnlineClientList;//�����б�
		JLabel ChatContentLabel;//��������
	 
		//1.2 socket���
		Socket socket;//input��output��ͨ��socket����ģ����socket�ر��ˣ���������ҲʧЧ
		BufferedReader input;//inputΪ����������������
		PrintStream output;//outputΪ����������������
		
		//1.3  �û��ǳ�
		DefaultListModel<String> OnlineClientNickName;//�����û��ǳ��б������в������ݣ��Զ������ݲ��뵽JList��
		String ToTargetName = "ALL";//Ŀ���û��ǳƣ�OnlineClientList�ļ����������޸�
		
		//1.4�ͻ����߳�
		ClientThread cliendThread;
		public Client() {
			//2.1 ����UI������ʾ����
			CreateFrame();
		}
		//3.�����ӷ��������
		//3.1���ӷ�����
		public void ConnectServer() {
			//3.1.1 ��ȡ������Ϣ
			String ServerIPAddress = ServerIPAddressText.getText().trim();
			int ServerPort = Integer.parseInt(ServerPortText.getText().trim());
			String NickName = NickNameText.getText();
			
			try {
				//3.1.2 socket���
				socket = new Socket(ServerIPAddress, ServerPort);
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				output = new PrintStream(socket.getOutputStream());
				//3.1.2 �����б���������˱�ǩ
				OnlineClientNickName.addElement("������");
				//3.1.3 ����������ͱ��ʺŵ�½��Ϣ
				SendMessage("LOGIN@"+NickName);
				
				//3.1.4 Ϊ�ͻ��˽����߳�
				cliendThread = new ClientThread();
				
			} catch (UnknownHostException e) {
				Error("Client��������ַ�쳣"+e.getMessage());
				return;
			} catch (IOException e) {
				Error("Client�����ӷ������쳣"+e.getMessage());
				return;
			}	
		}
		//3.2 �Ͽ�����
		
		//3.3���ӻ�Ͽ�ʱ�İ�ť�Ƿ�ɵ������
		
	 
		//4. UI���
		//4.1����
		public void CreateFrame() {
			//4.1.1 �ܴ���
			JFrame ClientFrame = new JFrame("�ͻ���");
			ClientFrame.setSize(800,600);//���ó���ע����ֵ����Ҫ����
			ClientFrame.setLocationRelativeTo(null);//��������Ļ������ʾ
			ClientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����Ĭ�Ϲرհ�ť��������Ҳ����
	 
			//4.1.2 �ͻ�����Ϣ
			JPanel ClientIdPanel = new JPanel();
			ClientIdPanel.setLayout(new FlowLayout(FlowLayout.LEFT));//4.2.1 ���ÿͻ���id���Ĳ���Ϊ��������
			ClientIdPanel.setSize(800, 100);
			//4.1.2.2 �ǳ���
			JLabel NickNameLabel = new JLabel("�ǳ�");
			NickNameText = new JTextField(10);
			NickNameText.setText("jiangbowen");
			ClientIdPanel.add(NickNameLabel);
			ClientIdPanel.add(NickNameText);
			//4.1.2.3 ������IP��ַ
			JLabel ServerIPAddressLabel = new JLabel("IP��ַ");
			ServerIPAddressText = new JTextField(10);
			ServerIPAddressText.setText("127.0.0.1");
			ClientIdPanel.add(ServerIPAddressLabel);
			ClientIdPanel.add(ServerIPAddressText);
			//4.1.2.4 �˿ں�
			JLabel ServerPortLabel = new JLabel("�˿�");
			ServerPortText = new JTextField(10);
			ServerPortText.setText("8998");
			ClientIdPanel.add(ServerPortLabel);
			ClientIdPanel.add(ServerPortText);
			//4.1.2.5 ���ӷ�����/�Ͽ�����
			ConnectServer = new JButton("����");
			DisconnectServer = new JButton("�Ͽ�");
			ClientIdPanel.add(ConnectServer);
			ClientIdPanel.add(DisconnectServer);
			//4.1.2.6 ���ñ���
			ClientIdPanel.setBorder(new TitledBorder("�û���Ϣ��"));
			
			//4.1.3 �����б�
			JPanel FriendListPanel = new JPanel();
			FriendListPanel.setPreferredSize(new Dimension(200,400));
			FriendListPanel.setBorder(new TitledBorder("�����б�"));
			//4.1.3.1 �����б�����
			OnlineClientNickName = new DefaultListModel<String>();
			OnlineClientList = new JList(OnlineClientNickName);
			FriendListPanel.add(OnlineClientList);
			
			//4.1.4 �����������
			JPanel ChatContentPanel = new JPanel();
			ChatContentPanel.setPreferredSize(new Dimension(490,400));
			ChatContentPanel.setBorder(new TitledBorder("��������"));
			//4.1.4.1 �����������ݱ�ǩ
			ChatContentLabel = new JLabel("<html>");
			ChatContentLabel.setPreferredSize(new Dimension(490,400));
			ChatContentPanel.add(ChatContentLabel);
	 
			//4.1.5 �����������
			JPanel InputContentPanel = new JPanel();
			InputContentPanel.setPreferredSize(new Dimension(600,100));
			//4.1.5.1 ���������
			InputContentText = new JTextField();
			InputContentText.setPreferredSize(new Dimension(600,60));
			//4.1.5.2 ���Ͱ�ť
			SendMessageButton = new JButton("����");
			InputContentPanel.add(InputContentText);
			InputContentPanel.add(SendMessageButton);
			InputContentPanel.setBorder(new TitledBorder("��������"));
			
			//4.1.6 �ͻ������岼��
			ClientFrame.add(ClientIdPanel, BorderLayout.NORTH);
			ClientFrame.add(FriendListPanel, BorderLayout.WEST);
			ClientFrame.add(ChatContentPanel,BorderLayout.CENTER);
			ClientFrame.add(InputContentPanel,BorderLayout.SOUTH);
			
			//4.1.7���ÿɼ�
			ClientFrame.setVisible(true);	//���ÿɼ��������������ݶ�add��Frame֮��
			
			//4.1.8 ��Ӽ����¼�
			AddActionListener();
		}
		//4.2 ����¼�����
		private void AddActionListener() {
			//4.2.1 �������
			ConnectServer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ConnectServer();
				}
			});
			//4.2.2 ����Ͽ�
			DisconnectServer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			//4.2.3 �������
			SendMessageButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = InputContentText.getText().trim();
					SendMessage("MESSAGE@"+ToTargetName+"@"+NickNameText.getText()+"@"+message); 
				}
			});
			
			//4.2.4 ����Ŀ�귢������˭
			OnlineClientList.addListSelectionListener(new ListSelectionListener() { 
				@Override
				public void valueChanged(ListSelectionEvent e) {
					int index = OnlineClientList.getSelectedIndex();
					if(index<0) {
						Error("Client����⵽Ŀ�귢�����±�Ϊ����");
						return;
					}
					if(index == 0) {
						ToTargetName = "ALL";
					}else {
						String ToClientNickName = (String)OnlineClientNickName.getElementAt(index);
						ToTargetName = ToClientNickName;
					}
				}
			});
		}
		//4.3 ������󣨺�ɫ��
		private void Error(String message){
			//JLabel��֧��\n���У������html��ǩ���л��У�û��</html>������ǩ��Ӱ����ʾ
			ChatContentLabel.setText(ChatContentLabel.getText()+"<span color='red'>"+message+"</span>"+"<br />");
		}
	 
		//4.4 ���������������
		private void Log(String message){
			//JLabel��֧��\n���У������html��ǩ���л��У�û��</html>������ǩ��Ӱ����ʾ
			ChatContentLabel.setText(ChatContentLabel.getText()+"<span color='blue'>"+message+"</span>"+"<br />");
		}
		//4.5 ���˽������
		private void Message(String message){
			//JLabel��֧��\n���У������html��ǩ���л��У�û��</html>������ǩ��Ӱ����ʾ
			ChatContentLabel.setText(ChatContentLabel.getText()+"<span color='black'>"+message+"</span>"+"<br />");
		}
		//4.6 ����㲥����
		private void MessageTotal(String message){
			//JLabel��֧��\n���У������html��ǩ���л��У�û��</html>������ǩ��Ӱ����ʾ
			ChatContentLabel.setText(ChatContentLabel.getText()+"<span color='green'>"+message+"</span>"+"<br />");
		}
		
		
		//5. �ͻ����߳� �ڲ���
		public class ClientThread implements Runnable{
			//���������������ʱ���½��ͻ����̣߳������޷�������Ϣ
			//��������Ͽ�����ʱ�����������֪��ɱ���ͻ��˽���
			//�ͻ��˵���readlineʱ���������������Ҫ�½�һ���߳�
			boolean isRuning = true;
			//5.1 ���캯��
			public ClientThread () {
				//5.1.1 ��ʼ���߳�
				new Thread(this).start();
			}
			@Override
			//5.2 run���������߳̿�ʼʱ�Զ�����
			public void run() {
				while(isRuning) {//ѭ�������ظ�������Ϣ���ͻ��˶Ͽ�����֮ǰ��ֹͣ
					// TODO Auto-generated method stub
					String message;
					try {
						//5.2.1 �ڷ�������������Ϣ�ж�ȡ��һ��
						//readline��������������û����һ����Ϣ������ȴ�
						//������Ϊ��������Ҫ�½�һ���ͻ����߳�
						message = input.readLine();
						Tokenizer tokens = new Tokenizer(message, "@");//��ԭ����Ϣ���зָ�
						String MessageType = tokens.nextToken();
						
						//5.2.2������Ϊ����Ĵ���Э�����Ϣ������ʾ
						switch(MessageType) {
						case "LOGIN":{//�����û�����
							String LoginClientNickName = tokens.nextToken();
							Log("����֪ͨ���û�"+LoginClientNickName+"������");
							OnlineClientNickName.addElement(LoginClientNickName);
							break;
						}
						
						case "MESSAGE":{//������Ϣ
							String ToClientNickName = tokens.nextToken();
							String FromClientNickName = tokens.nextToken();
							String content = tokens.nextToken();
							if("ALL".equals(ToClientNickName)) {
								MessageTotal("����"+FromClientNickName+ "��ȫ�����Ϣ��"+content);
							}else {
								Message("����"+FromClientNickName+ "������˽����Ϣ��"+content);
							}
							break;
						}
						
						case "LOGOUT":{//�����û����ߵ���Ϣ
							
							break;
						}
						default :{
							Error("�ͻ��˽�����Ϣ��ʽ����");
							break;
						}				
						}
						System.out.println("�ͻ��˽��յ�"+message);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						Error("Client���ͻ��˽�����Ϣʧ��"+ e.getMessage());
					}
				}
			}	
		}
		
		//6. ��Ϣ���
		//6.1 ������Ϣ
		public void SendMessage(String message) {
			output.println(message);
			output.flush();
		}
		
		//6.2 ��Ϣ�ָ������ڲ��ࣩ
		public class Tokenizer{
			String Tokens[];
			int TokenIndex = 0;
			//6.2.1 ���췽������Message����Delimiter���зָ�
			public Tokenizer(String Message, String Delimiter) {
				Tokens = Message.split(Delimiter);
			}
			//6.2.2 ��ȡ��һ��
			public String nextToken() {
				TokenIndex++;
				return Tokens[TokenIndex-1];
			}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = new Client();

	}

}
