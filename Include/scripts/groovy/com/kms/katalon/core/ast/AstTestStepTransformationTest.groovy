package com.kms.katalon.core.ast

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static org.junit.Assert.assertNotNull

import java.nio.file.Path
import java.nio.file.Paths

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.control.CompilePhase
import org.junit.Before
import org.junit.Test

import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.ast.AstTestStepTransformation
import org.codehaus.groovy.ast.GroovyCodeVisitor

class AstTestStepTransformationTest {

	List<ASTNode> ast

	@Before
	void setup() {
		TestCase tc = findTestCase("Test Cases/visitGoogle")
		Path scriptPath = Paths.get(tc.getGroovyScriptPath())
		String code = scriptPath.toFile().text
		ast = new AstBuilder().buildFromString(CompilePhase.CONVERSION, false, code)
	}

	@Test
	void test_ast_isNotNull() {
		assertNotNull("the ast property must not be null", ast)
	}

	@Test
	void test_visitScriptCode() {
		def visitor = new AstTestStepTransformation()
		ast[0].visit(visitor, null)
	}
}
