package PR_5_Java;

public class MovablePoint {
    int x;
    int y;
    int x_speed;
    int y_speed;

    public MovablePoint(int x, int y, int x_speed, int y_speed) {
        this.x = x;
        this.y = y;
        this.x_speed = x_speed;
        this.y_speed = y_speed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", x_speed=" + x_speed +
                ", y_speed=" + y_speed +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX_speed() {
        return x_speed;
    }

    public void setX_speed(int x_speed) {
        this.x_speed = x_speed;
    }

    public int getY_speed() {
        return y_speed;
    }

    public void setY_speed(int y_speed) {
        this.y_speed = y_speed;
    }

    public void moveUp() {
        this.y += this.y_speed;
    }

    public void moveDown() {
        this.y -= this.y_speed;
    }

    public void moveLeft() {
        this.x -= this.x_speed;
    }

    public void moveRight() {
        this.x += this.x_speed;
    }
}
