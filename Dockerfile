FROM websphere-liberty:kernel

COPY --chown=1001:0  ./build/libs/crossword-gen-jsf-0.0.2-SNAPSHOT.war /config/apps/
COPY --chown=1001:0  ./build/wlp/usr/servers/defaultServer/server.xml /config/
COPY --chown=1001:0  ./build/wlp/usr/servers/defaultServer/bootstrap.properties /config/

RUN installUtility install --acceptLicense defaultServer
# RUN server start defaultServer

EXPOSE 9080 9443