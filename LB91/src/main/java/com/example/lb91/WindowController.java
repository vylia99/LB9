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


   /* public void count(ActionEvent actionEvent){
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
    }*/

    private List <Point> getList() {
        double begin =Double.parseDouble(start.getText());
        double finish =Double.parseDouble(end.getText());
        double stp =Double.parseDouble(step.getText());
        double a =Double.parseDouble(one.getText());
        double b =Double.parseDouble(two.getText());
        double c =Double.parseDouble(three.getText());


        return logic.createList(begin,finish,stp,a,b,c);
    }

    public void run(ActionEvent actionEvent) {
        List <Point> list = getList();
        sum.setText(String.format("%.2f",logic.sumY(list)));
        aver.setText(String.format("%5.2f",(logic.averageY(list))));
        imax.setText(String.valueOf(logic.imaxY(list)));
        imin.setText(String.valueOf(logic.iminY(list)));
        outPutY.setText("Кількість кроків : "+ list.size());

    }
}

