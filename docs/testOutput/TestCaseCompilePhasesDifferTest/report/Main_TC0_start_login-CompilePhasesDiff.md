# How Groovy compiler transforms a source

Groovy Compiler transforms the Abstract Syntax Tree of "Main/TC0_start_login" gradually. This report shows how the AST Transformation progresses by looking at the diffs each CompilePhase.

## 1_INITIALIZATION vs 2_PARSING

```
```


## 2_PARSING vs 3_CONVERSION

```
--- Main_TC0_start_login-2_PARSING.groovy
+++ Main_TC0_start_login-3_CONVERSION.groovy
@@ -1,0 +1,54 @@
+import com.kms.katalon.core.testobject.ConditionType as ConditionType
+import com.kms.katalon.core.testobject.TestObject as TestObject
+import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
+import org.openqa.selenium.WebElement as WebElement
+
+System.setProperty('webdriver.firefox.bin', '/Applications/Firefox.app/Contents/MacOS/firefox')
+String url = 'http://demoaut.katalon.com'
+String anchorMakeAppointment = 'a[id *= \'btn-make-appointment\']'
+WebUI.openBrowser(url)
+WebUI.waitForElementPresent(this.makeTestObject(anchorMakeAppointment), 10)
+String js = "document.querySelector("$anchorMakeAppointment").click();"
+WebUI.comment(js)
+WebUI.executeJavaScript(js, null)
+WebUI.verifyElementPresent(this.makeTestObject('input[id *= \'txt-username\''), 10)
+WebUI.delay(3)
+WebUI.closeBrowser()
+public class script1754649791539 extends groovy.lang.Script { 
+
+    public script1754649791539() {
+    }
+
+    public script1754649791539(final groovy.lang.Binding context) {
+        super(context)
+    }
+
+    public static void main(final java.lang.String[] args) {
+        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1754649791539, args)
+    }
+
+    public java.lang.Object run() {
+        System.setProperty('webdriver.firefox.bin', '/Applications/Firefox.app/Contents/MacOS/firefox')
+        String url = 'http://demoaut.katalon.com'
+        String anchorMakeAppointment = 'a[id *= \'btn-make-appointment\']'
+        WebUI.openBrowser(url)
+        WebUI.waitForElementPresent(this.makeTestObject(anchorMakeAppointment), 10)
+        String js = "document.querySelector("$anchorMakeAppointment").click();"
+        WebUI.comment(js)
+        WebUI.executeJavaScript(js, null)
+        WebUI.verifyElementPresent(this.makeTestObject('input[id *= \'txt-username\''), 10)
+        WebUI.delay(3)
+        WebUI.closeBrowser()
+    }
+
+    public TestObject makeTestObject(String selector) {
+        return this.makeTestObject(selector, selector)
+    }
+
+    public TestObject makeTestObject(String id, String cssSelector) {
+        TestObject tObj = new TestObject(id)
+        tObj.addProperty('css', ConditionType .EQUALS, cssSelector)
+        return tObj 
+    }
+
+}
```


## 3_CONVERSION vs 4_SEMANTIC_ANALYSIS

