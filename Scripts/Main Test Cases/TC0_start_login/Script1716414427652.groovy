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
//WebUI.closeBrowser()
