package windowsView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import constants.Config.FVMainFrame;

public class VMainFrame extends JFrame {
	// attributes
	private static final long serialVersionUID = 1L;

	// components
	private TopButtonPanel topButtonPanel;
	private VMainPanel vMainPanel;

	public VMainFrame() {
		super();
		// attributes
		this.setSize(FVMainFrame.size);
		this.setLocation(FVMainFrame.location);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// components
		this.vMainPanel = new VMainPanel();
		this.add(this.vMainPanel);

		this.topButtonPanel = new TopButtonPanel(getInstance());
		topButtonPanel.setBackground(new Color(220, 220, 220));

		topButtonPanel.setLayout(new FlowLayout());
		this.add(topButtonPanel, BorderLayout.NORTH);

	}

	public VMainFrame getInstance() {
		return this;
	}

	public TopButtonPanel getTopButtonPanel() {
		return this.topButtonPanel;
	}

	public VMainPanel getvMainPanel() {
		return vMainPanel;
	}

	public void initialize() {
		// variable attributes

		// components initialize
		this.vMainPanel.initialize();
	}

	public static void main(String[] args) {
		VMainFrame vMain = new VMainFrame();
		vMain.initialize();
		vMain.setVisible(true);
	}

}
