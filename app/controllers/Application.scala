package controllers

import play.api._
import play.api.mvc._
import models.Topic
import play.api.data.Form
import play.api.data.Forms._

object Application extends Controller {

  /**
  * Describe the computer form (used in both edit and create screens).
  */ 
  val topicForm = Form(
    mapping(
      "id" -> nonEmptyText,
      "name" -> nonEmptyText,
      "descripcion" -> nonEmptyText,
      "votes" -> number
    )(Topic.apply)(Topic.unapply)
  )

  def list = Action {
  
  	//val topic = new Topic("", "new topic name", "new topic descripcion", 0) 

  	//Topic.save(topic);
  	
    val topics: Iterable[Topic] = Topic.findAll()
    
    Ok(views.html.list(
    	message = "Your new application is ready."
    	topics
    ))
  }
  
}
