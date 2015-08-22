# Introduction #

This page deals with nTorrents language files.


# nTorrent-0.5 languages #
| **lang code** | **english name** | **native name** |
|:--------------|:-----------------|:----------------|
| DE            | german<sup>1</sup> | deutsch         |
| EN            | english          | english         |
| IT            | italian          | ?               |
| NO            | norwegian<sup>1</sup> | norsk           |

1: partial, some files are missing

# nTorrent SVN languages #
| **lang code** | **english name** | **native name** |
|:--------------|:-----------------|:----------------|
| DE            | german<sup>2</sup> | deutsch         |
| EN            | english          | english         |
| ES            | spaniard         | ?               |
| FR            | french<sup>2</sup> | ?               |
| HU            | hungarian        | magyar          |
| IT            | italian          | ?               |
| NO            | norwegian<sup>2</sup> | norsk           |

2: partial, some files are missing (2008-06-10)

# Adding a new language #
  1. Join the translators group.
  1. Read the documentation in the group.
  1. Ask kei060 to add you as a member.
  1. svn checkout https://ntorrent.googlecode.com/svn/trunk/ ntorrent --username ...
  1. where ... is the first part of you gmail address (before the @)
  1. When prompted, enter your [generated googlecode.com](http://code.google.com/hosting/settings) password.
  1. tranlate all locale.properties files, by creating new copies of them
  1. use the native2ascii tool to code non-ascii chars to \uxxxx format.
  1. svn add ntorrent/plugins/.../locale/locale\_xx\_XX.properties (for all new files)
  1. svn ci -m "<your language> translation files"

That is all ;-)