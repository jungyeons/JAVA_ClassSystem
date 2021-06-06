package windowsView;
import constants.Config.FVMainPanel;
import javax.swing.*;


public class VMainPanel extends JPanel {
	//attributes
	private static final long serialVersionUID = 1L;
	//components
	private VSugangsincheongPanel vSugangsincheong;
	
	public VSugangsincheongPanel getvSugangsincheong() {
        return vSugangsincheong;
    }

	public VMainPanel() {
		super();
		//attributes
		this.setBackground(FVMainPanel.background);
		this.setPreferredSize(FVMainPanel.size);
		//components
		this.vSugangsincheong = new VSugangsincheongPanel();
		this.add(this.vSugangsincheong);
	}

	public void initialize() {
		this.vSugangsincheong.initialize();
	}

}
