package com.company;

public class Rectangle {
        // rektangelns sidlängder
        private double length;
        private double width;
        // rektangelns färg
        private String color;

        public Rectangle (double length, double width, String color) {
            this.length = length;
            this.width = width;
            this.color = color;
        }

        public String getColor () {
            return color;
        }

        public double area () {
            return length * width;
        }

        public static Rectangle minRectangle(Rectangle[] rectangles) {
            double minArea = rectangles[0].area();
            int index = 0;

            for(int i = 1; i < rectangles.length; i++) {
                if(rectangles[i].area() < minArea) {
                    index = i;
                }
            }
            return rectangles[index];
        }

        public static Rectangle[] selectRectangles(Rectangle[] rectangles, String color) {
            int index = 0;
            for(int i = 0; i < rectangles.length; i++) {
                if( rectangles[i].getColor() == color) {
                    index++;
                }
            }

            Rectangle[] selectedRectangles = new Rectangle[index];
            int j = 0;

            for(int i = 0; i < rectangles.length; i++) {
                if( rectangles[i].getColor() == color) {
                    selectedRectangles[j] = rectangles[i];
                    j++;
                }
            }
            return selectedRectangles;
        }

/*    public static Rectangle minRectangle (Rectangle[] rectangles)
    {
        if (rectangles.length == 0)
            throw new java.lang.IllegalArgumentException ("empty array");
        Rectangle minRect = rectangles[0];
        double minArea = minRect.area ();
        for (int pos = 1; pos < rectangles.length; pos++)
            if (rectangles[pos].area () < minArea)
            {
                minRect = rectangles[pos];
                minArea = minRect.area ();
            }
        return minRect;
    }

*/
        public  String toString() {
            String s = "Width: " + this.width + " Length: " + this.length + " Color: " + this.color;
            return s;
        }
}
