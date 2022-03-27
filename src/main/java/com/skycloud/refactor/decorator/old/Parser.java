package com.skycloud.refactor.decorator.old;

import org.htmlparser.lexer.Lexer;
import org.htmlparser.util.IteratorImpl;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.ParserFeedback;

public class Parser {
	/**
     * Feedback object.
     */
    protected ParserFeedback mFeedback;

    /**
     * The html lexer associated with this parser.
     */
    protected Lexer mLexer;
	
	  private boolean shouldDecodeNodes = false;
	  private boolean shouldRemoveEscapeCharacters = false;

	  public void setShouldDecoding(boolean shouldDecodeNodes) {
	    this.shouldDecodeNodes = shouldDecodeNodes;
	  }

	  public void setShouldRemoveEscapeCharacters(boolean shouldRemoveEscapeCharacters){
	      this.shouldRemoveEscapeCharacters = shouldRemoveEscapeCharacters;
	  }

	  public boolean shouldRemoveEscapeCharacters(){
	      return this.shouldRemoveEscapeCharacters;
	  }

	  /**
	   * shouldDecodeNodes
	   */
	  public boolean shouldDecodeNodes() {
	    return this.shouldDecodeNodes;
	  }

	  /**
	   * createParser
	   */
	  public static Parser createParser() {
		return null;
	  }

	  public void setNodeDecoding() {}

	/**
	 * elements
	 */
	  public NodeIterator elements () throws ParserException
	    {
	        return (new IteratorImpl (getLexer (), getFeedback ()));
	    }
	  
	  /**
	     * Returns the lexer associated with the parser.
	     * @return The current lexer.
	     * @see #setLexer
	     */
	    public Lexer getLexer ()
	    {
	        return (mLexer);
	    }
	    
	    /**
	     * Returns the current feedback object.
	     * @return The feedback object currently being used.
	     * @see #setFeedback
	     */
	    public ParserFeedback getFeedback()
	    {
	        return (mFeedback);
	    }
}
