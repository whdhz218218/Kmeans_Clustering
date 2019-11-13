package assignment1;

import java.util.List;

public class Cluster{
	private Centroid _centroid;
	private List<Point> _pointslist;
	
	public Cluster(Centroid centroid,List<Point> pointslist) {
		_centroid=centroid;
		_pointslist=pointslist;	
	}
	public Cluster(Centroid centroid,Point point) {
		_centroid=centroid;
		_pointslist.add(point);
	}
	
	public Centroid getcentroid() {return _centroid;}
	public List<Point> getpointlist() {return _pointslist;}	
	//test_MN8cvs - Success
	public void addpoint(Point point) {_pointslist.add(point);}
	
	/**calculate the average of all the points as well as the centroid in each cluster, and get the average 
	 * coordinates of each cluster. Then assign this new point with the avg coordinates to be the new centroid.
	 * @return
	 * @throws Exception
	 */
	public Centroid newCentroid() throws Exception {
		//test_eWL34f - Success
		double sum=0;
		int length=getcentroid().getlength(); //length of each point coordinate
		double num=getpointlist().size();
		double[] coordinates= new double[length];
		for (int j=0;j<length;j++) {
			for (int i=0;i<num;i++) {
				sum+=getpointlist().get(i).getcoordinates()[j]; //sum all the x(y,z.....) coordinate of each point
			}
			coordinates[j]=sum/num; //get the x(y,z.....) coordinate of new centroid by avg			
			sum=0;
		}
		Centroid newCentroid = new Centroid(coordinates);
		return newCentroid;
	}
	


}
