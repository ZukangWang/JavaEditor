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
	private JSplitPane editorSplitPane;//用于分隔主编辑区和信息显示区的容器
	private JScrollPane infoPane;//可以滚动的 JScrollPane 对象，用于放 infoArea
	private JTextArea infoArea; //用于显示信息的文本域
	private JScrollPane treePane;
	private JSplitPane mainSplitPane; //整个界面的分隔组件的容器
	private JTree tree; //项目树对象
	private JMenuBar menuBar; //菜单栏对象
	private JMenu editMenu; //编辑菜单对象
	private JMenu fileMenu; //文件菜单
	
	public EditorFrame(String title){
		super(title);
		initFrame();
		pack();
	}
	
	//新建文件的 Action 对象
	private Action fileNew = new AbstractAction("新建文件") {
		public void actionPerformed(ActionEvent e) {

		}
	};
	
	private Action exit = new AbstractAction("退出"){
		public void actionPerformed(ActionEvent e) {

		}		
	};
	
	private Action copy = new AbstractAction("复制"){
		public void actionPerformed(ActionEvent e) {

		}		
	};
	
	public void addListeners() {
		//新建文件的监听器
		fileMenu.add(fileNew).setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
		//省略其他创建监听器的代码
		fileMenu.add(exit);
		//添加复制监听器
		editMenu.add(copy).setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));
		//省略添加其他监听器的代码
	}
	
	public void initFrame() {
		//设置窗口关闭，退出程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//创建主编辑区的 tabPane
		tabPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT );
		desk = new JDesktopPane();//创建 JDesktopPane 对象
		desk.setBackground(Color.GRAY);//设置 desk 的背景颜色为灰色
		box = new Box(BoxLayout.Y_AXIS);//设置 box 的布局
		box.add(tabPane);
		box.add(desk);
		infoArea = new JTextArea("", 5, 50); //创建信息显示区的文本域
		infoPane = new JScrollPane(infoArea); //将 infoArea 文本域作为组件放到 infoPane 中
		infoArea.setEditable(false); //设置信息区不可编辑
		//创建这个分隔组件的容器，并将 box 对象和 infoPane 放置其中
		editorSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, box, infoPane);
		editorSplitPane.setDividerSize(3);
		editorSplitPane.setDividerLocation(500);
		//add(editorSplitPane);	
		
		tree = new JTree();//创建树对象
		treePane = new JScrollPane(tree); //创建可滚动的容器对象
		//创建主界面的 JSplitPane，横向，左边为 treePane，右边为 editorSplitPane
		mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treePane,editorSplitPane);
		mainSplitPane.setDividerLocation(200); //设置分隔条的位置
		
		add(mainSplitPane);	
		
		menuBar = new JMenuBar();//创建菜单栏对象
		editMenu = new JMenu("编辑");//创建编辑菜单对象
		fileMenu = new JMenu("文件");//创建文件菜单
		menuBar.add(fileMenu); //将文件菜单添加到菜单栏中
		menuBar.add(editMenu); //将编辑菜单添加到菜单栏中
		setJMenuBar(menuBar); //设置 JFrame 的菜单栏
		addListeners();
		
		pack();//使 JFrame 调整最佳大小
	}
	
}
