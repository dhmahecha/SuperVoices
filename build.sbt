name := """SuperVoices"""
organization := "Uniandes"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.8"

herokuAppName in Compile := "voicessuper"

libraryDependencies += filters

EclipseKeys.projectFlavor := EclipseProjectFlavor.Java           // Java project. Don't expect Scala IDE
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)  // Use .class files instead of generated .scala files for views and routes 
EclipseKeys.preTasks := Seq(compile in Compile)                  // Compile the project before generating Eclipse files, so that .class files for views and routes are present

resolvers += Resolver.sonatypeRepo("releases")
libraryDependencies += "uk.co.panaxiom" %% "play-jongo" % "2.0.0-jongo1.3"
libraryDependencies += "org.mongodb" % "mongo-java-driver" % "3.2.2"
libraryDependencies += "com.google.code.maven-play-plugin.org.playframework.modules.secure" % "play-secure" % "1.3.1"
libraryDependencies += filters
libraryDependencies += "org.mindrot" % "jbcrypt" % "0.3m"
libraryDependencies += "com.typesafe.play.modules" %% "play-modules-redis" % "2.5.0"
libraryDependencies += "net.spy" % "spymemcached" % "2.12.1"
libraryDependencies += "com.amazonaws" % "aws-java-sdk" % "1.11.120"
libraryDependencies += "javax.mail" % "mail" % "1.4.5"

herokuAppName in Compile := "voicessuper"

