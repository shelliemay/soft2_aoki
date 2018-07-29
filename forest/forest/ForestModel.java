package forest;

import java.awt.event.MouseEvent;
import java.awt.Point;
import java.io.IOException;
import java.io.File;
import java.util.HashMap;
import mvc.Model;

/**
* フォレストモデル。
*/
public class ForestModel extends Model
{
  /**
  * ForestクラスのインスタンスaForestを束縛する。
  */
  private Forest aForest;

  /**
  * 木データaForestインスタンスからフォレストモデルを作るコンストラクタ。
  * @param textFileName 木データであるテキストのファイル名
  */
  public ForestModel(File aFile)
  {
    super();
    this.aForest = new Forest();
    this.aForest.setModel(this);
    try
    {
      this.aForest.readText(aFile);
    }
    catch(IOException anException)
    {
      anException.printStackTrace();
    }
    aForest.setRoot();

    int y=0;
    HashMap<Integer,Node> nodes = this.getForest().getNodes();
    for (Node aNode : nodes.values())
    {
      aNode.setLocation(0,y);
      y += aNode.getSize().height+Const.VERTICAL_GAP;
    }
  }

  /**
  * Forestを応答する。
  * @return Forest型のインスタンス
  */
  public Forest getForest()
  {
    return this.aForest;
  }

  /**
  * マウスクリックした位置を座標として受け取り、その位置にNodeがあれば出力
  * @param aPoint ピクチャ座標
  * @param aMouseEvent マウスのイベント
  */
  public void mouseClicked(Point aPoint, MouseEvent aMouseEvent)
  {
    HashMap<Integer,Node> nodes = aForest.getNodes();
    for (Node node : nodes.values()) {
      if(node.getLocation().x <= aPoint.x && node.getLocation().x+node.getWidth() >= aPoint.x)
      {
        if(node.getLocation().y <= aPoint.y && node.getLocation().y+node.getHeight() >= aPoint.y)
        {
          System.out.println(node.getName());
        }
      }
    }
    return;
  }
}
