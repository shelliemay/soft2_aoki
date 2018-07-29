package forest;

/*
 * Branchクラス
 */
public class Branch extends Object
{
    /**
     * 枝にくっついている親ノードをインスタンスとして束縛する。
     */
    private Node startNode;

    /**
     * 枝にくっついている子ノードをインスタンスとして束縛する。
     */
    private Node endNode;

    /**
     * インスタンスを生成して応答する。
     * 引数に親Node,子Nodeを指定し、フィールドに設定する
     * @param startNode 親Node
     * @param endNode 子Node
     */
    Branch(Node startNode, Node endNode)
    {
        this.startNode = startNode;
        this.endNode = endNode;
    }

    /**
     * 親ノードを応答する。
     * @return 親ノード
     */
    public Node getStartNode()
    {
        return this.startNode;
    }

    /**
     * 子ノードを応答する。
     * @return 子ノード
     */
    public Node getEndNode()
    {
        return this.endNode;
    }
}
