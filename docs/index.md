# \[Katalon Studio\] How a Test Case Groovy script is compiled into an executable class file

## Problem to solve

Here is a sample Test Case script (\*.groovy) of Katalon Studio:

    import com.kms.katalon.core.testobject.ConditionType
    import com.kms.katalon.core.testobject.TestObject
    import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
    import org.openqa.selenium.WebElement

    TestObject makeTestObject(String selector) {
        return makeTestObject(selector, selector)
    }

    TestObject makeTestObject(String id, String cssSelector) {
        TestObject tObj = new TestObject(id)
        tObj.addProperty('css', ConditionType.EQUALS, cssSelector)
        return tObj 
    }

    System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox")
    String url = 'http://demoaut.katalon.com'
    String anchorMakeAppointment = "a[id *= 'btn-make-appointment']"

    WebUI.openBrowser(url)
    WebUI.waitForElementPresent(makeTestObject(anchorMakeAppointment), 10)

    //WebUI.click(makeTestObject(anchorMakeAppointment))
    String js = "document.querySelector(\"${anchorMakeAppointment}\").click();"
    WebUI.comment(js)
    WebUI.executeJavaScript(js, null);

    WebUI.verifyElementPresent(makeTestObject("input[id *= 'txt-username'"), 10)
    WebUI.delay(3)
    WebUI.closeBrowser()

I can run this script in Katalon Studio, of course. I am quote used to it.

But I am curious about how this script is compiled into an executable JVM `class` file. I want to know the details of the compilation process.

## How the executable class look like

In short, the following groovy source code presents how the binary `*.class` file that Groovy Compiler generates from the above script.

    import com.kms.katalon.core.testobject.ConditionType as ConditionType
    import com.kms.katalon.core.testobject.TestObject as TestObject
    import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
    import org.openqa.selenium.WebElement as WebElement

    java.lang.System.setProperty('webdriver.firefox.bin', '/Applications/Firefox.app/Contents/MacOS/firefox')
    java.lang.String url = 'http://demoaut.katalon.com'
    java.lang.String anchorMakeAppointment = 'a[id *= \'btn-make-appointment\']'
    com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.openBrowser(url)
    com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.waitForElementPresent(this.makeTestObject(anchorMakeAppointment), 10)
    java.lang.String js = "document.querySelector("$anchorMakeAppointment").click();"
    com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.comment(js)
    com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.executeJavaScript(js, null)
    com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.verifyElementPresent(this.makeTestObject('input[id *= \'txt-username\''), 10)
    com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.delay(3)
    return com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.closeBrowser()
    public class script1754649792791 extends groovy.lang.Script { 

        private static org.codehaus.groovy.reflection.ClassInfo $staticClassInfo 
        public static transient boolean __$stMC 

        public script1754649792791() {
        }

        public script1754649792791(final groovy.lang.Binding context) {
            super(context)
        }

        public static void main(final java.lang.String[] args) {
            org.codehaus.groovy.runtime.InvokerHelper.runScript(script1754649792791, args)
        }

        public java.lang.Object run() {
            java.lang.System.setProperty('webdriver.firefox.bin', '/Applications/Firefox.app/Contents/MacOS/firefox')
            java.lang.String url = 'http://demoaut.katalon.com'
            java.lang.String anchorMakeAppointment = 'a[id *= \'btn-make-appointment\']'
            com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.openBrowser(url)
            com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.waitForElementPresent(this.makeTestObject(anchorMakeAppointment), 10)
            java.lang.String js = "document.querySelector("$anchorMakeAppointment").click();"
            com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.comment(js)
            com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.executeJavaScript(js, null)
            com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.verifyElementPresent(this.makeTestObject('input[id *= \'txt-username\''), 10)
            com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.delay(3)
            return com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.closeBrowser()
        }

        public com.kms.katalon.core.testobject.TestObject makeTestObject(java.lang.String selector) {
            return this.makeTestObject(selector, selector)
        }

        public com.kms.katalon.core.testobject.TestObject makeTestObject(java.lang.String id, java.lang.String cssSelector) {
            com.kms.katalon.core.testobject.TestObject tObj = new com.kms.katalon.core.testobject.TestObject(id)
            tObj.addProperty('css', com.kms.katalon.core.testobject.ConditionType.EQUALS, cssSelector)
            return tObj 
        }

        protected groovy.lang.MetaClass $getStaticMetaClass() {
        }

    }

What do I find in this souce code interesting?

1.  The resulting groovy source code has a complete `class` definition, which implements `void main()` method and `void runScript()` method.

2.  The `main()` method is obviously the entry point of the executable class. The `main()` method calls `runScript()` method.

3.  The `runScript()` method contains the original set of Groovy statements.

4.  And also in front of the `class` definition, I can find the original set of Groovy statements. It is obvious that the statements in from of the `class` definistion will never be executed by the `main()` method of the `class`. To me the statements outside the `class` definition look like a ruin forgotten.

Other point of interest is the way how the `makeTestObject()` function is treated. The `makeTestObject()` is originally defined as a function in the Test Case script. The resulting `class` implements `private TestObject makeTestObject()` function. This transformation looks quite understandable to me.

## How to run the demo

Open `Test Cases/junit/com.kazurayam.ks/TestCaseCompilePhasesDifferTestRunner` in Katalon Studio, and run it.

You will see the following output in the `build/tmp/testOutput/` directory:

    $ tree .
    .
    └── TestCaseCompilePhasesDifferTest
        ├── classes
        │   └── Main_TC0_start_login.class
        └── report
            ├── Main_TC0_start_login-1_INITIALIZATION.groovy
            ├── Main_TC0_start_login-2_PARSING.groovy
            ├── Main_TC0_start_login-3_CONVERSION.groovy
            ├── Main_TC0_start_login-4_SEMANTIC_ANALYSIS.groovy
            ├── Main_TC0_start_login-5_CANONICALIZATION.groovy
            ├── Main_TC0_start_login-6_INSTRUCTION_SELECTION.groovy
            ├── Main_TC0_start_login-7_CLASS_GENERATION.groovy
            ├── Main_TC0_start_login-8_OUTPUT.groovy
            ├── Main_TC0_start_login-9_FINALIZATION.groovy
            └── Main_TC0_start_login-CompilePhasesDiff.md

You can open the `Main_TC0_start_login-9_FINALIZATION.groovy` file in Katalon Studio, and you will see the rebuilt source code of the executable class.

The `Main_TC0_start_login-CompilePhasesDiff.md` file contains the diff report of the original script and the rebuilt source code. Katalon Studio does not provide "Markdown Viewer". You should use Visual Studio Code or any other Markdown viewer to read the diff report.

## How the demo is designed

How did I get this script? --- I used a Groovy class that I developed externally.

-   [GoovyCompilePhasesDiffer](https://github.com/kazurayam/GroovyCompilePhasesDiffer)

You need to download 2 jar files and place them in the `Drivers` folder.

-   [java-diff-utils](https://mvnrepository.com/artifact/io.github.java-diff-utils/java-diff-utils/4.16)

-   [groovy-compile-phases-differ](https://github.com/kazurayam/GroovyCompilePhasesDiffer/releases/tag/untagged-08d7fdce06c7a67b200e)
