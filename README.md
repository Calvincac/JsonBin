# JsonBin

### About the project
Language: Java <br />
I've used the following tools and libraries:
- TestNG - as the test runner
- Rest Assured - as the framework to test Rest services
- Lombok - as the builder (Please install lombok plugin)
- Hamcrest - used to assert
- Faker    - used as the generator of random data
- Owner    - used to set up the configuration part

### Project tests

You will find the tests in the folder `src/test/java/tests` <br/>
 
`AddBinsTests` - here you can find the tests related to adding a bin <br />
`DeleteBinTests` - here you can find the tests related to deleting a bin <br />
`ReadBinTests` - here you can find the tests related to retrieving bins <br />
`UpdateBinTests` - here you can find the tests related to updating a bin <br />


### Running this project
To run this project, you must place your API key on the config file `src/test/java/configuration/global.properties.`

If you run the command below, you will run all the tests in the project

``
mvn clean install
``
You can also run all the tests by running the test suite `src/test/java/configuration/global.properties`

### Additional Information
I've also added the project to GitLab, and the project is running on a pipeline. <br />
If I had more time, I would also add allure reports for reporting.

