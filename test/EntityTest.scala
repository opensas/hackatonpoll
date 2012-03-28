package test
import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._
import models._

class EntityTest extends Specification {


    	"be retrieved by id" in {
	    	running(FakeApplication()){

	    		val topic = new Topic("00001","Scala Intro", "A little piece of knowledge")
	    		 topic.name must equalTo("Scala Intro")
	    		 Topic.save(topic)
	    	}
	    }
    }
