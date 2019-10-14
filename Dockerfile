FROM websphere-liberty:19.0.0.9-kernel

ARG REPOSITORIES_PROPERTIES=""

RUN if [ ! -z $REPOSITORIES_PROPERTIES ]; then mkdir /opt/ibm/wlp/etc/ \
  && echo $REPOSITORIES_PROPERTIES > /opt/ibm/wlp/etc/repositories.properties; fi \
  && installUtility install --acceptLicense \
    appSecurity-2.0 ldapRegistry-3.0 \
    localConnector-1.0 monitor-1.0 requestTiming-1.0 restConnector-2.0 sessionCache-1.0 \
    sessionDatabase-1.0 ssl-1.0 transportSecurity-1.0 webCache-1.0 webProfile-8.0 \
    appSecurityClient-1.0 javaee-8.0 javaeeClient-8.0 openidConnectClient-1.0 monitor-1.0 microProfile-2.0 microProfile-2.1 microProfile-2.2 \
  && if [ ! -z $REPOSITORIES_PROPERTIES ]; then rm /opt/ibm/wlp/etc/repositories.properties; fi \
  && rm -rf /output/workarea /output/logs \
  && chmod -R g+rwx /opt/ibm/wlp/output/*

COPY --chown=1001:0  ./build/libs/crossword-gen-jsf.war /config/dropins/
COPY --chown=1001:0  ./build/wlp/usr/servers/defaultServer/server.xml /config/
COPY --chown=1001:0  ./build/wlp/usr/servers/defaultServer/bootstrap.properties /config/

RUN server start defaultServer

EXPOSE 9080 9443