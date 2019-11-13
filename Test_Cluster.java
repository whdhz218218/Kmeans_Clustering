package assignment1;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

public class Test_Cluster extends TestCase {
	
	public List<Point> createPointList() throws Exception{
		double[] a = { 1.5, 3}; double[] b = { 13, 3}; 
		double[] a1 = { 4, 10}; double[] b1 = { 75, 9}; 
		Point pt1 = new Point(a); Point pt2 = new Point(b);
	    Point pt3 = new Point(a1); Point pt4 = new Point(b1);
	    List<Point> pl = new LinkedList<Point> ();
	    pl.add(pt1);pl.add(pt2);
		pl.add(pt3);pl.add(pt4);
		return pl;
	}
	
	
	public void testaddpoint() throws Exception {
		//test_MN8cvs
		double[] a1 = { 66, 66};
		Point pt1 = new Point(a1);
		double[] a = { 16, 5}; 
		Centroid ct1 = new Centroid(a);
		List<Point> pl =  createPointList();
		Cluster c=new Cluster(ct1,pl);
		c.addpoint(pt1);
		assertEquals(c.getpointlist().get(4).getcoordinates()[0],66.0);
		assertEquals(c.getpointlist().get(4).getcoordinates()[1],66.0);
	}
	
	public void testNewCentroid() throws Exception {
		//test_eWL34f
		double[] a = { 16, 5}; 
		Centroid ct1 = new Centroid(a);
		List<Point> pl =  createPointList();
		Cluster c=new Cluster(ct1,pl);
		Centroid nc=c.newCentroid();
		assertEquals(nc.getcoordinates()[0], 23.375);
		assertEquals(nc.getcoordinates()[1], 6.25);
	}
}
