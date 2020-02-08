name := """play-java-test"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.1"

libraryDependencies += guice
libraryDependencies += javaJdbc
libraryDependencies += "org.postgresql" % "postgresql" % "42.2.8"
libraryDependencies += evolutions