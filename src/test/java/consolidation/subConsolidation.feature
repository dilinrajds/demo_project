Feature:

Scenario: GET Api REST call code
  Given url 'https://gorest.co.in/public/v2/users'
  And path id
  When method GET
  Then status 200
  * def getResponse = response
  * print getResponse
  
  * def javaUtil = Java.type('com.accenture.demo1.Reader')
  * json data = javaUtil.receiveResponse(getResponse)
  * print data
