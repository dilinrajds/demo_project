Feature: Response consolidation

Background:

* def myJson = read('newJson.json')

Scenario: GET Api REST call code
  Given url 'https://gorest.co.in/public/v2/users/20'
  When method GET
  Then status 200
  * def javaUtil = Java.type('com.accenture.demo1.Reader')
  * json data = javaUtil.storeJson(response)
  * print data
  
  Given url 'https://gorest.co.in/public/v2/users/30'
  When method GET
  Then status 200
  * def javaUtil = Java.type('com.accenture.demo1.Reader')
  * def data1 = javaUtil.storeJson(response)
  * print data1
  #
  #Given url 'https://gorest.co.in/public/v2/users/40'
  #When method GET
  #Then status 200
  #* def javaUtil = Java.type('com.accenture.demo1.Reader')
  #* def data2 = javaUtil.storeJson(response)
  #* print data2
  
  #Replace the below details with your respective package, file path and file name
  #* def javaUtil = Java.type('com.accenture.demo1.Reader')
  #* def data = javaUtil.writeFile(response, "C:\\Users\\sushma.i.dangeti\\eclipse-workspace\\demo1\\src\\test\\java\\com\\accenture\\demo1\\","newJson.json")