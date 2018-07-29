package forest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
* 例題プログラム。
*/
public class Example extends Object
{
	/**
	* ファイルをセットし、ユーザにファイル選択を要求し、選択されたテキストファイルをモデルへと渡し、MVCの各インスタンスを生成する。その後フレームを生成し、MVCを乗せる。そして、樹上整列するアニメーションを開始する。
	*/
	public static void main(String[] arguments) throws IOException
	{
		FileSelectFrame aFrame = new FileSelectFrame();
		File aFile = null;
		aFrame.setLocation(0,0);

		while(aFile == null){
			aFile = aFrame.getFile();
			System.out.print("");
		}

		ForestModel aModel = new ForestModel(aFile);
		ForestView aView = new ForestView(aModel,new ForestController());

		JFrame aWindow = new JFrame("Forest");
		aWindow.getContentPane().add(aView);
		aWindow.setLayout(null);
		aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int titleBarHeight = aWindow.getInsets().top;
		aWindow.getContentPane().setBackground(new Color(255,255,255));
		Point aPoint = new Point(Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
		aWindow.setMinimumSize(new Dimension(aPoint.x, aPoint.y + titleBarHeight));
		aWindow.setResizable(true);
		aWindow.setSize(aPoint.x, aPoint.y + titleBarHeight);
		aWindow.setLocation(0, 0);
		aWindow.setVisible(true);
		aWindow.toFront();

		ArrayList<Node> roots = aModel.getForest().getRoot();
		for(Node node : roots)
		{
			aModel.getForest().visit(node, new Point(0,Forest.underLine) );
		}

		return;
	}
}
