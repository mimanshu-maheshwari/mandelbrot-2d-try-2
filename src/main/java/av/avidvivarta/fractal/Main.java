package av.avidvivarta.fractal;

import av.avidvivarta.fractal.utils.Time;
import av.avidvivarta.fractal.visual.Window;


public class Main {

    public static void main(String[] args){
        System.out.println(":::: Fractal application starting ::::" + Time.startTime);
        Window window = Window.getWindow();
        window.start();
    }

}