```
--- Main_TC0_start_login-3_CONVERSION.groovy
+++ Main_TC0_start_login-4_SEMANTIC_ANALYSIS.groovy
@@ -3,51 +3,51 @@
 import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
 import org.openqa.selenium.WebElement as WebElement
 
-System.setProperty('webdriver.firefox.bin', '/Applications/Firefox.app/Contents/MacOS/firefox')
-String url = 'http://demoaut.katalon.com'
-String anchorMakeAppointment = 'a[id *= \'btn-make-appointment\']'
-WebUI.openBrowser(url)
-WebUI.waitForElementPresent(this.makeTestObject(anchorMakeAppointment), 10)
-String js = "document.querySelector("$anchorMakeAppointment").click();"
-WebUI.comment(js)
-WebUI.executeJavaScript(js, null)
-WebUI.verifyElementPresent(this.makeTestObject('input[id *= \'txt-username\''), 10)
-WebUI.delay(3)
-WebUI.closeBrowser()
-public class script1754649791539 extends groovy.lang.Script { 
+java.lang.System.setProperty('webdriver.firefox.bin', '/Applications/Firefox.app/Contents/MacOS/firefox')
+java.lang.String url = 'http://demoaut.katalon.com'
+java.lang.String anchorMakeAppointment = 'a[id *= \'btn-make-appointment\']'
+com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.openBrowser(url)
+com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.waitForElementPresent(this.makeTestObject(anchorMakeAppointment), 10)
+java.lang.String js = "document.querySelector("$anchorMakeAppointment").click();"
+com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.comment(js)
+com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.executeJavaScript(js, null)
+com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.verifyElementPresent(this.makeTestObject('input[id *= \'txt-username\''), 10)
+com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.delay(3)
+com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.closeBrowser()
+public class script1754649791845 extends groovy.lang.Script { 
 
-    public script1754649791539() {
+    public script1754649791845() {
     }
 
-    public script1754649791539(final groovy.lang.Binding context) {
+    public script1754649791845(final groovy.lang.Binding context) {
         super(context)
     }
 
     public static void main(final java.lang.String[] args) {
-        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1754649791539, args)
+        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1754649791845, args)
     }
 
     public java.lang.Object run() {
-        System.setProperty('webdriver.firefox.bin', '/Applications/Firefox.app/Contents/MacOS/firefox')
-        String url = 'http://demoaut.katalon.com'
-        String anchorMakeAppointment = 'a[id *= \'btn-make-appointment\']'
-        WebUI.openBrowser(url)
-        WebUI.waitForElementPresent(this.makeTestObject(anchorMakeAppointment), 10)
-        String js = "document.querySelector("$anchorMakeAppointment").click();"
-        WebUI.comment(js)
-        WebUI.executeJavaScript(js, null)
-        WebUI.verifyElementPresent(this.makeTestObject('input[id *= \'txt-username\''), 10)
-        WebUI.delay(3)
-        WebUI.closeBrowser()
+        java.lang.System.setProperty('webdriver.firefox.bin', '/Applications/Firefox.app/Contents/MacOS/firefox')
+        java.lang.String url = 'http://demoaut.katalon.com'
+        java.lang.String anchorMakeAppointment = 'a[id *= \'btn-make-appointment\']'
+        com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.openBrowser(url)
+        com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.waitForElementPresent(this.makeTestObject(anchorMakeAppointment), 10)
+        java.lang.String js = "document.querySelector("$anchorMakeAppointment").click();"
+        com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.comment(js)
+        com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.executeJavaScript(js, null)
+        com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.verifyElementPresent(this.makeTestObject('input[id *= \'txt-username\''), 10)
+        com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.delay(3)
+        com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.closeBrowser()
     }
 
-    public TestObject makeTestObject(String selector) {
+    public com.kms.katalon.core.testobject.TestObject makeTestObject(java.lang.String selector) {
         return this.makeTestObject(selector, selector)
     }
 
-    public TestObject makeTestObject(String id, String cssSelector) {
-        TestObject tObj = new TestObject(id)
-        tObj.addProperty('css', ConditionType .EQUALS, cssSelector)
+    public com.kms.katalon.core.testobject.TestObject makeTestObject(java.lang.String id, java.lang.String cssSelector) {
+        com.kms.katalon.core.testobject.TestObject tObj = new com.kms.katalon.core.testobject.TestObject(id)
+        tObj.addProperty('css', com.kms.katalon.core.testobject.ConditionType.EQUALS, cssSelector)
         return tObj 
     }
 
```


## 4_SEMANTIC_ANALYSIS vs 5_CANONICALIZATION

```
--- Main_TC0_start_login-4_SEMANTIC_ANALYSIS.groovy
+++ Main_TC0_start_login-5_CANONICALIZATION.groovy
@@ -14,17 +14,17 @@
 com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.verifyElementPresent(this.makeTestObject('input[id *= \'txt-username\''), 10)
 com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.delay(3)
 com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.closeBrowser()
-public class script1754649791845 extends groovy.lang.Script { 
+public class script1754649792073 extends groovy.lang.Script { 
 
-    public script1754649791845() {
+    public script1754649792073() {
     }
 
-    public script1754649791845(final groovy.lang.Binding context) {
+    public script1754649792073(final groovy.lang.Binding context) {
         super(context)
     }
 
     public static void main(final java.lang.String[] args) {
-        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1754649791845, args)
+        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1754649792073, args)
     }
 
     public java.lang.Object run() {
```


## 5_CANONICALIZATION vs 6_INSTRUCTION_SELECTION

