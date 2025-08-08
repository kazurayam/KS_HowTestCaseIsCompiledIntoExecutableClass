package com.kazurayam.ks

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import com.kazurayam.groovy.CompilePhasesDiffer

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory

class TestCaseCompilePhasesDiffer {

	@Keyword
	static void report(String testCaseIdentification, Path classesDir, Path reportDir) {
		Objects.requireNonNull(testCaseIdentification)
		Objects.requireNonNull(classesDir)
		Objects.requireNonNull(reportDir)
		Files.createDirectories(classesDir)
		Files.createDirectories(reportDir)
		//
		TestCase tc = TestCaseFactory.findTestCase(testCaseIdentification)
		String testCaseRelativeId = TestCaseFactory.getTestCaseRelativeId(tc.getTestCaseId())
		Path scriptFile = Paths.get(tc.getGroovyScriptPath())
		String script = scriptFile.text
		CompilePhasesDiffer.report(testCaseRelativeId, script, classesDir, reportDir)
	}
}
