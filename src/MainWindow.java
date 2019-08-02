import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton labList, exit, applyList;
	private JPanel panelWest;
	private JPanel panelButton;
	private JPanel centerPanel;
	private JPanel panelSouth;
	private JPanel panelNorth;
	private JLabel welcome;
	
	public MainWindow(int i) {
		initUI(i);
	}
	
	public void initUI(int i) {
		if(i == 1) {
			initTeacherWindow();
		} else if(i == 2) {
			initStuWindow();
		} else if(i == 0){
			initRootWindow();
		}
	}	
	
	public void initTeacherWindow() {
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		this.setTitle("教师");
		
		panelWest = new JPanel();
		panelWest.setBackground(Color.white);
		c.add(panelWest, "West");
		panelWest.setLayout(new GridLayout(2, 1));
		
		panelButton = new JPanel(new GridLayout(4, 1));
		panelWest.add(panelButton);
		labList = new JButton("实验室列表");
		applyList = new JButton("申请实验室");
		exit = new JButton("退出");
		JButton stutus = new JButton("申请状态");
		labList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				centerPanel.setVisible(false);
				centerPanel.removeAll();
				centerPanel.add(new LabList(), "Center");
				centerPanel.setVisible(true);
			}
		});
		applyList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				centerPanel.setVisible(false);
				centerPanel.removeAll();
				centerPanel.add(new ApplyLab(), "Center");
				centerPanel.setVisible(true);
			}
		});
		stutus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panelButton.add(labList);
		panelButton.add(applyList);
		panelButton.add(stutus);
		panelButton.add(exit);
		
		centerPanel = new JPanel();
		JLabel cp1 = new JLabel();
		cp1.setSize(new Dimension(500, 300));
		centerPanel.add(cp1);
		JScrollPane jsp = new JScrollPane(centerPanel);
		c.add(jsp,"Center");
		
		panelSouth = new JPanel(new GridLayout(2, 1));
		panelSouth.setBackground(Color.green);
		c.add(panelSouth, "South");
		panelSouth.add(new JLabel("XTU", JLabel.CENTER));
		panelSouth.add(new JLabel("Copyright 2019.", JLabel.CENTER));
		panelNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelNorth.setBackground(Color.YELLOW);
		c.add(panelNorth, "North");
		
		welcome = new JLabel("欢迎你，教师");
		welcome.setFont(new Font("华文行楷", 1, 30));
		welcome.setBackground(Color.red);
		panelNorth.add(welcome, JLabel.CENTER);
		
		this.setSize(new Dimension(700, 640));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void initRootWindow() {
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		this.setTitle("管理员");
		
		panelWest = new JPanel();
		panelWest.setBackground(Color.white);
		c.add(panelWest, "West");
		panelWest.setLayout(new GridLayout(2, 1));
		
		panelButton = new JPanel(new GridLayout(4, 1));
		panelWest.add(panelButton);
		labList = new JButton("实验室列表");
		applyList = new JButton("申请列表");
		JButton shenqijilu = new JButton("处理记录");
		exit = new JButton("退出");
		labList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				centerPanel.setVisible(false);
				centerPanel.removeAll();
				centerPanel.add(new LabList());
				centerPanel.setVisible(true);
			}
		});
		applyList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				centerPanel.setVisible(false);
				centerPanel.removeAll();
				centerPanel.add(new ApplyList());
				centerPanel.setVisible(true);
			}
		});
		shenqijilu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				centerPanel.setVisible(false);
				centerPanel.removeAll();
				centerPanel.add(new ApplyRecoder());
				centerPanel.setVisible(true);
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panelButton.add(labList);
		panelButton.add(applyList);
		panelButton.add(shenqijilu);
		panelButton.add(exit);
		
		centerPanel = new JPanel();
		JLabel cp1 = new JLabel();
		cp1.setSize(new Dimension(500, 300));
		centerPanel.add(cp1);
		JScrollPane jsp = new JScrollPane(centerPanel);
		c.add(jsp,"Center");
		
		panelSouth = new JPanel(new GridLayout(2, 1));
		panelSouth.setBackground(Color.GREEN);
		c.add(panelSouth, "South");
		panelSouth.add(new JLabel("XTU", JLabel.CENTER));
		panelSouth.add(new JLabel("Copyright 2019.", JLabel.CENTER));
		panelNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelNorth.setBackground(Color.YELLOW);
		c.add(panelNorth, "North");
		
		welcome = new JLabel("欢迎你，管理员");
		welcome.setFont(new Font("华文行楷", 1, 30));
		welcome.setBackground(Color.red);
		panelNorth.add(welcome, JLabel.CENTER);
		
		this.setSize(new Dimension(700, 640));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void initStuWindow() {
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		this.setTitle("学生");
		
		panelWest = new JPanel();
		panelWest.setBackground(Color.white);
		c.add(panelWest, "West");
		panelWest.setLayout(new GridLayout(2, 1));
		
		panelButton = new JPanel(new GridLayout(2, 1));
		panelWest.add(panelButton);
		labList = new JButton("我的课程");
		exit = new JButton("退出");
		labList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panelButton.add(labList);
		panelButton.add(exit);
		
		centerPanel = new JPanel();
		JLabel cp1 = new JLabel();
		cp1.setSize(new Dimension(500, 300));
		centerPanel.add(cp1);
		JScrollPane jsp = new JScrollPane(centerPanel);
		c.add(jsp,"Center");
		
		panelSouth = new JPanel(new GridLayout(2, 1));
		panelSouth.setBackground(Color.green);
		c.add(panelSouth, "South");
		panelSouth.add(new JLabel("XTU", JLabel.CENTER));
		panelSouth.add(new JLabel("Copyright 2019.", JLabel.CENTER));
		panelNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelNorth.setBackground(Color.YELLOW);
		c.add(panelNorth, "North");
		
		welcome = new JLabel("欢迎你，学生");
		welcome.setFont(new Font("华文行楷", 1, 30));
		welcome.setBackground(Color.red);
		panelNorth.add(welcome, JLabel.CENTER);
		
		this.setSize(new Dimension(700, 640));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
