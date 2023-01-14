package com.example.Arcade_Game;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import static com.almasb.fxgl.dsl.FXGL.*;

public class Arcade_Main extends GameApplication implements Arcade_Main_overide {

    public static int wave_final = 1;
    private final Arcade_Factory Arcade_factory = new Arcade_Factory();
    private Entity player;

    public static void wave2() {
        run(() -> {
            double x = getAppWidth();
            double y3 = getAppHeight();
            double y = FXGLMath.random(0, getAppHeight() - 20);
            double y2 = FXGLMath.random(0, getAppHeight() - 20);
            double x_R = FXGLMath.random(0, getAppWidth() - 20);
            double x_R2 = FXGLMath.random(0, getAppWidth() - 20);
            spawn("enemy_R_2", x, y);
            spawn("enemy_L_2", 0, y2);
            spawn("enemy_U_2", x_R, y3);
            spawn("enemy_D_2", x_R2, 0);
        }, Duration.seconds(1), 28);
    }

    public static void wave3() {
        run(() -> {
            double x = getAppWidth();
            double y3 = getAppHeight();
            double y = FXGLMath.random(0, getAppHeight() - 20);
            double y2 = FXGLMath.random(0, getAppHeight() - 20);
            double x_R = FXGLMath.random(0, getAppWidth() - 20);
            double x_R2 = FXGLMath.random(0, getAppWidth() - 20);
            spawn("enemy_R_3", x, y);
            spawn("enemy_L_3", 0, y2);
            spawn("enemy_U_3", x_R, y3);
            spawn("enemy_D_3", x_R2, 0);
        }, Duration.seconds(0.3));
    }

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setTitle("Arcade Game");
        settings.setVersion("0.3");
        settings.setTitle("Arcade Game");
        settings.setVersion("1.0");
        settings.setMainMenuEnabled(true);

    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("Score", 0);
        vars.put("Wave", 1);

    }

    @Override
    protected void initInput() {
        onKey(KeyCode.W, () -> player.translateY(-3));
        onKey(KeyCode.S, () -> player.translateY(3));
        onKey(KeyCode.A, () -> player.translateX(-3));
        onKey(KeyCode.D, () -> player.translateX(3));


        onKey(KeyCode.RIGHT, () ->
                spawn("bullet_R", player.getCenter()));

        onKey(KeyCode.LEFT, () ->
                spawn("bullet_L", player.getCenter()));

        onKey(KeyCode.UP, () -> {
            double x = getGameWorld().getSingleton(entity.PLAYER).getX();
            double y = getGameWorld().getSingleton(entity.PLAYER).getY();
            spawn("bullet_U", x + 15, y + 2);
        });

        onKey(KeyCode.DOWN, () -> {
            double x = getGameWorld().getSingleton(entity.PLAYER).getX();
            double y = getGameWorld().getSingleton(entity.PLAYER).getY();
            spawn("bullet_D", x + 15, y + 2);
        });


    }

    public void timer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                wave_final = 2;
                wave2();
                timer.cancel();
            }
        }, 30000, 1);
    }

    public void timer2() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                wave_final = 3;
                wave3();
                timer.cancel();
            }
        }, 60000, 1);
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new Arcade_Factory());
        player = spawn("player", getAppWidth() / 2 - 15, getAppHeight() / 2 - 15);
        timer();
        timer2();


        if (wave_final == 1) {
            run(() -> {
                double x = getAppWidth();
                double y3 = getAppHeight();
                double y = FXGLMath.random(0, getAppHeight() - 20);
                double y2 = FXGLMath.random(0, getAppHeight() - 20);
                double x_R = FXGLMath.random(0, getAppWidth() - 20);
                double x_R2 = FXGLMath.random(0, getAppWidth() - 20);
                spawn("enemy_R", x, y);
                spawn("enemy_L", 0, y2);
                spawn("enemy_U", x_R, y3);
                spawn("enemy_D", x_R2, 0);


            }, Duration.seconds(2), 15);
        }
    }

    @Override
    protected void initPhysics() {
        AtomicInteger i = new AtomicInteger();
        onCollisionBegin(entity.BULLET, entity.ENEMY, (bull, enemy) -> {
            bull.removeFromWorld();
            enemy.removeFromWorld();
            inc("Score", +1);
            i.getAndIncrement();
            set("Wave", wave_final);
        });

        onCollisionBegin(entity.PLAYER, entity.ENEMY, (player, enemy) -> {
            player.removeFromWorld();
            enemy.removeFromWorld();

            showMessage("Your score was:" + i, () -> getGameController().startNewGame());

        });


    }

    @Override
    protected void initUI() {
        Text scoreText = getUIFactoryService().newText("", Color.BLACK, 24);
        scoreText.textProperty().bind(getip("Score").asString("Score: [%d]"));
        addUINode(scoreText, 650, 30);

        Text waveText = getUIFactoryService().newText("", Color.BLACK, 24);
        waveText.textProperty().bind(getip("Wave").asString("Wave: [%d]"));
        addUINode(waveText, 10, 30);


    }
}





