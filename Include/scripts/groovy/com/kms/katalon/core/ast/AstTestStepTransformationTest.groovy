package com.kms.katalon.core.ast

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static org.junit.Assert.assertNotNull

import java.nio.file.Path
import java.nio.file.Paths

import org.codehaus.groovy.ast.ModuleNode
import org.codehaus.groovy.control.SourceUnit
import org.junit.Before
import org.junit.Test

import com.kms.katalon.core.testcase.TestCase

class AstTestStepTransformationTest {
	
	ModuleNode ast
	
	@Before
	void setup() {
		TestCase tc = findTestCase("Test Cases/Main Test Cases/TC0_start_login")
		Path sourcePath = Paths.get(tc.getGroovyScriptPath())
		String code = sourcePath.toFile().text
		SourceUnit sourceUnit = SourceUnit.create("TC0_start_login", code)
		sourceUnit.parse()          // source -> CST
		sourceUnit.completePhase()  // mark compilation finished
		sourceUnit.convert()        // CST -> AST
		ast = sourceUnit.getAST()
	}
	
	@Test
	void test_ast_isNotNull() {
		assertNotNull("the ast property must not be null", ast)
	}	
	
}
