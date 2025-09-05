package org.example;


import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Bounds;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import lombok.Getter;


public class FractalApplication extends Application {

    private GridPane mainPaneGrid;
    private GridPane controlPaneGrid;
    private Canvas mandelbrotCanvas;
    private Canvas juliaCanvas;

    @Getter
    private final DoubleProperty mandelbrotHeight = new SimpleDoubleProperty();
    @Getter
    private DoubleProperty mandelbrotWidth = new SimpleDoubleProperty();
    @Getter
    private DoubleProperty juliaHeight = new SimpleDoubleProperty();
    @Getter
    private DoubleProperty juliaWidth = new SimpleDoubleProperty();


    private void updateCanvasSize(Canvas canvas) {
        //Bounds mandelbrotBounds = mainPaneGrid.getCellBounds(0, 0);
    }

    @Override
    public void start(Stage stage) {

        // mandelbrot canvas
        mandelbrotCanvas = new Canvas();
        mandelbrotCanvas.setCursor(Cursor.HAND);

        // julia canvas
        juliaCanvas = new Canvas();
        juliaCanvas.setCursor(Cursor.HAND);

        // ColumnConstraints
        ColumnConstraints cc1 = new ColumnConstraints(100, 100, -1, Priority.ALWAYS, HPos.CENTER, true);
        ColumnConstraints cc2 = new ColumnConstraints(100, 100, -1, Priority.ALWAYS, HPos.CENTER, true);
        ColumnConstraints cc3 = new ColumnConstraints(400, 400, 400, Priority.ALWAYS, HPos.CENTER, true);

        // RowConstraints
        RowConstraints rc1 = new RowConstraints(400, 400, -1, Priority.ALWAYS, VPos.CENTER, true);

        // main grid
        mainPaneGrid = new GridPane();
        mainPaneGrid.setGridLinesVisible(true);
        mainPaneGrid.add(mandelbrotCanvas, 0, 0);
        mainPaneGrid.add(juliaCanvas, 1, 0);
        mainPaneGrid.getColumnConstraints().addAll(cc1, cc2, cc3);
        mainPaneGrid.getRowConstraints().addAll(rc1);




        Scene scene = new Scene(mainPaneGrid, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Fractal Application");
        stage.setWidth(1080);
        stage.setHeight(720);
        stage.show();
    }

}
