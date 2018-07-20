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
	//컬럼 이름 배열
	String [] columns = {"이름", "전화번호", "주소"};
	//데이터 배열
	String [][] data = {
			{"유리", "01039485039", "서울 종로구"},
			{"소영", "01048693759", "서울 강북구"},
			{"태연", "01048593832", "서울 강남구"}
	};

	public AddressBook() {
		setBounds(700, 700, 1000, 1000);
		setTitle("연락처");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//먼저 테이블 모델 만들기- 처음부터 데이터 있을 때는 먼저 모델을 만들수 있다.
		DefaultTableModel model = new DefaultTableModel(data, columns);
		//테이블 모델로 테이블 만들기 - View부분
		JTable table = new JTable(model);
		//table.setModel()-데이터를 먼주 주지 않았을 때 
		
		//테이불을 ScrollPane으로 출력하기
		JScrollPane scrollPane = new JScrollPane(table);
		
		// ScrollPane을 윈도우에 부착.
		add(scrollPane);

		
		/*//MassageDialog 
		JOptionPane.showMessageDialog(null, "erro504", "에러메세지", JOptionPane.QUESTION_MESSAGE);
		//ConfirmDialog - 정수를 리턴 (예-0 아니오-1 취소-2)
		int i = JOptionPane.showConfirmDialog(null, "erro504, 계속하시겠습니까?", "에러메세지", JOptionPane.YES_NO_CANCEL_OPTION);
		System.out.println(i);
		//InputDialog - String을 리턴(취소-null)
		String str = JOptionPane.showInputDialog(null, "erro504, 계속하시겠습니까?", "에러메세지", JOptionPane.YES_NO_CANCEL_OPTION);
		System.out.println(str);*/
		
		//JMenu 만들기
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu file = new JMenu("파일(a)");
		//단축키 설정
		file.setMnemonic('a');
		menuBar.add(file);
		
		JMenuItem open = new JMenuItem("열기");
		file.add(open);
		JMenu save = new JMenu("저장");
		file.add(save);
		JRadioButtonMenuItem saveitem1 = new JRadioButtonMenuItem("저장");
		JRadioButtonMenuItem saveitem2 = new JRadioButtonMenuItem("모두 저장");
		save.add(saveitem1);
		save.add(saveitem2);
		
		//JLabel
		JLabel lbName = new JLabel("이름");
		JTextField tfName = new JTextField(10);
		JLabel lbPhone = new JLabel("전화번호");
		JTextField tfPhone = new JTextField(10);
		JLabel lbAddress = new JLabel("주소");
		JTextField tfAddress = new JTextField(30);
		
		
		JButton btnInsert = new JButton("삽입");
		JButton btnDelete = new JButton("삭제");
		
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
		
		//삽입버튼 이벤트 처리
		ActionListener insertListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String phone = tfPhone.getText();
				String address = tfAddress.getText();
				//문자열 좌우공백 지우기
				name = name.trim();
				phone = phone.trim();
				address = address.trim();
				//name의 필수입력
				if(name.length() == 0) {
					JOptionPane.showMessageDialog(null, "이름은 필수 입력!", "이름", JOptionPane.WARNING_MESSAGE);
					return;
				}
				// 입력한 텍스트를 배열(행)로 만들어서 테이블 모델에 넣는다 
				String [] row = {name, phone, address};
				//테이블에 데이터를 넣기 위해 테이블의 모델을 가져온다 
				// table.getModel()의 리턴 값은 TableModel(인터페이스)(DefaultTableModel 클래스 implements TableModel)
				// 그래서 형변환을 해주어야 한다. 
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				//모델에 행추가
				model.addRow(row);
				//테이블을 갱신
				table.updateUI();
				
				tfName.setText("");
				tfPhone.setText("");
				tfAddress.setText("");
				
				JOptionPane.showMessageDialog(null, "데이터 삽입성공", "성공",JOptionPane.PLAIN_MESSAGE);
			}
			
		};
		btnInsert.addActionListener(insertListener);
		
		//삭제버튼 이벤트 처리
		ActionListener deleteListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//선택한 행번호 가져오기
				int idx = table.getSelectedRow();
				//테이블 행을 선택하지 않았다면
				if(idx == -1) {
					JOptionPane.showMessageDialog(null, "행을 선택하세요!", "삭제실패", JOptionPane.WARNING_MESSAGE);
					return;
				}
				//테이블 모델을 가져와 행 지우기
				DefaultTableModel model =(DefaultTableModel)table.getModel();
				model.removeRow(idx);
				table.updateUI();
				JOptionPane.showMessageDialog(null, "삭제성공", "삭제", JOptionPane.PLAIN_MESSAGE);
				
			}
			
		};
		btnDelete.addActionListener(deleteListener);
		setVisible(true);
	
	}
}
