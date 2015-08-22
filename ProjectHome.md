# Welcome to nTorrent #
nTorrent - A graphical user interface client to rtorrent (a cli torrent client) written in java. nTorrent can administer a [rtorrent](http://libtorrent.rakshasa.no) process over a network and allows several clients.

&lt;wiki:gadget url="http://www.ohloh.net/p/ntorrent/widgets/project\_basic\_stats.xml" height="220" border="1" /&gt;

## nTorrent-0.5.1 ##

[![](http://bildr.no/thumb/168742.jpeg)](http://bildr.no/view/168742)

nTorrent-0.5.1 is out!

### Features ###

  * Connect to _several_ rtorrent processes on the local machine or/and on a network.
  * Supports SSH, HTTP, and LOCAL connection methods.
    * ~~Copy, erase or open torrents directly from a ssh/local connection.~~ (stub)
  * Simple _customizable_ graphical user interface.
  * Capable of translation, currently in several languages.
  * Add torrents from url or files.
  * Associate nTorrent with torrent files
  * Label, group and _search for torrents_.
  * Change torrents priority
  * View torrent info.
  * View torrent files.
    * Set priority on individual files.
  * View tracker info.
    * Enable/disable trackers
  * View peer info.
  * _Change nTorrents appearance through java's L&F framework_.
  * _Capable of being extended by plugins_.

<sub>Looking for a mac user to test the mac app file, and figure out the file assosciations method of mac osx</sub>


---


## nTorrent-0.4 ##

[![](http://bildr.no/thumb/116553.jpeg)](http://bildr.no/view/116553) [![](http://bildr.no/thumb/113244.jpeg)](http://bildr.no/view/113244)

nTorrent-0.4 was my first try at a remote graphical user interface to rtorrent, however there were several problems with the libraries i used and the way programmed the application, "on the fly" without any consideration to the future development :) .

In a sense my first try was a "proof of concept", and the rewrite of nTorrent with 0.5 version has vastly improved many elements of the code and user interface.

### Features ###

  * Connect to an rtorrent process on the local machine or on a network.
  * Supports SSH, HTTP, and LOCAL connection methods.
    * Copy, erase or open torrents directly from a ssh/local connection.
  * Simple graphical user interface.
  * Capable of translation, currently in several languages.
  * Add torrents from url or files.
  * Associate ntorrent with torrent files
  * Label and group torrents.
  * View torrent info/files.
  * View tracker info
  * Change torrents priority


---


## What nTorrent needs ##
  * Translations
  * Application testing
  * Installation and running documentation
  * Word of encouragement for continued development.

## Download ##

You can download nTorrent from the "downloads tab" on this page. If you are however interested in the latest version, you can download from the SVN repository.

```
# svn co http://ntorrent.googlecode.com/svn/trunk ntorrent
```

This will create a folder ntorrent containing the sourcefiles in your current working directory. to run the application you can issue the "ant run" ([Apache Ant](http://ant.apache.org/)) command within the ntorrent directory. run "ant" to list out other build targets.

## Support ##

If you can't find the help your looking for, try the public discussion group or email me, ![http://safemail.justlikeed.net/e/19266d7c254fb80bae7dfc0fb7157555.png](http://safemail.justlikeed.net/e/19266d7c254fb80bae7dfc0fb7157555.png) allthough discussion group is preferred.

## Thanks to ##
nTorrent was made possible by:

[GNU GPL](http://www.gnu.org/copyleft/gpl.html), [Gimp](http://www.gimp.org/), [GoogleCode](http://www.googlecode.com), [Java](http://java.sun.com/), [rTorrent](http://libtorrent.rakshasa.no),[Tango Desktop Project](http://tango.freedesktop.org/Tango_Desktop_Project), [Redstone XMLRPC](http://xmlrpc.sourceforge.net/), [JCraft Jsch](http://www.jcraft.com/jsch/), [JPF (Java Plugin Framework)](http://jpf.sourceforge.net/), [Apache Ant](http://ant.apache.org/), [JarBundler](http://informagen.com/JarBundler/), [Launch4j](http://launch4j.sourceforge.net/), [Eclipse](http://www.eclipse.org/)

-Thanks!

&lt;wiki:gadget url="http://www.ohloh.net/p/ntorrent/widgets/project\_users.xml" height="100" border="0" /&gt;