package com.example.lb91;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Logic {
    public Logic(){

    }
    double eps=1.e-8;
    public double functionY(double a, double b, double c, double x){
        if (x<1.4-eps)
            return a*(x*x)+b*x+c;
        else
        if (abs(x-1.4)<eps)
            return (a/x)+Math.sqrt(x*x+1);

        return (a+b*x)/Math.sqrt(x*x+1);

    }
    public int count(double begin, double end, double h){
        return (int)((end-begin)/h+1);

    }
    public List<Point> createPoints(double a, double b, double c, double[] createArrayX) {
        List<Point> points = new ArrayList<>();
        double[] createArrayY = createArrayY(a, b, c, createArrayX);
        for (int i = 0; i < createArrayX.length; i++) {
            points.add(new Point());
        }
        return points;
    }
    public double[] createArrayX(double begin, double end, double h){
        double[] arrayX = new double[count(begin,end,h)];
        for (int i=0;i<arrayX.length;i++){
            arrayX[i]=begin+i*h;
        }
        return arrayX;
    }
    public double[] createArrayY(double a, double b, double c, double[] arrayX) {
        double[] arrayY = new double[arrayX.length];
        for (int i = 0; i < arrayY.length; i++) {
            arrayY[i] = functionY(a, b, c, arrayX[i]);
        }
        return arrayY;
    }
    public double minY(double[] y) {
        double min=y[0];
        for (int i = 0; i < y.length; i++)
            if (min>y[i]  )
                min = y[i];
        return min;
    }

    public double maxY(double[] y) {
        double max = y[0];
        for (int i = 0; i < y.length; i++)
            if (max < y[i])
                max = y[i];
        return max;
    }

    public int iminY(double[] y) {
        int imin=0;
        for (int i = 0; i < y.length; i++)
            if (y[imin]>y[i]  )
                imin = i;
        return imin;
    }
    public int imaxY(double[] y) {
        int imax=0;
        for (int i = 0; i < y.length; i++)
            if (y[imax]<y[i]  )
                imax = i;
        return imax;
    }
    public double sumY(double[] y) {
        double sum = 0;
        for (int i = 0; i < y.length; i++)
            sum = sum + y[i];
        return sum; }

    public double averageY(double[] y) {

        return Math.round(sumY(y) / y.length*1000)/1000;
    }

}
