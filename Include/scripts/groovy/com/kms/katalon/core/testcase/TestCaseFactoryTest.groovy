package com.kms.katalon.core.testcase

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import com.kms.katalon.core.testcase.TestCaseFactory

/**
 * This class tests the methods of com.kms.katalon.core.testcase.TestCaseFactory class.
 * 
 * see https://api-docs.katalon.com/com/kms/katalon/core/testcase/TestCaseFactory.html
 */
@RunWith(JUnit4.class)
public class TestCaseFactoryTest {

	private static String testCaseId = 'Test Cases/Main Test Cases/TC1_Verify Successful Login'
	private static String testCaseRelativeId = 'Main Test Cases/TC1_Verify Successful Login'

	@Test
	void test_findTestCase() {
		def testCase = TestCaseFactory.findTestCase(testCaseRelativeId)
		assertNotNull(testCase)
		//
		assertEquals(testCaseId, testCase.getTestCaseId())
		//
		def testCase2 = TestCaseFactory.findTestCase(testCaseId)
		assertNotNull(testCase2)
	}

	@Test
	void test_getTestCaseId() {
		def result = TestCaseFactory.getTestCaseId(testCaseRelativeId)
		assertEquals(testCaseId, result)
	}

	@Test
	void test_getTestCaseRelativeId() {
		def result = TestCaseFactory.getTestCaseRelativeId(testCaseId)
		assertEquals(testCaseRelativeId, result)
	}
}
