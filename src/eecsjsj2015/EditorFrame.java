package eecsjsj2015;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.KeyStroke;

public class EditorFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabPane;
	private Box box;
	private JDesktopPane desk;
	private JSplitPane editorSplitPane;//���ڷָ����༭������Ϣ��ʾ��������
	private JScrollPane infoPane;//���Թ����� JScrollPane �������ڷ� infoArea
	private JTextArea infoArea; //������ʾ��Ϣ���ı���
	private JScrollPane treePane;
	private JSplitPane mainSplitPane; //��������ķָ����������
	private JTree tree; //��Ŀ������
	private JMenuBar menuBar; //�˵�������
	private JMenu editMenu; //�༭�˵�����
	private JMenu fileMenu; //�ļ��˵�
	
	public EditorFrame(String title){
		super(title);
		initFrame();
		pack();
	}
	
	//�½��ļ��� Action ����
	private Action fileNew = new AbstractAction("�½��ļ�") {
		public void actionPerformed(ActionEvent e) {

		}
	};
	
	private Action exit = new AbstractAction("�˳�"){
		public void actionPerformed(ActionEvent e) {

		}		
	};
	
	private Action copy = new AbstractAction("����"){
		public void actionPerformed(ActionEvent e) {
			//
		}		
	};
	
	public void addListeners() {
		//�½��ļ��ļ�����
		fileMenu.add(fileNew).setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
		//ʡ�����������������Ĵ���
		fileMenu.add(exit);
		//��Ӹ��Ƽ�����
		editMenu.add(copy).setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));
		//ʡ����������������Ĵ���
	}
	
	public void initFrame() {
		//���ô��ڹرգ��˳�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�������༭���� tabPane
		tabPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT );
		desk = new JDesktopPane();//���� JDesktopPane ����
		desk.setBackground(Color.GRAY);//���� desk �ı�����ɫΪ��ɫ
		box = new Box(BoxLayout.Y_AXIS);//���� box �Ĳ���
		box.add(tabPane);
		box.add(desk);
		infoArea = new JTextArea("", 5, 50); //������Ϣ��ʾ�����ı���
		infoPane = new JScrollPane(infoArea); //�� infoArea �ı�����Ϊ����ŵ� infoPane ��
		infoArea.setEditable(false); //������Ϣ�����ɱ༭
		//��������ָ���������������� box ����� infoPane ��������
		editorSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, box, infoPane);
		editorSplitPane.setDividerSize(3);
		editorSplitPane.setDividerLocation(500);
		//add(editorSplitPane);	
		
		tree = new JTree();//����������
		treePane = new JScrollPane(tree); //�����ɹ�������������
		//����������� JSplitPane���������Ϊ treePane���ұ�Ϊ editorSplitPane
		mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treePane,editorSplitPane);
		mainSplitPane.setDividerLocation(200); //���÷ָ�����λ��
		
		add(mainSplitPane);	
		
		menuBar = new JMenuBar();//�����˵�������
		editMenu = new JMenu("�༭");//�����༭�˵�����
		fileMenu = new JMenu("�ļ�");//�����ļ��˵�
		menuBar.add(fileMenu); //���ļ��˵���ӵ��˵�����
		menuBar.add(editMenu); //���༭�˵���ӵ��˵�����
		setJMenuBar(menuBar); //���� JFrame �Ĳ˵���
		addListeners();
		
		pack();//ʹ JFrame ������Ѵ�С
	}
	
}
