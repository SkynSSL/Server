ps ux | grep java | grep -v javac | awk {'print $2'} | xargs kill  -9
sleep 1;
rm nohup.out
nohup ~/opt/java/jdk1.8.0_162/bin/java -Xmx800m -cp '.:src/ethos/server/data:src:bin:deps/c3p0-0.9.5.1.jar:deps/commons-lang3-3.3.2.jar:deps/GTLVote.jar:deps/jna.jar:deps/jsoup-1.9.2.jar:deps/log4j-1.2.15.jar:deps/mvgate3.jar:deps/oshi-core.jar:deps/slf4j.jar:deps/c3p0-0.9.5-pre10.jar:deps/everythingrs-api.jar:deps/guava-18.0.jar:deps/json-lib-2.4-jdk15.jar:deps/jsoup-1.9.2-sources.jar:deps/mchange-commons-java-0.2.8.jar:deps/mysql.jar:deps/platform.jar:deps/slf4j-nop.jar:deps/commons-io-2.4.jar:deps/gson-2.2.4.jar:deps/guava-18.0-javadoc.jar:deps/json-simple-1.1.1.jar:deps/jython.jar:deps/Motivote-server.jar:deps/netty.jar:deps/poi.jar:deps/xstream.jar:deps/fluent-hc-4.2.6.jar:d' ethos.Server &
sleep 1;
tail -f nohup.out
