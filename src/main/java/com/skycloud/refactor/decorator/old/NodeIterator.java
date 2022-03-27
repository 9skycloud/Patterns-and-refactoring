package com.skycloud.refactor.decorator.old;

import org.htmlparser.Node;
import org.htmlparser.util.ParserException;

public interface NodeIterator {
    /**
     * Check if more nodes are available.
     * @return <code>true</code> if a call to <code>nextHTMLNode()</code> will succeed.
     */
    public boolean hasMoreNodes() throws ParserException;

    /**
     * Get the next node.
     * @return The next node in the HTML stream, or null if there are no more nodes.
     */
    public Node nextNode() throws ParserException;

}
