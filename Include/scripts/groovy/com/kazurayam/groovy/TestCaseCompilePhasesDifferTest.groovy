package com.kazurayam.groovy

import com.kms.katalon.core.configuration.RunConfiguration

import org.junit.Test

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4.class)
public class TestCaseCompilePhasesDifferTest {

	Path projectDir = Paths.get(RunConfiguration.getProjectDir())

	@Test
	void test_TC0() {
		Path outDir = projectDir.resolve("build/tmp/testOutput/TestCaseCompilePhasesDifferTest")
		TestCaseCompilePhasesDiffer.report("Main Test Cases/TC0_start_login", outDir)
	}
}

