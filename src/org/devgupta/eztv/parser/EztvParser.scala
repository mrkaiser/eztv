package org.devgupta.eztv.parser

import org.devgupta.eztv.model.Video
import scala.xml.Node

/**
 * Created with IntelliJ IDEA.
 * User: mrkaiser
 * Date: 11/10/13
 * Time: 8:46 PM
 * To change this template use File | Settings | File Templates.
 */
object EztvParser {

  val title = "";

  def nodeToVideo(node:Node):Video = {
    val title = (node \\ "title").text.trim
    return titleToVideo(title)

  }

  def titleToVideo(title:String) :Video = {
    //series
    val series = (("^[^\\d]*".r) findFirstIn title match {case Some(v) => v case None => ""}).trim
    //val episode the first will be the season the second the episode
    val season = (("\\s\\d{1}".r) findFirstIn title  match {case Some(v) => v case None => "-1"}).trim
    val episode = (("\\d{1,2}\\s".r) findFirstIn title match {case Some(v) => v case None => "-1"}).trim
    // get the quality 1080P or 720P
    val quality = (("\\d{3,4}P".r) findFirstIn title match {case Some(v) => v case None => "-1"}).trim
    //val download = (node \\ "enclosure" \ "@url")
    return Video(series,season.toInt,episode.toInt,quality,"")
  }



}
