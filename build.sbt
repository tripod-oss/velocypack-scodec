organization := "io.tripod"
name := "velocypack-scodec"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
startYear := Some(2016)
resolvers += Resolver.jcenterRepo
resolvers += "Sonatype Public" at "https://oss.sonatype.org/content/groups/public/"

scalaVersion := "2.12.1"
crossScalaVersions := Seq(scalaVersion.value, "2.11.8", "2.12.1")

libraryDependencies ++= Seq(
  "org.scodec" %% "scodec-core" % "1.10.3",
  "org.scodec" %% "scodec-bits" % "1.1.2"
)
