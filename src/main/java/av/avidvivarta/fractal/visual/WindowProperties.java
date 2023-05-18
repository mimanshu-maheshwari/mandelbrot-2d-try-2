package av.avidvivarta.fractal.visual;

public class WindowProperties {
    private WindowProperties windowProperties;
    public final int DEFAULT_WIDTH = 500;
    public final int DEFAULT_HEIGHT = 500;
    public final double DEFAULT_ASPECT_RATIO = 1.0d;
    public final int DEFAULT_ZOOM = 1;
    public final String DEFAULT_TITLE = "Fractal_try_2";
    private int width = DEFAULT_WIDTH;
    private int height = DEFAULT_HEIGHT;
    private double zoom = DEFAULT_ZOOM;
    private double aspectRatio = DEFAULT_ASPECT_RATIO;
    private String title = DEFAULT_TITLE;

    private WindowProperties() {
    }

    public WindowProperties getWindowProperties() {
        return this.windowProperties == null ? this.windowProperties = new WindowProperties() : this.windowProperties;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
    }

    public double getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
