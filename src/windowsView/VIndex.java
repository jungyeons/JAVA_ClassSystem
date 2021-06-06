package windowsView;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import control.CIndex;
import valueObject.OIndex;

public class VIndex extends JTable {
	private static final long serialVersionUID = 1L;
	
	//associations
	private CIndex cIndex;
    private DefaultTableModel model;
    
    public VIndex(String title) {
        super();
        // attributes
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // components
        this.model = (DefaultTableModel) this.getModel();
        model.addColumn(title);
        // associations
    }
	

	public void initialize() {
		this.model.setNumRows(0);	
	}   
	
	public void getData(String fileName) {
        // 행을 추가함
        this.addRow(fileName);
    }
	public void addRow(String fileName) {
		this.cIndex = new CIndex();
		 Vector<OIndex> oIndices = this.cIndex.getAll(fileName);
		 		
		 
		 String [] row = new String[model.getColumnCount()];
		 for(OIndex oIndex: oIndices) {
			 row[0] = oIndex.getFileName();
		     model.addRow(row);
		 }
		 this.updateUI();
	}
}
