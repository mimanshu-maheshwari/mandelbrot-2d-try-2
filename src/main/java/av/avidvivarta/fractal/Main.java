package av.avidvivarta.fractal;

import av.avidvivarta.fractal.utils.Time;
import av.avidvivarta.fractal.visual.Window;

import java.time.chrono.ChronoPeriod;

public class Main {

    public static void main(String[] args){
        System.out.println(":::: Fractal application starting ::::" + Time.startTime);
        Window window = Window.getWindow();
        Thread windowThread = new Thread(window, "window");
        windowThread.start();
    }

}