```
--- Main_TC0_start_login-5_CANONICALIZATION.groovy
+++ Main_TC0_start_login-6_INSTRUCTION_SELECTION.groovy
@@ -14,17 +14,17 @@
 com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.verifyElementPresent(this.makeTestObject('input[id *= \'txt-username\''), 10)
 com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.delay(3)
 com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.closeBrowser()
-public class script1754649792073 extends groovy.lang.Script { 
+public class script1754649792254 extends groovy.lang.Script { 
 
-    public script1754649792073() {
+    public script1754649792254() {
     }
 
-    public script1754649792073(final groovy.lang.Binding context) {
+    public script1754649792254(final groovy.lang.Binding context) {
         super(context)
     }
 
     public static void main(final java.lang.String[] args) {
-        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1754649792073, args)
+        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1754649792254, args)
     }
 
     public java.lang.Object run() {
```


## 6_INSTRUCTION_SELECTION vs 7_CLASS_GENERATION

```
--- Main_TC0_start_login-6_INSTRUCTION_SELECTION.groovy
+++ Main_TC0_start_login-7_CLASS_GENERATION.groovy
@@ -13,18 +13,21 @@
 com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.executeJavaScript(js, null)
 com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.verifyElementPresent(this.makeTestObject('input[id *= \'txt-username\''), 10)
 com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.delay(3)
-com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.closeBrowser()
-public class script1754649792254 extends groovy.lang.Script { 
+return com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.closeBrowser()
+public class script1754649792423 extends groovy.lang.Script { 
 
-    public script1754649792254() {
+    private static org.codehaus.groovy.reflection.ClassInfo $staticClassInfo 
+    public static transient boolean __$stMC 
+
+    public script1754649792423() {
     }
 
-    public script1754649792254(final groovy.lang.Binding context) {
+    public script1754649792423(final groovy.lang.Binding context) {
         super(context)
     }
 
     public static void main(final java.lang.String[] args) {
-        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1754649792254, args)
+        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1754649792423, args)
     }
 
     public java.lang.Object run() {
@@ -38,7 +41,7 @@
         com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.executeJavaScript(js, null)
         com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.verifyElementPresent(this.makeTestObject('input[id *= \'txt-username\''), 10)
         com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.delay(3)
-        com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.closeBrowser()
+        return com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.closeBrowser()
     }
 
     public com.kms.katalon.core.testobject.TestObject makeTestObject(java.lang.String selector) {
@@ -51,4 +54,7 @@
         return tObj 
     }
 
+    protected groovy.lang.MetaClass $getStaticMetaClass() {
+    }
+
 }
```


## 7_CLASS_GENERATION vs 8_OUTPUT

```
--- Main_TC0_start_login-7_CLASS_GENERATION.groovy
+++ Main_TC0_start_login-8_OUTPUT.groovy
@@ -14,20 +14,20 @@
 com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.verifyElementPresent(this.makeTestObject('input[id *= \'txt-username\''), 10)
 com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.delay(3)
 return com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.closeBrowser()
-public class script1754649792423 extends groovy.lang.Script { 
+public class script1754649792616 extends groovy.lang.Script { 
 
     private static org.codehaus.groovy.reflection.ClassInfo $staticClassInfo 
     public static transient boolean __$stMC 
 
-    public script1754649792423() {
+    public script1754649792616() {
     }
 
-    public script1754649792423(final groovy.lang.Binding context) {
+    public script1754649792616(final groovy.lang.Binding context) {
         super(context)
     }
 
     public static void main(final java.lang.String[] args) {
-        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1754649792423, args)
+        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1754649792616, args)
     }
 
     public java.lang.Object run() {
```


## 8_OUTPUT vs 9_FINALIZATION

```
--- Main_TC0_start_login-8_OUTPUT.groovy
+++ Main_TC0_start_login-9_FINALIZATION.groovy
@@ -14,20 +14,20 @@
 com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.verifyElementPresent(this.makeTestObject('input[id *= \'txt-username\''), 10)
 com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.delay(3)
 return com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.closeBrowser()
-public class script1754649792616 extends groovy.lang.Script { 
+public class script1754649792791 extends groovy.lang.Script { 
 
     private static org.codehaus.groovy.reflection.ClassInfo $staticClassInfo 
     public static transient boolean __$stMC 
 
-    public script1754649792616() {
+    public script1754649792791() {
     }
 
-    public script1754649792616(final groovy.lang.Binding context) {
+    public script1754649792791(final groovy.lang.Binding context) {
         super(context)
     }
 
     public static void main(final java.lang.String[] args) {
-        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1754649792616, args)
+        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1754649792791, args)
     }
 
     public java.lang.Object run() {
```


