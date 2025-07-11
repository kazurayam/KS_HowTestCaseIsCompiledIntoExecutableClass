# [Katalon Studio] Transforming Test Case scripts via Abstract Syntax Tree

## Problem to solve

I was inspired by a discussion at the Katalon user forum:

- https://forum.katalon.com/t/how-to-write-a-single-katalon-script-for-both-desktop-and-mobile-browsers-without-branching-logic/177824/

I got a new question to myself. How can I transform a Test Case script that calls `WebUI.openBrowser('')` keyword 
into another Test Case script that calls `Mobile.startExistingApplication(‘org.mozilla.firefox’)`?

I should be able to develop a new tool that does it. I thought that Abstract Syntax Tree (AST) Transformation will be the key technology.

I remembered that Katalon Studio uses AST already. The Test Case editor uses AST technology. 
When I open a Test Case script the Manual view, the editor parses the Groovy source into an instance of Abstract Syntax Tree.
When I edit the script and save it, the editor 'unparse' it = serialize the AST object into a new Groovy source.
So, I should be able to reuse the AST-related code bundled in Katalon Studio for my own sake.

I looked at the source of Katalon Studio v10.2.0.

```
:~/katalon-workspace/katalon-studio-source/10.2.0/com.kms.katalon.core/com/kms/katalon/core
$ tree ast
ast
├── AstTestStepTransformation.groovy
├── AstTextValueUtil.java
├── GroovyParser.java
├── RequireAstTestStepTransformation.groovy
└── TestStepUtil.java
```

I should be able to reuse those shared classes to implement my transformer. Let me study it!

