ECHO OFF
ECHO Starting TIC TAC TOE game Server

SET JAR=../target/tictactoe-bot-1.0-fat.jar
SET DEBUG=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9000
SET OPTIONS=^
 -Djsse.enableSNIExtension=false^
 -Dvertx.options.workerPoolSize=20^
 -Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.Log4j2LogDelegateFactory^
 -Dgame-host=localhost^
 -Dgame-port=8000

ECHO executing java %DEBUG% %OPTIONS% -jar %JAR%

java %DEBUG% %OPTIONS% -jar %JAR%

PAUSE
