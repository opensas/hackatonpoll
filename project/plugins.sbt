// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository 
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("play" % "sbt-plugin" % "2.0")

libraryDependencies += "net.vz.mongodb.jackson" % "play-mongo-jackson-mapper_2.9.1" % "1.0.0-rc.2"