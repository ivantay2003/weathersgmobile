<h1> Weather @ SG mobile app automation </h1>
<br><br>
<br><br>
<br><br>
<h3>This framework is designed to test the weather@sg app with public backend api </h3>
<br>
<br>
This repository contains 1 test case as an example using the framework. If you want to see more test case examples, please contact me for more information.
<br><br><br><br>

__Execution of test__

Install dependencies and run the test. You will need maven to be installed first. Run this on terminal or command prompt. 
<br><br>
- mvn install 

- mvn test

<br><br>
__Project preparation__
<br><br>
Create 2 folders  (for reports and logs) under the main project folder
- TestReport
- log


<br><br>
Please setup your machine for Appium before continuing. If you are using a Mac , I wrote an [article](https://www.linkedin.com/pulse/setting-up-appium-mac-os-x-ivan-tay/) for setting up<br>

<br><br><br>
__BDD__
<br>
__Story__ : As a customer , I like to know the 24 hour weather forecast<br>
__Scenario__ : Customer use mobile to find temperature , humidity and wind information for 24 hour forecast using Weather@SG application<br>
```Given customer wants to find the weather for 24 hour forecast```<br>
```When customer launch Weather@SG app```<br>
```Then information will be retrieved from backend and display to customer in application page```<br>

<br><br><br>
__Test scenario T1-110__
<br><br> Objective for this test scenario is the verify the 24 hour forecast on the mobile and backend
* Launch weather@sg android
* Click on the bottom bar menu button "24 hour forecast" page
* Extract all the mobile elements text from 24 hour forecast - temperature , humidity , wind speed , direction example
* Break up the mobile element strings
* Compare the mobile element text with the backend restapi strings 
* Generate a report and log


<br><br><br>
__Videos Tutorials and demo__<br><br>
There is a 2 minutes [video quick demo](https://youtu.be/7-MVDccL9vw).
<br>If you want to know more details how to create this framework , there is a  4 parts 30 minutes video series in [here](https://youtu.be/aFlLEXHY8Zs) 

<br><br><br><br>
I can be contacted by [Linkedin](http://www.linkedln.ivantay.org) or Skype : *tay.phones*
