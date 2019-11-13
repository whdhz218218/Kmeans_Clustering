package assignment1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

public class Test_Kmeans2 extends TestCase {
	
	public List<Point> createdataArray() throws Exception{
		double[] a = { 1.5, 3}; double[] b = { 13, 3}; double[] a1 = { 4, 10}; 
		double[] b1 = { 8, 8}; double[] c = { 3, 2};  double[] c11 = {10, 8 };
		Point pt1 = new Point(a); Point pt2 = new Point(b); Point pt3 = new Point(a1); Point pt4 = new Point(b1);
	    Point pt5 = new Point(c); Point pt6 = new Point(c11);
	    List<Point> dataArray = new LinkedList<Point> ();
	    dataArray.add(pt1);dataArray.add(pt2);dataArray.add(pt3);dataArray.add(pt4);
		dataArray.add(pt5);dataArray.add(pt6);
		return dataArray;
	}
	
	public List<Centroid> createCentroidList() throws Exception{
		double[] a = { 4, 1}; double[] b = { 16, 5}; double[] c = { 2, 3}; 
		Centroid pt1 = new Centroid(a); Centroid pt2 = new Centroid(b);Centroid pt3 = new Centroid(c);
		List<Centroid> centroidList = new LinkedList<Centroid> ();
		centroidList.add(pt1);centroidList.add(pt2);centroidList.add(pt3);
		return centroidList;	
	}
	
	public List<Cluster> createClusterList() throws Exception{
		double[] aa = { 4, 1}; double[] bb = { 16, 5}; double[] cc = { 2, 3}; 
		Centroid ct1 = new Centroid(aa); Centroid ct2 = new Centroid(bb);Centroid ct3 = new Centroid(cc);
		double[] a = { 1.5, 3}; double[] b = { 13, 3}; double[] a1 = { 4, 10}; 
		double[] b1 = { 8, 8}; double[] c = { 3, 2};  double[] c11 = {10, 8 };
		Point pt1 = new Point(a); Point pt2 = new Point(b); Point pt3 = new Point(a1); 
		Point pt4 = new Point(b1); Point pt5 = new Point(c); Point pt6 = new Point(c11);
	    List<Point> pl1=new LinkedList<Point>();
	    pl1.add(pt5);pl1.add(pt1);
	    List<Point> pl2=new LinkedList<Point>();
	    pl2.add(pt2);pl2.add(pt6);
	    List<Point> pl3=new LinkedList<Point>();
	    pl3.add(pt3);pl3.add(pt4);
		Cluster c1=new Cluster(ct1,pl1);
		Cluster c2=new Cluster(ct2,pl2);
		Cluster c3=new Cluster(ct3,pl3);
		List<Cluster> cl= new LinkedList<Cluster>();
		cl.add(c1);cl.add(c2);cl.add(c3);
		return cl;	
	}
	
	public void testsortMapValues() throws Exception {
		//test_vSEv54
		int K=3;
		int maxClusterTimes=600;
		List<Point> dataArray = createdataArray();
		Kmeans2 km=new Kmeans2(K, maxClusterTimes,dataArray);
		double[] a = { 4, 1};Centroid ct1 = new Centroid(a);
		Map<Point,Double> unSortedMap = new HashMap<>();
		for(Point p:dataArray) {
			unSortedMap.put(p,ct1.distancesq(ct1, p));
		}
		System.out.println("Unsorted Map : " + unSortedMap); 
		LinkedHashMap<Point,Double> sortedMap=km.sortMapValues(unSortedMap);
		System.out.println("Sorted Map   : " + sortedMap);		
	}
	
	
	public void testClustering2() throws Exception {
		//test_e8aWC3
		int K=3;
		int maxClusterTimes=600;
		List<Point> dataArray = createdataArray();
		List<Centroid> preCenter= createCentroidList() ;
		Kmeans2 km=new Kmeans2(K, maxClusterTimes,dataArray);
		int nump=2;
		km.clustering2(preCenter,nump);
		List<Cluster> cl= createClusterList();
		for (int i=0;i<km.getclusterList().size();i++) {
			double[]cr=km.getclusterList().get(i).getcentroid().getcoordinates();
			double[]cle=cl.get(i).getcentroid().getcoordinates();
			for(int j=0;j<2;j++) {
				assertEquals(cr[j],cle[j]);
			}
		}
	}
	
	//check if there is enough points in each pointslist of each centroid
	public void ifEnoughPoints () throws Exception {
		//test_UHU2dc
		int K=3;
		int maxClusterTimes=600;
		List<Point> dataArray = createdataArray();
		List<Centroid> preCenter= createCentroidList() ;
		Kmeans2 km=new Kmeans2(K, maxClusterTimes,dataArray);
		int nump=2;
		km.clustering2(preCenter,nump);
		boolean enoughP=true;
		for(int i=0;i<km.getclusterList().size();i++) {
			if(km.getclusterList().get(i).getpointlist().size()!=nump) {
				enoughP=false;
				break;
				}
		}
		assertEquals(enoughP,true);
	}

}
