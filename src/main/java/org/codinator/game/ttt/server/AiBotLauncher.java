package org.codinator.game.ttt.server;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Launcher;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class AiBotLauncher extends Launcher {

    private Logger LOGGER = LoggerFactory.getLogger(AiBotLauncher.class);

    public static void main(String[] args) {
        System.out.println("[ SYSTEM ] Booting ... > " + System.currentTimeMillis());
        new AiBotLauncher().dispatch(args);
    }

    public void afterConfigParsed(JsonObject config) {
        long now = System.currentTimeMillis();
        LOGGER.fatal("------------------------------------------------------------------------------------------");
        LOGGER.debug("[ SYSTEM ] > Vert.x config: " + config.toString());
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            long then = System.currentTimeMillis();
            System.out.println("[ SYSTEM ] Shutting Down ... > " + then);
            System.out.println("[ SYSTEM ] Server Life ... > " + (then - now));
        }));
    }

    public void beforeStartingVertx(VertxOptions options) {
        LOGGER.info("[ *BOOTSTRAP* ] > Starting Vert.x with options " + options.toString());
    }

    public void afterStartingVertx(Vertx vertx) {
        LOGGER.debug("[ SYSTEM ] > Started Vert.x!!");
        vertx.exceptionHandler(
            throwable -> LOGGER.fatal("[ SYSTEM ] Default Exception Handler", throwable));
    }

    public void beforeDeployingVerticle(DeploymentOptions deploymentOptions) {
        LOGGER.debug("[ SYSTEM ] > Deploying verticle with options " + deploymentOptions.toJson().toString());
    }

    @Override
    public void beforeStoppingVertx(Vertx vertx) {
        LOGGER.info("[ SYSTEM ] > Stopping Vert.x!!");
    }
}
