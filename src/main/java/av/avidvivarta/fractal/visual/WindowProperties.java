package av.avidvivarta.fractal.visual;

public class WindowProperties {
    public static final int DEFAULT_WIDTH = 500;
    public static final int DEFAULT_HEIGHT = 500;
    public static final double DEFAULT_ASPECT_RATIO = 1.0d;
    public static final int DEFAULT_ZOOM = 1;
    public static final double DEFAULT_ZOOM_FACTOR = 4;
    public static final short DEFAULT_FPS = 60;
    public static final String DEFAULT_TITLE = "Fractal_try_2";
    private static int width = DEFAULT_WIDTH;
    private static int height = DEFAULT_HEIGHT;
    private static double zoom = DEFAULT_ZOOM;
    private static double zoomFactor = DEFAULT_ZOOM_FACTOR;
    private static double aspectRatio = DEFAULT_ASPECT_RATIO;
    private static String title = DEFAULT_TITLE;
    private static short fps = DEFAULT_FPS;

    private WindowProperties() {
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        WindowProperties.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        WindowProperties.height = height;
    }

    public static double getZoom() {
        return zoom;
    }

    public static void setZoom(double zoom) {
        WindowProperties.zoom = zoom;
    }

    public static double getAspectRatio() {
        return aspectRatio;
    }

    public static void setAspectRatio(double aspectRatio) {
        WindowProperties.aspectRatio = aspectRatio;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        WindowProperties.title = title;
    }

    public static double getZoomFactor() {
        return zoomFactor;
    }

    public static void setZoomFactor(double zoomFactor) {
        WindowProperties.zoomFactor = zoomFactor;
    }

    public static short getFps() {
        return fps;
    }

    public static void setFps(short fps) {
        WindowProperties.fps = fps;
    }
}
