package com.skycloud.refactor.observer.latest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
import junit.framework.TestResult;

//实现观察者接口
public class ConsoleRunner implements TestListener {

	private TestResult fTestResult;

	private Vector fExceptions;

	private Vector fFailedTests;

	private List fFailureList;

	public ConsoleRunner() {
		fExceptions = new Vector();
		fFailedTests = new Vector();
		fFailureList = new ArrayList();
	}

	public void endTest1(Test test) {
		System.out.println(" 测试结束： ");
		String message = test.toString();
		if (fTestResult.wasSuccessful())
			System.out.println(message + "  测试成功! ");
		else if (fTestResult.errorCount() == 1)
			System.out.println(message + "  had an error ");
		else
			System.out.println(message + "  had a failure ");

		for (int i = 0; i < fFailureList.size(); i++) {
			System.out.println(fFailureList.get(i));
		}
		for (int i = 0; i < fFailedTests.size(); i++) {
			System.out.println(fFailureList.get(i));
		}
		for (int i = 0; i < fExceptions.size(); i++) {
			System.out.println(fFailureList.get(i));
		}

		System.out.println(" ------------------------ ");
	}

	public void startTest1(Test test) {
		System.out.println(" 开始测试: " + test);
	}

	public static TestResult createTestResult() {
		return new TestResult();
	}

	private String truncateString(String s, int length) {
		if (s.length() > length)
			s = s.substring(0, length) + "  ";
		return s;
	}

	public void addError1(Test test, Throwable t) {
		System.out.println(fTestResult.errorCount());
		appendFailure(" Error ", test, t);
	}

	public void addFailure1(Test test, AssertionFailedError t) {
		System.out.println(fTestResult.failureCount());
		appendFailure(" Failure ", test, t);
	}

	private void appendFailure(String kind, Test test, Throwable t) {
		kind += " :  " + test;
		String msg = t.getMessage();
		if (msg != null) {
			kind += " : " + truncateString(msg, 100);
		}
		fFailureList.add(kind);
		fExceptions.addElement(t);
		fFailedTests.addElement(test);
	}

	public void go(String args[]) {
		Method[] methods = SimpleTest.class.getDeclaredMethods();

		for (int i = 0; i < methods.length; i++) {
			// 取所有以test开头的方法
			if (methods[i].getName().startsWith("test")) {
				Test test = (Test) new SimpleTest();
				fTestResult = createTestResult();
				fTestResult.addListener(ConsoleRunner.this);
				// 执行测试
				test.run(fTestResult);
			}
		}
	}

	public static void main(String args[]) {
		new ConsoleRunner().go(args);
	}

	@Override
	public void addError(Test test, Throwable e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFailure(Test test, AssertionFailedError e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endTest(Test test) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startTest(Test test) {
		// TODO Auto-generated method stub
		
	}

}
