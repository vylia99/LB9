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

    public List<Point> createList(double begin, double end, double h, double a, double b, double c){
             List <Point> points = new ArrayList<>();
             int q=count(begin,end,h);
               for (int i=0;i<q;i++){
           double x=begin+i*h;
           double y=functionY(a, b, c, x);
           points.add(new Point(x,y));
               }
        return points;
    }

    public double iminY(List <Point> points) {
        double imin=points.get(0).getY();
        for (int i = 0; i <points.size(); i++)
            if (imin>points.get(i).getY()  )
                imin = i;
        return imin;
    }
    public double imaxY(List <Point> points) {
        double imax=points.get(0).getX();
        for (int i = 0; i < points.size(); i++)
            if (imax<points.get(i).getX())
                imax = i;
        return imax;
    }
    public double sumY(List <Point> points) {
        double sum = 0;
        for (int i = 0; i < points.size(); i++)
            sum = sum + points.get(i).getY();
        return sum; }

    public double averageY(List <Point> points) {

        return sumY(points) / points.size();
    }

}
