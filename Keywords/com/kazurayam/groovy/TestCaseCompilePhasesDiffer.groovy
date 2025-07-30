package com.kazurayam.groovy

import java.nio.file.Path
import java.nio.file.Paths

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory

class TestCaseCompilePhasesDiffer {

	@Keyword
	static void report(String testCaseIdentification, Path outDir) {
		Objects.requireNonNull(testCaseIdentification)
		TestCase tc = TestCaseFactory.findTestCase(testCaseIdentification)
		String testCaseRelativeId = TestCaseFactory.getTestCaseRelativeId(tc.getTestCaseId())
		Path scriptFile = Paths.get(tc.getGroovyScriptPath())
		String script = scriptFile.text
		CompilePhasesDiffer.report(testCaseRelativeId, script, outDir)
	}
}
