Feature:

Scenario:

* def xmlPayload = read('file:C:\\Users\\sushma.i.dangeti\\Documents\\Data\\xmlpayload.xml')
* json myJson = read('newJson.json')

* print xmlPayload
* json xmlPayload = xmlPayload
* print xmlPayload

* json xmlToJson1 = xmlPayload.people.employees
* print xmlToJson1

* json xmlToJson2 = xmlPayload.people.students
* print xmlToJson2

* print finalXml = karate.append(xmlToJson1,xmlToJson2)
* print finalXml

* xml jsonToXml1 = xmlToJson1
* print jsonToXml1

* xml jsonToXml2 = xmlToJson2
* print jsonToXml2

* json myJsonfinal = karate.append(myJson,finalXml)

* print myJsonfinal