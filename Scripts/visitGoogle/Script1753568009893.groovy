import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.navigateToUrl("https://www.google.com")
WebUI.delay(5)
WebUI.closeBrowser()