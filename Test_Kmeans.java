package assignment1;

import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.List;

import assignment1.Kmeans;

public class Test_Kmeans extends TestCase {
	
	public List<Point> createdataArray() throws Exception{
		double[] a = { 1.5, 3}; double[] b = { 13, 3}; 
		double[] a1 = { 4, 10}; double[] b1 = { 75, 9}; 
		Point pt1 = new Point(a); Point pt2 = new Point(b);
	    Point pt3 = new Point(a1); Point pt4 = new Point(b1);
	    List<Point> dataArray = new LinkedList<Point> ();
	    dataArray.add(pt1);dataArray.add(pt2);
		dataArray.add(pt3);dataArray.add(pt4);
		return dataArray;
	}
	
	public List<Centroid> createCentroidList() throws Exception{
		double[] a = { 4, 10}; double[] b = { 16, 5}; 
		Centroid pt1 = new Centroid(a); Centroid pt2 = new Centroid(b);
		List<Centroid> centroidList = new LinkedList<Centroid> ();
		centroidList.add(pt1);centroidList.add(pt2);
		return centroidList;	
	}
	
	public List<Point> createdataArray2() throws Exception{
		double[] aa = { 4, 1}; double[] bb = { 16, 5}; double[] cc = { 2, 3}; 
		double[] a = { 1.5, 3}; double[] b = { 13, 3}; double[] a1 = { 4, 10}; double[] b1 = { 8, 8}; 
		double[] c = { 3, 2};   double[] c11 = {10, 8 };double[] d = { 2, 9};   double[] d1 = { 4, 2};
		Point pt1 = new Point(a); Point pt2 = new Point(b); Point pt3 = new Point(a1); Point pt4 = new Point(b1);
	    Point pt5 = new Point(c); Point pt6 = new Point(c11);Point pt7 = new Point(d); Point pt8 = new Point(d1);
	    Point pt9 = new Point(aa); Point pt10 = new Point(bb);Point pt11 = new Point(cc);
	    List<Point> dataArray = new LinkedList<Point> ();
	    dataArray.add(pt1);dataArray.add(pt2);dataArray.add(pt3);dataArray.add(pt4);
		dataArray.add(pt5);dataArray.add(pt6);dataArray.add(pt7);dataArray.add(pt8);
		dataArray.add(pt9);dataArray.add(pt10);dataArray.add(pt11);
		return dataArray;
	}
	
	public List<Centroid> createCentroidList2() throws Exception{
		double[] a = { 4, 1}; double[] b = { 16, 5}; double[] c = { 2, 3}; 
		Centroid pt1 = new Centroid(a); Centroid pt2 = new Centroid(b);Centroid pt3 = new Centroid(c);
		List<Centroid> centroidList = new LinkedList<Centroid> ();
		centroidList.add(pt1);centroidList.add(pt2);centroidList.add(pt3);
		return centroidList;	
	}
	
	public List<Cluster> createClusterList() throws Exception{
		double[] aa = { 4, 1}; double[] bb = { 16, 5}; double[] cc = { 2, 3}; 
		Centroid ct1 = new Centroid(aa); Centroid ct2 = new Centroid(bb);Centroid ct3 = new Centroid(cc);
		double[] a = { 1.5, 3}; double[] b = { 13, 3}; double[] a1 = { 4, 10}; double[] b1 = { 8, 8}; 
		double[] c = { 3, 2};   double[] c11 = {10, 8 };double[] d = { 2, 9};   double[] d1 = { 4, 2};
		Point pt1 = new Point(a); Point pt2 = new Point(b); Point pt3 = new Point(a1); Point pt4 = new Point(b1);
	    Point pt5 = new Point(c); Point pt6 = new Point(c11);Point pt7 = new Point(d); Point pt8 = new Point(d1);
	    List<Point> pl1=new LinkedList<Point>();
	    pl1.add(pt5);pl1.add(pt8);
	    List<Point> pl2=new LinkedList<Point>();
	    pl2.add(pt2);pl2.add(pt6);
	    List<Point> pl3=new LinkedList<Point>();
	    pl3.add(pt1);pl3.add(pt3);pl3.add(pt4);pl3.add(pt7);
		Cluster c1=new Cluster(ct1,pl1);
		Cluster c2=new Cluster(ct2,pl2);
		Cluster c3=new Cluster(ct3,pl3);
		List<Cluster> cl= new LinkedList<Cluster>();
		cl.add(c1);cl.add(c2);cl.add(c3);
		return cl;	
	}
	

