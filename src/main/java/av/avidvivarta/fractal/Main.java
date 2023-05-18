package av.avidvivarta.fractal;

import av.avidvivarta.fractal.visual.Window;

public class Main {

    public static void main(String[] args){
        System.out.println(":::: Fractal application starting ::::");
        Window window = Window.getWindow();
        Thread windowThread = new Thread(window, "window");
        windowThread.start();
    }

}
