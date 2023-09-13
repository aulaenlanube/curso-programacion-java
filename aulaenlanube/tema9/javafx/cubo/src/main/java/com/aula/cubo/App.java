package com.aula.cubo;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class App extends Application {

    private double puntoAnclajeX, puntoAnclajeY;
    private double anguloAnclajeX = 0;
    private double anguloAnclajeY = 0;
    private final Rotate rotacionX = new Rotate(0, Rotate.X_AXIS);
    private final Rotate rotacionY = new Rotate(0, Rotate.Y_AXIS);
    private double factorZoom = 1;

    // parte colores
    private final Color[] coloresCubo = {
            Color.RED, Color.DODGERBLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.PURPLE
    };
    private int indiceColorActual = 0;

    @Override
    public void start(Stage ventanaPrincipal) {

        Box cubo = new Box();
        cubo.setWidth(200.0);
        cubo.setHeight(200.0);
        cubo.setDepth(200.0);

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.PALEGREEN);
        cubo.setMaterial(material);

        VBox root = new VBox();
        root.getChildren().add(cubo);
        root.setAlignment(Pos.CENTER);

        Camera camara = new PerspectiveCamera();
        Scene scene = new Scene(root, 600, 400);
        scene.setCamera(camara);
        scene.setFill(Color.SILVER);

        // inicializar la rotación
        cubo.getTransforms().addAll(rotacionX, rotacionY);

        //configuramos la ventana
        ventanaPrincipal.setTitle("Ejemplo de Cubo 3D con Zoom en JavaFX");
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.show();

        //creamos los eventos
        crearEventos(root, scene, cubo);
    }

    private void crearEventos(VBox vbox, Scene scene, Box cubo) {

        Rotate xRotate;
        Rotate yRotate;

        vbox.getTransforms().addAll(
                xRotate = new Rotate(0, new Point3D(0, 0, 0)),
                yRotate = new Rotate(0, new Point3D(0, 0, 0)));

        // bindings para la rotación
        xRotate.angleProperty().bind(rotacionX.angleProperty());
        yRotate.angleProperty().bind(rotacionY.angleProperty());

        // evento al hacer click en la escena, define en punto de inicio
        scene.setOnMousePressed(event -> {
            puntoAnclajeX = event.getSceneX();
            puntoAnclajeY = event.getSceneY();
            anguloAnclajeX = rotacionX.getAngle();
            anguloAnclajeY = rotacionY.getAngle();
        });

        // evento al arrastrar para girar el cubo
        scene.setOnMouseDragged(event -> {
            rotacionX.setAngle(anguloAnclajeX - (puntoAnclajeY - event.getSceneY()));
            rotacionY.setAngle(anguloAnclajeY + (puntoAnclajeX - event.getSceneX()));
        });

        // eventro scroll para cambiar el tamaño del cubo
        scene.addEventHandler(ScrollEvent.SCROLL, event -> {
            factorZoom = 1.1;
            double deltaY = event.getDeltaY();

            if (deltaY < 0) {
                factorZoom = 1 / factorZoom;
            }

            cubo.setScaleX(cubo.getScaleX() * factorZoom);
            cubo.setScaleY(cubo.getScaleY() * factorZoom);
            cubo.setScaleZ(cubo.getScaleZ() * factorZoom);
        });

        // evento click derecho para cambiar el color del cubo
        cubo.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                cambiarColorCubo(cubo);
            }
        });
    }

    private void cambiarColorCubo(Box cubo) {
        indiceColorActual = (indiceColorActual + 1) % coloresCubo.length;
        PhongMaterial material = (PhongMaterial) cubo.getMaterial();
        material.setDiffuseColor(coloresCubo[indiceColorActual]);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
