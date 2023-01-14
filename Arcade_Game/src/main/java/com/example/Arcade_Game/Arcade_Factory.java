package com.example.Arcade_Game;

import com.almasb.fxgl.animation.Interpolators;
import com.almasb.fxgl.dsl.components.OffscreenCleanComponent;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.entityBuilder;
import static com.almasb.fxgl.dsl.FXGL.getInput;
import static com.almasb.fxgl.dsl.FXGLForKtKt.animationBuilder;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class Arcade_Factory implements EntityFactory {

    @Spawns("player")
    public Entity new_player(SpawnData data) {
        return entityBuilder()
                .from(data)
                .type(entity.PLAYER)
                .viewWithBBox(new Circle(20, 20, 20, Color.BLUE))
                .collidable()
                .build();


    }

    @Spawns("enemy_R")
    public Entity newEnemy_R(SpawnData data) {
        var view = new Circle(20, 20, 20, Color.RED);

        return entityBuilder()
                .type(entity.ENEMY)
                .from(data)
                .viewWithBBox(view)
                .collidable()
                .with(new ProjectileComponent(new Point2D(-1, 0), 50))
                .build();
    }

    @Spawns("enemy_L")
    public Entity newEnemy_L(SpawnData data) {
        var view = new Circle(20, 20, 20, Color.RED);

        return entityBuilder()
                .type(entity.ENEMY)
                .from(data)
                .viewWithBBox(view)
                .collidable()
                .with(new ProjectileComponent(new Point2D(1, 0), 50))
                .build();
    }

    @Spawns("enemy_U")
    public Entity newEnemy_U(SpawnData data) {
        var view = new Circle(20, 20, 20, Color.RED);

        return entityBuilder()
                .type(entity.ENEMY)
                .from(data)
                .viewWithBBox(view)
                .collidable()
                .with(new ProjectileComponent(new Point2D(0, -1), 50))
                .build();
    }

    @Spawns("enemy_D")
    public Entity newEnemy_D(SpawnData data) {
        var view = new Circle(20, 20, 20, Color.RED);

        return entityBuilder()
                .type(entity.ENEMY)
                .from(data)
                .viewWithBBox(view)
                .collidable()
                .with(new ProjectileComponent(new Point2D(0.0, 1.0), 50))
                .build();
    }

    @Spawns("enemy_L_2")
    public Entity newEnemy_L_2(SpawnData data) {
        var view = new Circle(20, 20, 20, Color.RED);
        view.setStroke(Color.GREY);
        view.setStrokeWidth(0.5);

        animationBuilder()
                .interpolator(Interpolators.SMOOTH.EASE_OUT())
                .duration(Duration.seconds(0.5))
                .repeatInfinitely()
                .animate(view.fillProperty())
                .from(Color.RED)
                .to(Color.DARKRED)
                .buildAndPlay();

        return entityBuilder()
                .type(entity.ENEMY)
                .from(data)
                .viewWithBBox(view)
                .collidable()
                .with(new ProjectileComponent(new Point2D(1, 0), 100))
                .build();
    }

    @Spawns("enemy_R_2")
    public Entity newEnemy_R_2(SpawnData data) {
        var view = new Circle(20, 20, 20, Color.RED);
        view.setStroke(Color.GREY);
        view.setStrokeWidth(0.5);


        animationBuilder()
                .interpolator(Interpolators.SMOOTH.EASE_OUT())
                .duration(Duration.seconds(0.5))
                .repeatInfinitely()
                .animate(view.fillProperty())
                .from(Color.RED)
                .to(Color.DARKRED)
                .buildAndPlay();

        return entityBuilder()
                .type(entity.ENEMY)
                .from(data)
                .viewWithBBox(view)
                .collidable()
                .with(new ProjectileComponent(new Point2D(-1, 0), 100))
                .build();
    }

    @Spawns("enemy_U_2")
    public Entity newEnemy_U_2(SpawnData data) {
        var view = new Circle(20, 20, 20, Color.RED);
        view.setStroke(Color.GREY);
        view.setStrokeWidth(0.5);


        animationBuilder()
                .interpolator(Interpolators.SMOOTH.EASE_OUT())
                .duration(Duration.seconds(0.5))
                .repeatInfinitely()
                .animate(view.fillProperty())
                .from(Color.RED)
                .to(Color.DARKRED)
                .buildAndPlay();

        return entityBuilder()
                .type(entity.ENEMY)
                .from(data)
                .viewWithBBox(view)
                .collidable()
                .with(new ProjectileComponent(new Point2D(0, -1), 100))
                .build();
    }

    @Spawns("enemy_D_2")
    public Entity newEnemy_D_2(SpawnData data) {
        var view = new Circle(20, 20, 20, Color.RED);
        view.setStroke(Color.GREY);
        view.setStrokeWidth(0.5);


        animationBuilder()
                .interpolator(Interpolators.SMOOTH.EASE_OUT())
                .duration(Duration.seconds(0.5))
                .repeatInfinitely()
                .animate(view.fillProperty())
                .from(Color.RED)
                .to(Color.DARKRED)
                .buildAndPlay();

        return entityBuilder()
                .type(entity.ENEMY)
                .from(data)
                .viewWithBBox(view)
                .collidable()
                .with(new ProjectileComponent(new Point2D(0, 1), 100))
                .build();
    }

    @Spawns("enemy_R_3")
    public Entity newEnemy_R_3(SpawnData data) {
        var view = new Circle(10, 10, 10, Color.RED);
        view.setStroke(Color.GREY);
        view.setStrokeWidth(0.5);


        animationBuilder()
                .interpolator(Interpolators.SMOOTH.EASE_OUT())
                .duration(Duration.seconds(0.25))
                .repeatInfinitely()
                .animate(view.fillProperty())
                .from(Color.RED)
                .to(Color.YELLOW)
                .buildAndPlay();

        return entityBuilder()
                .type(entity.ENEMY)
                .from(data)
                .viewWithBBox(view)
                .collidable()
                .with(new ProjectileComponent(new Point2D(-1, 0), 150))
                .build();
    }

    @Spawns("enemy_L_3")
    public Entity newEnemy_L_3(SpawnData data) {
        var view = new Circle(10, 10, 10, Color.RED);
        view.setStroke(Color.GREY);
        view.setStrokeWidth(0.5);


        animationBuilder()
                .interpolator(Interpolators.SMOOTH.EASE_OUT())
                .duration(Duration.seconds(0.25))
                .repeatInfinitely()
                .animate(view.fillProperty())
                .from(Color.RED)
                .to(Color.YELLOW)
                .buildAndPlay();

        return entityBuilder()
                .type(entity.ENEMY)
                .from(data)
                .viewWithBBox(view)
                .collidable()
                .with(new ProjectileComponent(new Point2D(1, 0), 150))
                .build();
    }

    @Spawns("enemy_U_3")
    public Entity newEnemy_U_3(SpawnData data) {
        var view = new Circle(10, 10, 10, Color.RED);
        view.setStroke(Color.GREY);
        view.setStrokeWidth(0.5);


        animationBuilder()
                .interpolator(Interpolators.SMOOTH.EASE_OUT())
                .duration(Duration.seconds(0.25))
                .repeatInfinitely()
                .animate(view.fillProperty())
                .from(Color.RED)
                .to(Color.YELLOW)
                .buildAndPlay();

        return entityBuilder()
                .type(entity.ENEMY)
                .from(data)
                .viewWithBBox(view)
                .collidable()
                .with(new ProjectileComponent(new Point2D(0, -1), 150))
                .build();
    }

    @Spawns("enemy_D_3")
    public Entity newEnemy_D_3(SpawnData data) {
        var view = new Circle(10, 10, 10, Color.RED);
        view.setStroke(Color.GREY);
        view.setStrokeWidth(0.5);


        animationBuilder()
                .interpolator(Interpolators.SMOOTH.EASE_OUT())
                .duration(Duration.seconds(0.25))
                .repeatInfinitely()
                .animate(view.fillProperty())
                .from(Color.RED)
                .to(Color.YELLOW)
                .buildAndPlay();

        return entityBuilder()
                .type(entity.ENEMY)
                .from(data)
                .viewWithBBox(view)
                .collidable()
                .with(new ProjectileComponent(new Point2D(0, 1), 150))
                .build();
    }


    @Spawns("bullet_R")
    public Entity newBullet_R(SpawnData data) {
        Entity player = getGameWorld().getSingleton(entity.PLAYER);
        Point2D direction = getInput().getMousePositionWorld()
                .subtract(player.getCenter());

        return entityBuilder()
                .from(data)
                .type(entity.BULLET)
                .viewWithBBox(new Circle(2, 2, 2, Color.BLACK))
                .collidable()
                .zIndex(-5)
                .with(new ProjectileComponent(new Point2D(1.0, 0.0), 700.0))
                .with(new OffscreenCleanComponent())
                .build();
    }

    @Spawns("bullet_L")
    public Entity newBullet_L(SpawnData data) {
        Entity player = getGameWorld().getSingleton(entity.PLAYER);
        Point2D direction = getInput().getMousePositionWorld()
                .subtract(player.getCenter());

        return entityBuilder()
                .from(data)
                .type(entity.BULLET)
                .viewWithBBox(new Circle(2, 2, 2, Color.BLACK))
                .collidable()
                .zIndex(-5)
                .with(new ProjectileComponent(new Point2D(-1.0, 0.0), 700.0))
                .with(new OffscreenCleanComponent())
                .build();
    }

    @Spawns("bullet_D")
    public Entity newBullet_D(SpawnData data) {
        Entity player = getGameWorld().getSingleton(entity.PLAYER);
        Point2D direction = getInput().getMousePositionWorld()
                .subtract(player.getCenter());

        return entityBuilder()
                .from(data)
                .type(entity.BULLET)
                .viewWithBBox(new Circle(2, 2, 2, Color.BLACK))
                .collidable()
                .zIndex(-5)
                .with(new ProjectileComponent(new Point2D(0.0, 1.0), 700.0))
                .with(new OffscreenCleanComponent())
                .build();


    }

    @Spawns("bullet_U")
    public Entity newBullet_U(SpawnData data) {
        Entity player = getGameWorld().getSingleton(entity.PLAYER);
        Point2D direction = getInput().getMousePositionWorld()
                .subtract(player.getCenter());

        return entityBuilder()
                .from(data)
                .type(entity.BULLET)
                .viewWithBBox(new Circle(2, 2, 2, Color.BLACK))
                .collidable()
                .with(new ProjectileComponent(new Point2D(0.0, -1.0), 700.0))
                .with(new OffscreenCleanComponent())
                .build();

    }

}
