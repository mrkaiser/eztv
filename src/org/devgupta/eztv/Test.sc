import org.devgupta.eztv.parser.EzRssParser


/**
 * Created with IntelliJ IDEA.
 * User: mrkaiser
 * Date: 11/11/13
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
           //val list = EzRssParser.rssToList("http://www.ezrss.it/search/index.php?show_name=Downton+Abbey&date=&quality=HDTV&release_group=&mode=rss")
           //val uniques = EzRssParser.uniqueList(list)
           //uniques.toList.sortBy((_._2.org \\ "pubDate").toString).head
           //uniques("Downton Abbey48")
          val node = <enclosure type="application/x-bittorrent" length="1531380321" url="http://torrent.zoink.it/Downton.Abbey.4x08.720p.HDTV.x264-FoV.[eztv].torrent"/>


          node \ "@url"






