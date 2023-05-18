package av.avidvivarta.fractal.utils;

public class Time {
    private Time(){}
    public static long startTime = System.nanoTime();
    public static double OneSecondInNanoSecond = 1E9;
    public static double OneSecondInMicroSecond = 1E6;
    public static double OneSecondInMilliSecond = 1E3;
    public static long getCurrentTimeInNano(){
        return System.nanoTime();
    }
    public static long getCurrentTimeInMilli(){
        return System.currentTimeMillis();
    }
}
