package PR_5_Java;

public class MovableRectangle extends Rectangle implements Movable {
    MovablePoint leftUp;
    MovablePoint rightDown;

    public MovableRectangle(int x_1, int y_1, int x_2, int y_2, int x_speed, int y_speed) {
        this.leftUp = new MovablePoint(x_1, y_1, x_speed,y_speed);
        this.rightDown = new MovablePoint(x_2, y_2,x_speed, y_speed);
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "leftUp=" + leftUp +
                ", rightDown=" + rightDown +
                ", width=" + getWidth() +
                ", length=" + getLength() +
                ", color='" + getColor() + '\'' +
                ", filled=" + isFilled() +
                '}';
    }

    private boolean speedTest() {
        return ((leftUp.getX_speed() == rightDown.getX_speed()) && (leftUp.getY_speed() == rightDown.getY_speed()));
    }

    public void moveUp() {
        if (speedTest()) {
            leftUp.moveUp();
            rightDown.moveUp();
        }
    }

    public void moveDown() {
        if (speedTest()) {
            leftUp.moveDown();
            rightDown.moveDown();
        }
    }

    public void moveLeft() {
        if (speedTest()) {
            leftUp.moveLeft();
            rightDown.moveLeft();
        }
    }

    public void moveRight() {
        if (speedTest()) {
            leftUp.moveRight();
            rightDown.moveRight();
        }
    }
}