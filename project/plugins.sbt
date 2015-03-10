resolvers ++= Seq(
  "Typesafe - releases" at "http://repo.typesafe.com/typesafe/releases/"
)
resolvers += Resolver.url("artifactory", url("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.typesafe.sbt" % "sbt-twirl" % "1.0.4")
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")