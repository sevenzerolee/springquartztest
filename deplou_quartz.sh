#!/bin/bash

# 清除并重新部署
mvn clean tomcat7:deploy

# 部署第二个tomcat测试
cp target/springdemo.war ~/software/apache-tomcat-7.0.70-2/webapps/





