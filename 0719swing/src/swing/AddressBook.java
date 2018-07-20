package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddressBook extends JFrame {
	//�÷� �̸� �迭
	String [] columns = {"�̸�", "��ȭ��ȣ", "�ּ�"};
	//������ �迭
	String [][] data = {
			{"����", "01039485039", "���� ���α�"},
			{"�ҿ�", "01048693759", "���� ���ϱ�"},
			{"�¿�", "01048593832", "���� ������"}
	};

	public AddressBook() {
		setBounds(700, 700, 1000, 1000);
		setTitle("����ó");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//���� ���̺� �� �����- ó������ ������ ���� ���� ���� ���� ����� �ִ�.
		DefaultTableModel model = new DefaultTableModel(data, columns);
		//���̺� �𵨷� ���̺� ����� - View�κ�
		JTable table = new JTable(model);
		//table.setModel()-�����͸� ���� ���� �ʾ��� �� 
		
		//���̺��� ScrollPane���� ����ϱ�
		JScrollPane scrollPane = new JScrollPane(table);
		
		// ScrollPane�� �����쿡 ����.
		add(scrollPane);

		
		/*//MassageDialog 
		JOptionPane.showMessageDialog(null, "erro504", "�����޼���", JOptionPane.QUESTION_MESSAGE);
		//ConfirmDialog - ������ ���� (��-0 �ƴϿ�-1 ���-2)
		int i = JOptionPane.showConfirmDialog(null, "erro504, ����Ͻðڽ��ϱ�?", "�����޼���", JOptionPane.YES_NO_CANCEL_OPTION);
		System.out.println(i);
		//InputDialog - String�� ����(���-null)
		String str = JOptionPane.showInputDialog(null, "erro504, ����Ͻðڽ��ϱ�?", "�����޼���", JOptionPane.YES_NO_CANCEL_OPTION);
		System.out.println(str);*/
		
		//JMenu �����
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu file = new JMenu("����(a)");
		//����Ű ����
		file.setMnemonic('a');
		menuBar.add(file);
		
		JMenuItem open = new JMenuItem("����");
		file.add(open);
		JMenu save = new JMenu("����");
		file.add(save);
		JRadioButtonMenuItem saveitem1 = new JRadioButtonMenuItem("����");
		JRadioButtonMenuItem saveitem2 = new JRadioButtonMenuItem("��� ����");
		save.add(saveitem1);
		save.add(saveitem2);
		
		//JLabel
		JLabel lbName = new JLabel("�̸�");
		JTextField tfName = new JTextField(10);
		JLabel lbPhone = new JLabel("��ȭ��ȣ");
		JTextField tfPhone = new JTextField(10);
		JLabel lbAddress = new JLabel("�ּ�");
		JTextField tfAddress = new JTextField(30);
		
		
		JButton btnInsert = new JButton("����");
		JButton btnDelete = new JButton("����");
		
		JPanel southPanel = new JPanel();
		add("South", southPanel);
		southPanel.add(lbName);
		southPanel.add(tfName);
		southPanel.add(lbPhone);
		southPanel.add(tfPhone);
		southPanel.add(lbAddress);
		southPanel.add(tfAddress);
		
		JPanel northPanel = new JPanel();
		add("North", northPanel);
		northPanel.add(btnInsert);
		northPanel.add(btnDelete);
		
		//���Թ�ư �̺�Ʈ ó��
		ActionListener insertListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String phone = tfPhone.getText();
				String address = tfAddress.getText();
				//���ڿ� �¿���� �����
				name = name.trim();
				phone = phone.trim();
				address = address.trim();
				//name�� �ʼ��Է�
				if(name.length() == 0) {
					JOptionPane.showMessageDialog(null, "�̸��� �ʼ� �Է�!", "�̸�", JOptionPane.WARNING_MESSAGE);
					return;
				}
				// �Է��� �ؽ�Ʈ�� �迭(��)�� ���� ���̺� �𵨿� �ִ´� 
				String [] row = {name, phone, address};
				//���̺� �����͸� �ֱ� ���� ���̺��� ���� �����´� 
				// table.getModel()�� ���� ���� TableModel(�������̽�)(DefaultTableModel Ŭ���� implements TableModel)
				// �׷��� ����ȯ�� ���־�� �Ѵ�. 
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				//�𵨿� ���߰�
				model.addRow(row);
				//���̺��� ����
				table.updateUI();
				
				tfName.setText("");
				tfPhone.setText("");
				tfAddress.setText("");
				
				JOptionPane.showMessageDialog(null, "������ ���Լ���", "����",JOptionPane.PLAIN_MESSAGE);
			}
			
		};
		btnInsert.addActionListener(insertListener);
		
		//������ư �̺�Ʈ ó��
		ActionListener deleteListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//������ ���ȣ ��������
				int idx = table.getSelectedRow();
				//���̺� ���� �������� �ʾҴٸ�
				if(idx == -1) {
					JOptionPane.showMessageDialog(null, "���� �����ϼ���!", "��������", JOptionPane.WARNING_MESSAGE);
					return;
				}
				//���̺� ���� ������ �� �����
				DefaultTableModel model =(DefaultTableModel)table.getModel();
				model.removeRow(idx);
				table.updateUI();
				JOptionPane.showMessageDialog(null, "��������", "����", JOptionPane.PLAIN_MESSAGE);
				
			}
			
		};
		btnDelete.addActionListener(deleteListener);
		setVisible(true);
	
	}
}
