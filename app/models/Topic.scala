package models

import org.codehaus.jackson.annotate.JsonProperty
import reflect.BeanProperty
import javax.persistence.Id
import play.api.Play.current
import play.modules.mongodb.jackson.MongoDB
import net.vz.mongodb.jackson.ObjectId

class Topic(@ObjectId @Id val id: String,
             @BeanProperty @JsonProperty("name") val name: String,
             @BeanProperty @JsonProperty("description") val description: String)
{
    @ObjectId @Id def getId = id
}

object Topic {
    private lazy val db = MongoDB.collection("topics", classOf[Topic], classOf[String])

    def save(topic: Topic) { db.save(topic) }
    def findById(id: String) = Option(db.findOneById(id))
}