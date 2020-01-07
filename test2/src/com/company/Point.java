package com.company;

public class Point {
        // punktens koordinater
        private double x;
        private double y;
        public Point (double x, double y)
        {
            this.x = x;
            this.y = y;
        }
        public double getX ()
        {
            return this.x;
        }
        public double getY ()
        {
            return this.y;
        }
        // distance returnerar avståndet mellan punkten och en given punkt
        public double distance (Point p)
        {
            return Math.sqrt ((p.x - this.x) * (p.x - this.x) +
                    (p.y - this.y) * (p.y - this.y));
        }

        public static Point nearestPoint(Point[] points, Point point){
            Point nearestPoint = points[0];
            double minDistance = points[0].distance(point);

            for(int i = 1; i < points.length; i++) {
                if (points[i].distance(point) < minDistance) {
                    nearestPoint = points[i];
                    minDistance = points[i].distance(point);
                }
            }
            return nearestPoint;
        }

        public static Point[] internalPoints(Point[] points, double r){
            int numberOfPoints = 0;

            for(int i = 0; i < points.length; i++) {
                if(points[i].getX() * points[i].getX() + points[i].getY()*points[i].getY() < r*r) {
                    numberOfPoints++;
                }
            }

            int index = 0;
            Point[] internalPoints = new Point[numberOfPoints];

            for(int i = 0; i<points.length; i++) {
                if(points[i].getX() * points[i].getX() + points[i].getY()*points[i].getY() < r*r) {
                    internalPoints[index++] = points[i];
                }
            }
            return internalPoints;
        }
}
