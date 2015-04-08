organization := "pl.matisoft"

name := "soy-functions"

version := "1.0-SNAPSHOT"

// Enables publishing to maven repo
publishMavenStyle := true

// Do not append Scala versions to the generated artifacts
crossPaths := false

// This forbids including Scala related libraries into the dependency
autoScalaLibrary := false

libraryDependencies += "com.google.template" % "soy" % "2015-04-03" % "provided"

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"