	public void testNonPositiveK() throws Exception {
		//Test_CAD44y
		int K=0;
		int maxClusterTimes=500;
		List<Point> dataArray = createdataArray();
		Exception expectedError = null;
		try {
			new Kmeans(K, maxClusterTimes,dataArray);
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError != null );
	}
	
	public void testNegativeTimes() throws Exception {
		//Test_ec6Re3
		int K=3;
		int maxClusterTimes=-5;
		Exception expectedError = null;
		List<Point> dataArray = createdataArray();
		try {
			new Kmeans(K, maxClusterTimes,dataArray);
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError != null );
	}
		
	public void testNullDataArrary() throws Exception {
		//test_34eG42D
		int K=3;
		int maxClusterTimes=600;
		Exception expectedError = null;
		List<Point> dataArray = new LinkedList<Point> ();
		try {
			new Kmeans(K, maxClusterTimes,dataArray);
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError != null );
	}
	
	public void testbigK() throws Exception {
		//test_JJACE4
		int K=6;
		int maxClusterTimes=600;
		Exception expectedError = null;
		List<Point> dataArray = createdataArray();
		try {
			new Kmeans(K, maxClusterTimes,dataArray);
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError != null );
	}
	
	public void testConstructor() throws Exception {
		//test_JH324c
		int K=3;
		int maxClusterTimes=600;
		Exception expectedError = null;
		List<Point> dataArray = createdataArray();
		try {
			new Kmeans(K, maxClusterTimes,dataArray);
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError == null );
	}
	
	public void testclusterList() throws Exception {
		//test_c95hGd
		int K=3;
		int maxClusterTimes=600;
		List<Point> dataArray = createdataArray2();
		Kmeans km=new Kmeans(K, maxClusterTimes,dataArray);
		List<Centroid> preCenter= createCentroidList2();
		int index=1;
		double[] a = { 1.5, 3}; 
		Point pt1 = new Point(a); 
		km.setclusterList(preCenter);
		km.setclusterList2(index, pt1);
		List<Cluster> cl=km.getclusterList();
		assertEquals(cl.get(index).getpointlist().get(0).getcoordinates()[0],1.5);
		assertEquals(cl.get(index).getpointlist().get(0).getcoordinates()[1],3.0);
	}
	
	public void testCentroidList() throws Exception {
		//test_OPJ43c
		int K=3;
		int maxClusterTimes=600;
		Exception expectedError = null;
		List<Point> dataArray = createdataArray();
		Kmeans km=new Kmeans(K, maxClusterTimes,dataArray);
		km.setcentroidList();
		try {
			km.setcentroidList();
		} catch (Exception e) {
			expectedError = e;
		}
		assertTrue( expectedError == null );
	}
	
	public void testClustering() throws Exception {
		//test_wfeaG3
		int K=3;
		int maxClusterTimes=600;
		List<Point> dataArray = createdataArray2();
		List<Centroid> preCenter= createCentroidList2() ;
		Kmeans km=new Kmeans(K, maxClusterTimes,dataArray);
		km.clustering(preCenter);
		List<Cluster> cl= createClusterList();
		for (int i=0;i<km.getclusterList().size();i++) {
			double[]cr=km.getclusterList().get(i).getcentroid().getcoordinates();
			double[]cle=cl.get(i).getcentroid().getcoordinates();
			for(int j=0;j<cr.length;j++) {
				assertEquals(cr[j],cle[j]);
			}
		}
	}
	

	

}
