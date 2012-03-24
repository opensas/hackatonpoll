import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "hackatonpoll"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
    	"net.vz.mongodb.jackson" % "play-mongo-jackson-mapper_2.9.1" % "1.0.0-rc.2"
      // Add your project dependencies here,
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here      
    )

}
