package controllers

import play.api._
import play.api.mvc._

import models.Topic

object Application extends Controller {
  
  def index = Action {
  
  	val topic = new Topic("new topic name", "new topic descripcion") 
  
    Ok(views.html.index(
    	message = "Your new application is ready.",
    	topic = topic
    ))
  }
  
}