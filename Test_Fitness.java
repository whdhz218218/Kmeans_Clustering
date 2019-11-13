package assignment1;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

public class Test_Fitness extends TestCase {
	
	public List<Cluster> createClusterList() throws Exception{
		double[] aa = { 4, 1}; double[] bb = { 16, 5};  
		Centroid ct1 = new Centroid(aa); Centroid ct2 = new Centroid(bb);
		double[] b = { 13, 3}; double[] c = { 3, 2};   double[] c11 = {10, 8 };  double[] d1 = { 4, 2};
		Point pt2 = new Point(b);Point pt5 = new Point(c); Point pt6 = new Point(c11); Point pt8 = new Point(d1);
	    List<Point> pl1=new LinkedList<Point>();
	    pl1.add(pt5);pl1.add(pt8);
	    List<Point> pl2=new LinkedList<Point>();
	    pl2.add(pt2);pl2.add(pt6);	 
		Cluster c1=new Cluster(ct1,pl1);
		Cluster c2=new Cluster(ct2,pl2);
		List<Cluster> cl= new LinkedList<Cluster>();
		cl.add(c1);cl.add(c2);
		return cl;	
	}
	
	public List<Centroid> createCentroidList() throws Exception{
		double[] a = { 4, 1}; double[] b = { 16, 5}; double[] c = { 2, 3}; 
		Centroid pt1 = new Centroid(a); Centroid pt2 = new Centroid(b);Centroid pt3 = new Centroid(c);
		List<Centroid> centroidList = new LinkedList<Centroid> ();
		centroidList.add(pt1);centroidList.add(pt2);centroidList.add(pt3);
		return centroidList;	
	}
	
	public void testInnerDistSum() throws Exception {
		//test_eWE7c3
		Fitness f=new Fitness();
		List<Cluster> cl=createClusterList();
		double sum=f.InnerDistSum(cl);
		assertEquals(sum,12.727,0.01);
	}
	
	public void testOuterCenDist() throws Exception {
		//test_olk23C
		Fitness f=new Fitness();
		List<Centroid> cl=createCentroidList();
		double avg=f.OuterCenDist(cl);
		assertEquals(avg,1.131,0.01);
	}

}
