package org.devgupta.eztv.org.devgupta.eztv.runner

import org.devgupta.eztv.parser.EzRssParser._;




/**
 * Created with IntelliJ IDEA.
 * User: mrkaiser
 * Date: 11/11/13
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
 */
object Main {



  def main(args: Array[String]) = {
    //off of args 1
    val list =  rssToList(args(0))
    val unique =  uniqueList(list)
    val top =  newestVideo(unique)
    println(top)
  }
}
