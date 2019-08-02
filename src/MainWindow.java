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
		
		this.setTitle("��ʦ");
		
		panelWest = new JPanel();
		panelWest.setBackground(Color.white);
		c.add(panelWest, "West");
		panelWest.setLayout(new GridLayout(2, 1));
		
		panelButton = new JPanel(new GridLayout(4, 1));
		panelWest.add(panelButton);
		labList = new JButton("ʵ�����б�");
		applyList = new JButton("����ʵ����");
		exit = new JButton("�˳�");
		JButton stutus = new JButton("����״̬");
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
		
		welcome = new JLabel("��ӭ�㣬��ʦ");
		welcome.setFont(new Font("�����п�", 1, 30));
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
		
		this.setTitle("����Ա");
		
		panelWest = new JPanel();
		panelWest.setBackground(Color.white);
		c.add(panelWest, "West");
		panelWest.setLayout(new GridLayout(2, 1));
		
		panelButton = new JPanel(new GridLayout(4, 1));
		panelWest.add(panelButton);
		labList = new JButton("ʵ�����б�");
		applyList = new JButton("�����б�");
		JButton shenqijilu = new JButton("�����¼");
		exit = new JButton("�˳�");
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
		
		welcome = new JLabel("��ӭ�㣬����Ա");
		welcome.setFont(new Font("�����п�", 1, 30));
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
		
		this.setTitle("ѧ��");
		
		panelWest = new JPanel();
		panelWest.setBackground(Color.white);
		c.add(panelWest, "West");
		panelWest.setLayout(new GridLayout(2, 1));
		
		panelButton = new JPanel(new GridLayout(2, 1));
		panelWest.add(panelButton);
		labList = new JButton("�ҵĿγ�");
		exit = new JButton("�˳�");
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
		
		welcome = new JLabel("��ӭ�㣬ѧ��");
		welcome.setFont(new Font("�����п�", 1, 30));
		welcome.setBackground(Color.red);
		panelNorth.add(welcome, JLabel.CENTER);
		
		this.setSize(new Dimension(700, 640));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
