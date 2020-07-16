FROM   registry.access.redhat.com/ubi8/ubi:8.0

RUN mkdir -p /opt/app-root/ 
# WORKDIR /opt/app-root
ONBUILD RUN   yum install -y --disableplugin=subscription-manager java-1.8.0-openjdk-headless && \
      yum clean all --disableplugin=subscription-manager -y && \
      #useradd wildfly && \
      mkdir -p /opt/app-root/bin

RUN   chgrp -R 0 /opt/app-root && \
      chmod -R g=u /opt/app-root

EXPOSE 8080

USER  1001 #wildfly
# Copy the package.json to APP_ROOT 
# Install the dependencies 
# Copy the app source code to APP_ROOT 
ONBUILD COPY target/root.jar /opt/app-root/bin/root.jar
# Start node server on port 3000 
CMD [ "java", "-jar /opt/app-root/bin/root.jar" ]

#java $JAVA_OPTIONS -jar /opt/app-root/bin/api-gateway.jar

#docker build -t nparent:latest .