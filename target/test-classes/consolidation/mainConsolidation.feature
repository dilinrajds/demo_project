Feature:

Background:
* def myJson = read('newJson.json')

Scenario:

* def res = call read('subConsolidation.feature') myJson
* print res

* def javaUtil = Java.type('com.accenture.demo1.Reader')
* json data = javaUtil.returnResponse()
* print data