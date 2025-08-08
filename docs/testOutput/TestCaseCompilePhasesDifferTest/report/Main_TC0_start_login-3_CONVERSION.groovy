import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement as WebElement

System.setProperty('webdriver.firefox.bin', '/Applications/Firefox.app/Contents/MacOS/firefox')
String url = 'http://demoaut.katalon.com'
String anchorMakeAppointment = 'a[id *= \'btn-make-appointment\']'
WebUI.openBrowser(url)
WebUI.waitForElementPresent(this.makeTestObject(anchorMakeAppointment), 10)
String js = "document.querySelector("$anchorMakeAppointment").click();"
WebUI.comment(js)
WebUI.executeJavaScript(js, null)
WebUI.verifyElementPresent(this.makeTestObject('input[id *= \'txt-username\''), 10)
WebUI.delay(3)
WebUI.closeBrowser()
public class script1754649791539 extends groovy.lang.Script { 

    public script1754649791539() {
    }

    public script1754649791539(final groovy.lang.Binding context) {
        super(context)
    }

    public static void main(final java.lang.String[] args) {
        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1754649791539, args)
    }

    public java.lang.Object run() {
        System.setProperty('webdriver.firefox.bin', '/Applications/Firefox.app/Contents/MacOS/firefox')
        String url = 'http://demoaut.katalon.com'
        String anchorMakeAppointment = 'a[id *= \'btn-make-appointment\']'
        WebUI.openBrowser(url)
        WebUI.waitForElementPresent(this.makeTestObject(anchorMakeAppointment), 10)
        String js = "document.querySelector("$anchorMakeAppointment").click();"
        WebUI.comment(js)
        WebUI.executeJavaScript(js, null)
        WebUI.verifyElementPresent(this.makeTestObject('input[id *= \'txt-username\''), 10)
        WebUI.delay(3)
        WebUI.closeBrowser()
    }

    public TestObject makeTestObject(String selector) {
        return this.makeTestObject(selector, selector)
    }

    public TestObject makeTestObject(String id, String cssSelector) {
        TestObject tObj = new TestObject(id)
        tObj.addProperty('css', ConditionType .EQUALS, cssSelector)
        return tObj 
    }

}
