package store3d.models;

public class Angle3D {

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return this.z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getAngle() {
        return this.angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
    private double x, y, z, angle;

    public Angle3D(double x, double y, double z, double angle) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.angle = angle;
    }        

}
