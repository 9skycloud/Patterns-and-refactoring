package com.skycloud.refactor.decorator.old;

import java.io.Serializable;

import org.htmlparser.NodeFilter;
import org.htmlparser.lexer.Page;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;
import org.htmlparser.visitors.NodeVisitor;

/**
 * The concrete base class for all types of nodes (tags, text remarks).
 * This class provides basic functionality to hold the {@link Page}, the
 * starting and ending position in the page, the parent and the list of
 * {@link NodeList children}.
 */
public abstract class AbstractNode implements Node, Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected StringBuffer mPage;

    protected int nodeBegin;

    protected int nodeEnd;

    protected Node parent;

    protected NodeList children;

    public Object clone() throws CloneNotSupportedException
    {
        return (super.clone ());
    }

    public abstract String toPlainTextString ();

    public String toHtml ()
    {
        return (toHtml (false));
    }

    public abstract String toHtml (boolean verbatim);

    public abstract String toString ();

    public void collectInto (NodeList list, NodeFilter filter)
    {
        if (filter.accept ((org.htmlparser.Node) this))
            list.add ((org.htmlparser.Node) this);
    }

    public int getStartPosition ()
    {
        return (nodeBegin);
    }

    public void setStartPosition (int position)
    {
        nodeBegin = position;
    }

    public int getEndPosition ()
    {
        return (nodeEnd);
    }

    public void setEndPosition (int position)
    {
        nodeEnd = position;
    }

    public abstract void accept (NodeVisitor visitor);

    public Node getParent ()
    {
        return (parent);
    }

    public void setParent (Node node)
    {
      if(this != node){
        parent = node;
      }        
    }

    public NodeList getChildren ()
    {
        return (children);
    }

    public void setChildren (NodeList children)
    {
      /* Always Initialize the children field as in the constructor its being
       * initialized to null
       */
      this.children = new NodeList();
      /* Do nothing if the children node list contains the node
       * (i.e. the node whose children is being set) itself
       */
      for(SimpleNodeIterator  it = children.elements(); it.hasMoreNodes();){
        Node nodetoadd = (Node) it.nextNode();
        if(this != nodetoadd){
          this.children.add((org.htmlparser.Node) nodetoadd);
        }
      }
      //this.children = children;
    }
    
    public Node getFirstChild ()
    {
        if (children == null)
            return null;
        if (children.size() == 0)
            return null;
        return (Node) children.elementAt(0);
    }
    
    public Node getLastChild ()
    {
        if (children == null)
            return null;
        int numChildren = children.size();
        if (numChildren == 0)
            return null;
        return (Node) children.elementAt(numChildren - 1);
    }
    
    public Node getPreviousSibling ()
    {
        Node parentNode = this.getParent();
        if (parentNode == null)//root node
            return null;
        NodeList siblings = parentNode.getChildren();
        if (siblings == null)//this should actually be an error
            return null;
        int numSiblings = siblings.size();
        if (numSiblings < 2)//need at least one other node to have a chance of having any siblings
            return null;
        int positionInParent = -1;
        for (int i = 0; i < numSiblings; i++)
        {
            if (siblings.elementAt(i) == this)
            {
                positionInParent = i;
                break;
            }
        }
        if (positionInParent < 1)//no previous siblings
            return null;
        return (Node) siblings.elementAt(positionInParent - 1);
    }
    
    public Node getNextSibling ()
    {
        Node parentNode = this.getParent();
        if (parentNode == null)//root node
            return null;
        NodeList siblings = parentNode.getChildren();
        if (siblings == null)//this should actually be an error
            return null;
        int numSiblings = siblings.size();
        if (numSiblings < 2)//need at least one other node to have a chance of having any siblings
            return null;
        int positionInParent = -1;
        for (int i = 0; i < numSiblings; i++)
        {
            if (siblings.elementAt(i) == this)
            {
                positionInParent = i;
                break;
            }
        }
        if (positionInParent == -1)//this should actually be an error
            return null;
        if (positionInParent == (numSiblings - 1))//no next sibling
            return null;
        return (Node) siblings.elementAt(positionInParent + 1);
    }

    public String getText ()
    {
        return null;
    }

    public void setText(String text)
    {
    }

    public void doSemanticAction ()
        throws
            ParserException
    {
    }
}
