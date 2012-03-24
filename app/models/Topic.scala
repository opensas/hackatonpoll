package models

import java.lang.{Iterable => JavaIterable}
import scala.collection.JavaConverters._
import scala.reflect.BeanProperty
import org.codehaus.jackson.annotate.JsonProperty
import javax.persistence.Id
import net.vz.mongodb.jackson.ObjectId
import play.api.Play.current
import play.modules.mongodb.jackson.MongoDB

case class Topic(

    @ObjectId @Id @BeanProperty @JsonProperty("_id")
	val id: String = "",
    
    @BeanProperty @JsonProperty("name")
	val name: String,
	
	@BeanProperty @JsonProperty("description")
	val description: String,

	@BeanProperty @JsonProperty("votes")
	val votes: Int = 0
)

object Topic {
  private lazy val db = MongoDB.collection("topics", classOf[Topic], classOf[String])

  def save(topic: Topic): Unit = db.save(topic) 
  
  def findById(id: String): Topic = db.findOneById(id)
  
  def findByName(name: String): Iterable[Topic] = {
   //val data: JavaIterable[Topic] = db.find().is("name", name)
   //return data.asScala
   return db.find().is("name", name).asInstanceOf[JavaIterable[Topic]].asScala
  }
  
  def findAll(): Iterable[Topic] = {
    return db.find().asInstanceOf[JavaIterable[Topic]].asScala
  }
  
}
