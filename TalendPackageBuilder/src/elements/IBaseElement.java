package elements;

import java.util.Collection;

import objects.ColumnObject;
import objects.IColumnObject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import xmlelements.INode;

public interface IBaseElement extends INode{
	
	public Node getMetadata (Node node);
//	public Node connectToNode (Node node, Node target, EConnectionTypes type);
	public NodeList getIncomingConnections (Node node);
	public NodeList getOutgoingConnections (Node node);
	public Node getConnection (Node node, Node target);
	public Node createMetadata (Node node);
	public Element createMetadataColumnDummy();
	public boolean hasAttribute (Node node, String attName);
	public void addAttribute (Node node, String name);
	
	
	public Collection <IColumnObject> extractMetadata (Node metaData);
	public Element setMetadataColumnFromObject(IColumnObject column, Node metadata);
	public void setWholeMetadataFromObject (Collection<IColumnObject> columns, Node metadata);

}
