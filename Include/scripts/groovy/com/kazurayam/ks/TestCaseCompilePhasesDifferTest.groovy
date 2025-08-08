package com.kazurayam.ks

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
		Path classesDir = projectDir.resolve("build/tmp/testOutput/TestCaseCompilePhasesDifferTest/classes")
		Path reportDir = projectDir.resolve("build/tmp/testOutput/TestCaseCompilePhasesDifferTest/report")
		TestCaseCompilePhasesDiffer.report("Main/TC0_start_login", classesDir, reportDir)
	}
}
