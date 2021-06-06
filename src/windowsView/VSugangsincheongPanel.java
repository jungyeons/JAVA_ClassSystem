package windowsView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.*;

public class VSugangsincheongPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;
	// components

	private VGangjwaSelectionPanel vGangjwaSelectionPanel;
	private VGangjwa vMiridamgi;
	private VGangjwa vSincheong;

	public VSugangsincheongPanel() {
		super();
		// attributes
		// components
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);
		
		this.vGangjwaSelectionPanel = new VGangjwaSelectionPanel();
		this.add(this.vGangjwaSelectionPanel,BorderLayout.WEST);
		
		
		JPanel miriSincheongPanel = new JPanel();
		layoutManager = new BoxLayout(miriSincheongPanel, BoxLayout.Y_AXIS);
		miriSincheongPanel.setLayout(layoutManager);
		
		
		    JScrollPane scrollPane;
		    this.vMiridamgi = new VGangjwa();
		    scrollPane = new JScrollPane(this.vMiridamgi);
		    scrollPane.setPreferredSize(new Dimension(300, 90));
		    miriSincheongPanel.add(scrollPane);

		    this.vSincheong = new VGangjwa();
		    scrollPane = new JScrollPane(this.vSincheong);
		    scrollPane.setPreferredSize(new Dimension(300, 90));
		    miriSincheongPanel.add(scrollPane);
		    
	    this.add(miriSincheongPanel,BorderLayout.EAST);
    }
	

	public VGangjwa getvMiridamgi() {
		return vMiridamgi;
	}


	public void setvMiridamgi(VGangjwa vMiridamgi) {
		this.vMiridamgi = vMiridamgi;
	}


	public VGangjwa getvSincheong() {
		return vSincheong;
	}


	public void setvSincheong(VGangjwa vSincheong) {
		this.vSincheong = vSincheong;
	}


	public void initialize() {
		this.vGangjwaSelectionPanel.initialize();
		this.vGangjwaSelectionPanel.getData("root");

		this.vMiridamgi.initialize();
		
	    this.vSincheong.initialize();
		
	}
}
