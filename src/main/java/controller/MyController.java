package controller;

import com.jfinal.core.Controller;

public class MyController extends Controller {
    public  void voice(){
        System.out.println("I am voice");
        renderText("I am voice!!!");
    }
}
