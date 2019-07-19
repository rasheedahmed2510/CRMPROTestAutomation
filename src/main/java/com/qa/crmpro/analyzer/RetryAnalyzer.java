package com.qa.crmpro.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.qa.crmpro.testbase.testBase;

public class RetryAnalyzer extends testBase implements IRetryAnalyzer{
	
	int counter= 0;
	int retryLimit= 3;
	
	public boolean retry(ITestResult result) {
		if(counter < retryLimit){
			counter++;
			return true;
		}
		return false;	
	}

}
