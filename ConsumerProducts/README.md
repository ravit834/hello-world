# ConsumerProduct

Steps to build and start the application:
------------------------------------------
1. Open command prompt and navigate to ConsumerProducts folder
2. execute "mvn clean install"
3. Once after step-2 completes, navigate to ConsumerProducts/target folder
4. execute "java -jar ConsumerProducts-0.0.1-SNAPSHOT.jar"
5. Open browser and access swagger(http://localhost:8080/swagger-ui.html) to access the Rest API's
*Details of Rest API's are given below

Technical Stack Used:
---------------------

1.Spring boot
2.Spring JPA
3.H2
4.sl4j
5.swagger

H2:
---

1. Used H2 in memory database .
2. Table is created by Spring JPA and data is also get inserted into the table while spring boot startup (insert queries are written in data.sql file exists in resource folder
3. URL to access the H2 database is : http://localhost:8080/h2
4. JDBC URL is jdbc:h2:mem:consumerproduct (Provided screen shot in screenshots folder (h2.jpg)

Swagger:
----------

1. Swagger is configured to test the api
2. URL to access the swagger is : http://localhost:8080/swagger-ui.html
Provided screen shot in screenshots folder(swagger.jpg)

Rest API's
----------

1. Below are the three REST API's written 
	a)checkIsDiscountedProduct
	b)getAllProducts
	c)quantitySoldByProductType

2. Details about checkIsDiscountedProduct REST API:
	a)takes productId as input and returns the JSON which contains the boolean value(true or false) indicates if Product is discounted or not. Below is the sample response JSON
		{
			"productId": 5,
			"discounted": true
		}
	b) If Product Id is not found thows Product not found error.
	
3. Details about getAllProducts REST API:
	a)This API returns the JSON which contains list of products (ProductId | Price) . Discounted products will be displayed first and then non discounted products. Below is the sample response json
		[
		  {
			"productInformation": "1|(600.2)"
		  },
		  {
			"productInformation": "3|(400.3)"
		  },
		  {
			"productInformation": "5|(300.5)"
		  }
		]

4. Details about quantitySoldByProductType REST API:
	a) This API returns the JSON which contains the Product Type and sum of products sold for specific product type.Below is the sample response json
		{
		  "mobile": 450,
		  "camera": 255
		}
	

