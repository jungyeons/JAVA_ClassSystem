package windowsView;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import control.CLecture;
import valueObject.OLecture;

public class VGangjwa extends JTable {
	private static final long serialVersionUID = 1L;
	
	//associations
	private CLecture cLecture;
    private DefaultTableModel model;
    
	public VGangjwa() {
		super();
		// attributes
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// components
		this.model = (DefaultTableModel) this.getModel();
		model.addColumn("강좌명");
		model.addColumn("강사명");
		model.addColumn("시간");
		// associations
	}

	public void initialize() {
		this.model.setNumRows(0);	
	}   
	
	public void getData(String fileName) {
		this.cLecture = new CLecture();
		 Vector<OLecture> oLectures = this.cLecture.readAll(fileName);
		 		
		 
		 String [] row = new String[model.getColumnCount()];
		 for(OLecture oLecture: oLectures) {
			 row[0] = oLecture.getName();
			 row[1] = oLecture.getProfessor();
		     row[2] = oLecture.getNumber();
		     model.addRow(row);
		 }
		 this.updateUI();
	}
	public void addRow(String fileName) {
		this.cLecture = new CLecture();
		 Vector<OLecture> oLectures = this.cLecture.readAll(fileName);
		 		
		 
		 String [] row = new String[model.getColumnCount()];
		 for(OLecture oLecture: oLectures) {
			 row[0] = oLecture.getName();
			 row[1] = oLecture.getProfessor();
		     row[2] = oLecture.getNumber();
		     model.addRow(row);
		 }
		 this.updateUI();
	}
}
