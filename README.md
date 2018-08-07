Lusi - Lucene Segment Info
==========================

Lusi is a simple console tool that displays segment info structures from your Lucene index.

It's compiled against Lucene 3.3.0, so it supports index file formats until this version.

If you want to run it on newer index formats try to bump Lucene version in *build.gradle*.

How to build
============

    $ ./gradlew clean build

How to run
==========

    $ ./lusi.sh <path to your index directory>

Output
======

 - name - segment name
 - sizeWithDocStores - segment size in megabytes, including document stores
 - sizeWithoutdiaDocStores - segment size in megabytes, without document stores
 - docCount - total number of documents within segment
 - delCount - number of deleted documents within segment


        name=_23z5	sizeWithDocStores=123M	sizeWoDocStores=56M	docCount=43555	delCount=25400
        name=_23x7	sizeWithDocStores=77M	sizeWoDocStores=35M	docCount=26800	delCount=22300
        name=_241x	sizeWithDocStores=78M	sizeWoDocStores=36M	docCount=27245	delCount=0
        name=_244q	sizeWithDocStores=77M	sizeWoDocStores=35M	docCount=27056	delCount=0
        name=_2450	sizeWithDocStores=9M	sizeWoDocStores=9M	docCount=3000	delCount=0
        name=_245a	sizeWithDocStores=9M	sizeWoDocStores=9M	docCount=2908	delCount=0
        name=_245k	sizeWithDocStores=10M	sizeWoDocStores=10M	docCount=3000	delCount=0
        name=_244z	sizeWithDocStores=1M	sizeWoDocStores=1M	docCount=300	delCount=0
        name=_246e	sizeWithDocStores=10M	sizeWoDocStores=10M	docCount=3000	delCount=0
        name=_245u	sizeWithDocStores=10M	sizeWoDocStores=10M	docCount=3000	delCount=0
        name=_2464	sizeWithDocStores=10M	sizeWoDocStores=10M	docCount=3000	delCount=0
        name=_246o	sizeWithDocStores=10M	sizeWoDocStores=10M	docCount=3000	delCount=0
        name=_246p	sizeWithDocStores=1M	sizeWoDocStores=1M	docCount=300	delCount=0
        name=_246q	sizeWithDocStores=1M	sizeWoDocStores=1M	docCount=300	delCount=0
        name=_246r	sizeWithDocStores=1M	sizeWoDocStores=1M	docCount=300	delCount=0
        name=_246s	sizeWithDocStores=1M	sizeWoDocStores=1M	docCount=300	delCount=0
        name=_246t	sizeWithDocStores=1M	sizeWoDocStores=1M	docCount=300	delCount=0
        name=_246u	sizeWithDocStores=1M	sizeWoDocStores=1M	docCount=300	delCount=0
        name=_246v	sizeWithDocStores=0M	sizeWoDocStores=0M	docCount=36	delCount=0
        