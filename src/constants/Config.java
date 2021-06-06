package constants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public final class Config {
	public static class FVMainFrame {
		public static final Point location = new Point(200,300);
		public static final Dimension size = new Dimension(800,600);
	}
	public static class FVMainPanel {
		public static final Color background = Color.WHITE;
		public static final Dimension size = new Dimension(600,400);
	}

}
