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
com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.closeBrowser()
public class script1754649792254 extends groovy.lang.Script { 

    public script1754649792254() {
    }

    public script1754649792254(final groovy.lang.Binding context) {
        super(context)
    }

    public static void main(final java.lang.String[] args) {
        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1754649792254, args)
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
        com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.closeBrowser()
    }

    public com.kms.katalon.core.testobject.TestObject makeTestObject(java.lang.String selector) {
        return this.makeTestObject(selector, selector)
    }

    public com.kms.katalon.core.testobject.TestObject makeTestObject(java.lang.String id, java.lang.String cssSelector) {
        com.kms.katalon.core.testobject.TestObject tObj = new com.kms.katalon.core.testobject.TestObject(id)
        tObj.addProperty('css', com.kms.katalon.core.testobject.ConditionType.EQUALS, cssSelector)
        return tObj 
    }

}
