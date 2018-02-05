name := "WordCount"

version := "0.1"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-hive" % "1.6.2",
  "org.apache.spark" %% "spark-sql" % "1.6.2"
)

//指定java版本

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")
