function fn() 
{
	var env = karate.env; // system property
	karate.log('The environment variable env = ', env)
	var config = {
			env: env
		}
	

}

