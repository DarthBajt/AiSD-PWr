/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

/**
 *
 * @author kamil
 */
public class Graham {
    
    private List <Point> points;
    private enum Turn {CLOCKWISE, COLLINEAR, COUNTER_CLOCKWISE};
    
    public Graham (List <Point> points) {
        this.points = points;
    }
    
    public List <Point> getConvexHull() {
        List<Point> sortedPoints = new ArrayList <> (getSortedPoints());
        Stack <Point> stack = new Stack <> ();
        
        stack.push(sortedPoints.get(0));
        stack.push(sortedPoints.get(1));

        for (int i = 2; i < sortedPoints.size(); i++) {

            Point head = sortedPoints.get(i);
            Point middle = stack.pop();
            Point tail = stack.peek();

            Turn turn = getTurn(tail, middle, head);

            switch(turn) {
                case COUNTER_CLOCKWISE:
                    stack.push(middle);
                    stack.push(head);
                    break;
                case CLOCKWISE:
                    i--;
                    break;
                case COLLINEAR:
                    stack.push(head);
                    break;
            }
        }

        // close the hull
        stack.push(sortedPoints.get(0));
        
        return new ArrayList(stack);
    }
    
    private TreeSet getSortedPoints () {
        Point lowest = getLowestPoint();
        
        TreeSet <Point> set = new TreeSet <> ((Point o1, Point o2) -> {
            
            if (o1.equals(o2))
                return 0;
            
            double thetaA = Math.atan2((long) o1.y - lowest.y, (long) o1.x - lowest.x);
            double thetaB = Math.atan2((long) o2.y - lowest.y, (long) o2.x - lowest.x);
            
            if (thetaA < thetaB)
                return -1;
            else if (thetaA > thetaB)
                return 1;
            else {
                double distanceA = Math.sqrt((((long) lowest.x - o1.x) * ((long) lowest.x - o1.x)) +
                        (((long) lowest.y - o1.y) * ((long) lowest.y - o1.y)));
                double distanceB = Math.sqrt((((long) lowest.x - o2.x) * ((long) lowest.x - o2.x)) +
                        (((long) lowest.y - o2.y) * ((long) lowest.y - o2.y)));
                
                if (distanceA < distanceB)
                    return -1;
                else
                    return 1;
            }
        });
        
        set.addAll(points);
        
        return set;
    }
    
    private Point getLowestPoint() {
        Point lowest = points.get(0);

        for (int i = 1; i < points.size(); i++) {
            Point temp = points.get(i);
            if (temp.y < lowest.y || (temp.y == lowest.y && temp.x < lowest.x))
                lowest = temp;
        }
        return lowest;
    }
    
    private Turn getTurn (Point a, Point b, Point c) {

        long crossProduct = (((long) b.x - a.x) * ((long) c.y - a.y)) -
                            (((long) b.y - a.y) * ((long) c.x - a.x));

        if(crossProduct > 0) {
            return Turn.COUNTER_CLOCKWISE;
        }
        else if(crossProduct < 0) {
            return Turn.CLOCKWISE;
        }
        else {
            return Turn.COLLINEAR;
        }
    }
}
