package view.prikaz_unapredjivanje;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;


@SuppressWarnings("serial")
public abstract class AbstractDialog extends JDialog {
	
	protected JFrame parent;
	protected JTable table;
	protected KorisniciTableModel tableModel;
	protected String[] columns;
	protected ListSelectionListener tableSelectionListener;
	protected JPanel panDetail;
	
	public AbstractDialog(JFrame parent, String title) {
		super(parent,title,true);
		this.parent = parent;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension((int)parent.getSize().getWidth()*3/4,(int)parent.getSize().getHeight()*3/4));
		setLocationRelativeTo(parent);
	}
	
	public void initGUI() {
		
		/*Kreiranje tabele*/
		table = new JTable(tableModel);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS),
				panDetail);
		splitPane.setResizeWeight(1.0);

		add(splitPane,BorderLayout.CENTER);
	}
	
	public JTable getTable() {
		return table;
	}
	
	public JPanel getPanDetail() {
		return panDetail;
	}

}
