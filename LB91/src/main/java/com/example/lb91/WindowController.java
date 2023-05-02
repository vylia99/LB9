package com.example.lb91;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.*;

public class WindowController {
    @FXML private TextArea sum;
    @FXML private TextArea aver;
    @FXML private TextArea min;
    @FXML private TextArea max;
    @FXML private TextArea imin;
    @FXML private TextArea imax;
    @FXML private TextField one;
    @FXML private TextField two;
    @FXML private TextField three;
    @FXML private TextArea outPutY;

    @FXML private TextField start;
    @FXML private TextField end;
    @FXML private TextField step;
    @FXML private TextArea output;



    Logic logic = new Logic();


   /* public void createArrayX(ActionEvent actionEvent) {
        double[] arrayX = getArrayX();
        double begin =Double.parseDouble(start.getText());
        double finish =Double.parseDouble(end.getText());
        double stp =Double.parseDouble(step.getText());

       output.setText("Кількість кроків : "+logic.count(begin,finish,stp));
    }*/
    public void countX(ActionEvent actionEvent){
        double begin =Double.parseDouble(start.getText());
        double finish =Double.parseDouble(end.getText());
        double stp =Double.parseDouble(step.getText());

        output.setText("Кількість кроків : "+logic.count(begin,finish,stp));
    }
    public void countY(ActionEvent actionEvent){
        double begin =Double.parseDouble(one.getText());
        double finish =Double.parseDouble(two.getText());
        double stp =Double.parseDouble(three.getText());

        outPutY.setText("Кількість кроків : "+logic.count(begin,finish,stp));
    }

    private double[] getArrayX() {
        double begin =Double.parseDouble(start.getText());
        double finish =Double.parseDouble(end.getText());
        double stp =Double.parseDouble(step.getText());
        double[] arrayX=logic.createArrayX(begin,finish,stp);
        return arrayX;
    }

    public void createArrayY(ActionEvent actionEvent) {
        double[] arrayY = getArrayY();
        StringBuilder str= new StringBuilder();
        Formatter fmt =new Formatter(str);
        for (int i = 0; i < arrayY.length; i++) {
            fmt.format("y=%.2f ; ",arrayY[i]);
        }
        outPutY.setText("Кількість кроків : "+ Arrays.toString(str.toString().split(Arrays.toString(arrayY))));
    }

    private double[] getArrayY() {
        double a =Double.parseDouble(one.getText());
        double b =Double.parseDouble(two.getText());
        double c =Double.parseDouble(three.getText());
        double[] arrayX= getArrayX();
        double[] arrayY=logic.createArrayY(a,b,c,arrayX) ;
        return arrayY;
    }

    public void run(ActionEvent actionEvent) {
        double[] masY = getArrayY();
        sum.setText(String.format("%.2f",logic.sumY(masY)));
        aver.setText(String.valueOf(logic.averageY(masY)));
        imax.setText(String.valueOf(logic.imaxY(masY)));
        imin.setText(String.valueOf(logic.iminY(masY)));

    }
}

