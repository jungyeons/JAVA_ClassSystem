package windowsView;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class VGangjwaSelectionPanel extends JPanel {

    // attributes
    private static final long serialVersionUID = 1L;

    // components
    private VIndex vCampus;
    private VIndex vCollege;
    private VIndex vHakgwa;
    private VGangjwa vGangjwa;

    public VGangjwaSelectionPanel() {
        super(); 
        // attributes
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // components
        JScrollPane scrollpane;

        // 4개 각각 select
        this.vCampus = new VIndex("캠퍼스");
        vCampus.addMouseListener(new MyMouseAdapter());
        scrollpane = new JScrollPane(this.vCampus);
        scrollpane.setPreferredSize(new Dimension(150,42));
        this.add(scrollpane);

        this.vCollege = new VIndex("대학");
        vCollege.addMouseListener(new MyMouseAdapter());
        scrollpane = new JScrollPane(this.vCollege);
        scrollpane.setPreferredSize(new Dimension(150,42));
        this.add(scrollpane);

        this.vHakgwa = new VIndex("학과");
        vHakgwa.addMouseListener(new MyMouseAdapter());
        scrollpane = new JScrollPane(this.vHakgwa);
        scrollpane.setPreferredSize(new Dimension(150,42));
        this.add(scrollpane);
        
		this.vGangjwa = new VGangjwa();
		vGangjwa.addMouseListener(new MyMouseAdapter());
		scrollpane = new JScrollPane(this.vGangjwa);
		scrollpane.setPreferredSize(new Dimension(300,90));
		this.add(scrollpane);

       
    }

	public void initialize() {
		this.vCampus.initialize();
		this.vCollege.initialize();
		this.vHakgwa.initialize();
		this.vGangjwa.initialize();
	}

	
	public void getData(String fileName) {
        this.vCampus.getData(fileName);
    }
	private class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            JTable jTable = (JTable) e.getSource();
            int row = jTable.rowAtPoint(e.getPoint());
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            String filename = (String) model.getValueAt(row, 0);
            System.out.println(filename);

			if (jTable == vCampus) {
				vCollege.initialize();
				vHakgwa.initialize();
				vGangjwa.initialize();
				vCollege.addRow(filename);
			} else if (jTable == vCollege) {
				vHakgwa.initialize();
				vGangjwa.initialize();
				vHakgwa.addRow(filename);
			} else if (jTable == vHakgwa) {
				vGangjwa.initialize();
				vGangjwa.addRow(filename);
			}
		}
    }
}