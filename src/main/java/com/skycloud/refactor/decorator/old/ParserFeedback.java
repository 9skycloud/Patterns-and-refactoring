package com.skycloud.refactor.decorator.old;

import org.htmlparser.util.ParserException;

public interface ParserFeedback
{
  public void info(String message);
  public void warning(String message);
  public void error(String message, ParserException e);
}
