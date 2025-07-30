package com.kazurayam.groovy

import org.junit.Test

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4.class)
class CompilePhasesDifferTest {

	@Test
	void testReport() {
		Path fixturesDir = Paths.get("./Scripts")
		String name = "Main Test Cases/TC0_start_login/Script1716414427652.groovy"
		String sourceCode = fixturesDir.resolve(name).text
		Path outDir = Paths.get("./build/tmp/testOutput/CompilePhasesDifferTest")
		Path report = CompilePhasesDiffer.report(name, sourceCode, outDir)
		assert Files.exists(report)
		assert report.getFileName().toString().startsWith("Main Test Cases")
	}
}
