# automationframework

Sample selenium setup:

hub: java -jar selenium-server-standalone-3.3.1.jar -role hub

node: java -Dwebdriver.chrome.driver=./chromedriver  -jar selenium-server-standalone-3.3.1.jar -role node -hub http://localhost:4444/wd/hub -browser browserName=chrome,maxInstances=20,maxSession=20,platform=LINUX
