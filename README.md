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
 - sizeWoDocStores - segment size in megabytes, without document stores
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
        
Diagnostics
===========

If you run Lusi with *diag* parameter in the end it will produce Lucene diagnostic output per segment:

    $ java -jar build/libs/segmentinfo-all-1.0-SNAPSHOT.jar <path to your index directory> diag
    
    _23z5	{os=Linux, java.vendor=Oracle Corporation, optimize=false, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=merge, mergeFactor=10, os.version=3.2.0-23-generic}
    _23x7	{os=Linux, java.vendor=Oracle Corporation, optimize=false, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=merge, mergeFactor=10, os.version=3.2.0-23-generic}
    _241x	{os=Linux, java.vendor=Oracle Corporation, optimize=false, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=merge, mergeFactor=10, os.version=3.2.0-23-generic}
    _244q	{os=Linux, java.vendor=Oracle Corporation, optimize=false, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=merge, mergeFactor=10, os.version=3.2.0-23-generic}
    _2450	{os=Linux, java.vendor=Oracle Corporation, optimize=false, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=merge, mergeFactor=10, os.version=3.2.0-23-generic}
    _245a	{os=Linux, java.vendor=Oracle Corporation, optimize=false, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=merge, mergeFactor=10, os.version=3.2.0-23-generic}
    _245k	{os=Linux, java.vendor=Oracle Corporation, optimize=false, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=merge, mergeFactor=10, os.version=3.2.0-23-generic}
    _244z	{os=Linux, java.vendor=Oracle Corporation, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=flush, os.version=3.2.0-23-generic}
    _246e	{os=Linux, java.vendor=Oracle Corporation, optimize=false, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=merge, mergeFactor=10, os.version=3.2.0-23-generic}
    _245u	{os=Linux, java.vendor=Oracle Corporation, optimize=false, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=merge, mergeFactor=10, os.version=3.2.0-23-generic}
    _2464	{os=Linux, java.vendor=Oracle Corporation, optimize=false, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=merge, mergeFactor=10, os.version=3.2.0-23-generic}
    _246o	{os=Linux, java.vendor=Oracle Corporation, optimize=false, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=merge, mergeFactor=10, os.version=3.2.0-23-generic}
    _246p	{os=Linux, java.vendor=Oracle Corporation, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=flush, os.version=3.2.0-23-generic}
    _246q	{os=Linux, java.vendor=Oracle Corporation, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=flush, os.version=3.2.0-23-generic}
    _246r	{os=Linux, java.vendor=Oracle Corporation, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=flush, os.version=3.2.0-23-generic}
    _246s	{os=Linux, java.vendor=Oracle Corporation, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=flush, os.version=3.2.0-23-generic}
    _246t	{os=Linux, java.vendor=Oracle Corporation, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=flush, os.version=3.2.0-23-generic}
    _246u	{os=Linux, java.vendor=Oracle Corporation, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=flush, os.version=3.2.0-23-generic}
    _246v	{os=Linux, java.vendor=Oracle Corporation, java.version=1.8.0_121, lucene.version=3.3.0 exported - 2014-09-03 04:10:54, os.arch=amd64, source=flush, os.version=3.2.0-23-generic}
    
