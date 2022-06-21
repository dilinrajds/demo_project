Feature:
Scenario:

* def jsonread = read('compare1.json')
* def keys = karate.keysOf(jsonread)
* print keys
* def values = karate.valuesOf(jsonread)
* print values