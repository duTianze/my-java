package com.dutianze.designpattern.game.updatemethod;

import com.dutianze.designpattern.game.updatemethod.entity.Entity;
import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * <h2 id="credits">Credits</h2>
 * <ul>
 * <li><a href="http://gameprogrammingpatterns.com/update-method.html">Game Programming Patterns - Update Method</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/18
 */
@Slf4j
public class World {

    protected List<Entity> entities;

    protected volatile boolean isRunning;

    public World() {
        entities = new ArrayList<>();
        isRunning = false;
    }

    private void gameLoop() {
        while (isRunning) {
            processInput();
            update();
            render();
        }
    }

    private void processInput() {
        try {
            int lag = new SecureRandom().nextInt(200) + 50;
            Thread.sleep(lag);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private void update() {
        for (Entity entity : entities) {
            entity.update();
        }
    }

    private void render() {
        // Does Nothing
    }

    public void run() {
        log.info("Start game.");
        isRunning = true;
        Thread thread = new Thread(this::gameLoop);
        thread.start();
    }

    public void stop() {
        log.info("Stop game.");
        isRunning = false;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

}
