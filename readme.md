eplicating Issue

From the root of the repository (FCS-ExternalJar) run the following commands

Compile the library and install locally

```bash
cd cd externalLib
mvn install
cd ..
```

Package sample app and generate test jar

```bash
cd externalApp
mvn package jar:test-jar
cd ..
```

Compile the scanner and run tests
```bash
cd scanner
mvn clean compile test
```

Test should fail with exception:
```
io.github.lukehutch.fastclasspathscanner.MatchProcessorException: java.lang.TypeNotPresentException: Type com.foo.externalApp.Foo not present

	at io.github.lukehutch.fastclasspathscanner.MatchProcessorException.newInstance(MatchProcessorException.java:79)
	at io.github.lukehutch.fastclasspathscanner.scanner.ScanSpec.callMatchProcessors(ScanSpec.java:765)
	at io.github.lukehutch.fastclasspathscanner.FastClasspathScanner.scan(FastClasspathScanner.java:1618)
	at io.github.lukehutch.fastclasspathscanner.FastClasspathScanner.scan(FastClasspathScanner.java:1690)
	at io.github.lukehutch.fastclasspathscanner.FastClasspathScanner.scan(FastClasspathScanner.java:1716)
	at com.scanner.Scanner.scan(ScannerMain.java:52)
	at com.scanner.AppTest.matcherShouldNotCrash(AppTest.java:18)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:497)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:47)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:44)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:271)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:70)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:50)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:309)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:160)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:51)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:237)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:497)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
Caused by: java.lang.TypeNotPresentException: Type com.foo.externalApp.Foo not present
	at sun.reflect.annotation.TypeNotPresentExceptionProxy.generateException(TypeNotPresentExceptionProxy.java:46)
	at sun.reflect.annotation.AnnotationInvocationHandler.invoke(AnnotationInvocationHandler.java:83)
	at com.sun.proxy.$Proxy2.clazz(Unknown Source)
	at com.scanner.TestMatcher.processMatch(ScannerMain.java:29)
	at io.github.lukehutch.fastclasspathscanner.scanner.ScanSpec$8.lookForMatches(ScanSpec.java:1324)
	at io.github.lukehutch.fastclasspathscanner.scanner.ScanSpec.callMatchProcessors(ScanSpec.java:704)
	... 32 more
Caused by: java.lang.ClassNotFoundException: com.foo.externalApp.Foo
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at java.lang.Class.forName0(Native Method)
	at java.lang.Class.forName(Class.java:348)
	at sun.reflect.generics.factory.CoreReflectionFactory.makeNamedType(CoreReflectionFactory.java:114)
	at sun.reflect.generics.visitor.Reifier.visitClassTypeSignature(Reifier.java:125)
	at sun.reflect.generics.tree.ClassTypeSignature.accept(ClassTypeSignature.java:49)
	at sun.reflect.annotation.AnnotationParser.parseSig(AnnotationParser.java:439)
	at sun.reflect.annotation.AnnotationParser.parseClassValue(AnnotationParser.java:420)
	at sun.reflect.annotation.AnnotationParser.parseMemberValue(AnnotationParser.java:349)
	at sun.reflect.annotation.AnnotationParser.parseAnnotation2(AnnotationParser.java:286)
	at sun.reflect.annotation.AnnotationParser.parseAnnotations2(AnnotationParser.java:120)
	at sun.reflect.annotation.AnnotationParser.parseAnnotations(AnnotationParser.java:72)
	at java.lang.Class.createAnnotationData(Class.java:3521)
	at java.lang.Class.annotationData(Class.java:3510)
	at java.lang.Class.getAnnotation(Class.java:3415)
	at com.scanner.TestMatcher.processMatch(ScannerMain.java:28)
	... 34 more
```

