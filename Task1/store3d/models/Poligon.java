package store3d.models;

import java.util.List;

public class Poligon {

    private List<Point3D> points;

    public List<Point3D> getPoints() {
        return this.points;
    }

    public void setPoints(List<Point3D> points) {
        this.points = points;
    }

    public Poligon(List<Point3D> points) {
        this.points = points;
    }

    public Poligon() {
    }
}