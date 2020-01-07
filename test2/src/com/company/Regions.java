/*package com.company;

public class Regions {
    interface Region
    {
        // perimeter returnerar områdets omkrets
        double perimeter ();
        // area returnerar områdets area
        double area ();
    }
    class Circle implements Region
    {
        // cirkelns radie
        private double radius;
        public Circle (double radius)
        {
            this.radius = radius;
        }

        @Override
        public double area() {
            return (radius*2*Math.PI);
        }

        @Override
        public double perimeter() {
            return (Math.pow(radius, 2)*Math.PI);
        }

        // koden saknas här
    }
    class Rectangle implements Region
    {
        // rektangelns sidlängder
        private double length;
        private double width;
        public Rectangle (double length, double width)
        {
            this.length = length;
            this.width = width;
        }

        @Override
        public double area() {
            return length*width;
        }

        @Override
        public double perimeter() {
            return ( (length * 2) + (width * 2) );
        }


    }

    public Rectangle[] selectRectangle(Region[] regions){
        int rectangleCount= 0;

        for( int i = 0; i < regions.length; i++) {
           if(regions[i] instanceof Rectangle){
               rectangleCount++;
           }
        }

        Rectangle[] rectangles = new Rectangle[rectangleCount];
        int rectangleIndex = 0;
        for(int i = 0; i < regions.length; i++) {
            if(regions[i] instanceof  Rectangle) {
                rectangles[rectangleIndex++] = (Rectangle) regions[i];
            }
        }
        return rectangles;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
*/