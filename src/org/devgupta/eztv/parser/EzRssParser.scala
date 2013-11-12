package org.devgupta.eztv.parser

import scala.xml.XML
import java.net.URL
import org.devgupta.eztv.model.Video

/**
 * Created with IntelliJ IDEA.
 * User: mrkaiser
 * Date: 11/11/13
 * Time: 10:26 PM
 * To change this template use File | Settings | File Templates.
 */
object EzRssParser {
  def rssToList(url: String): List[Video] = {
    //get the rss
    val rss = XML.load(new URL(url))
     rss \\ "item" map(EztvParser.nodeToVideo(_)) toList

  }

  def uniqueList(videoList:List[Video]):Map[String, Video] = {
    //groupby name+season+episode (so videos with different qualities get grouped together).
    // Then get only the first video. (1080 will come before 720 which will come before HDTV)
    videoList.groupBy(x => x.series+x.season+x.episode).mapValues(_(0))
  }

  def newestVideo(videoList:Map[String,Video]):Video = {
    videoList.toList.sortBy(x => x._2.season*100 + x._2.episode).head._2
  }



}
