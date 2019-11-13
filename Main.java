package assignment1;
import java.util.LinkedList;
import java.util.List;

public class Main {	
	
	public static void main(String[] args) throws Exception {	
		int K=500;
		int nrows=100;
		int maxClusterTimes=100;
		List<Point> dataArray= new LinkedList<Point>();
		for (int i=0;i<nrows;i++) {
			for (int j=0;j<nrows;j++) {
				double[] coordinates = {i,j};
				Point p=new Point(coordinates);
				dataArray.add(p);
			}		
		}
				
		/**Kmeans*/
		Kmeans km=new Kmeans(K, maxClusterTimes, dataArray);
		km.settimes(1);
		//assign the centroids randomly for the first time
		km.setcentroidList();
		List<Centroid> firstCenter = km.getcentroidList();	
		
		km.clustering(firstCenter);
		//assign new centroids after calculating the distance
	    km.setcentroidList2();
		
		List<Centroid> preCenter=List.copyOf(km.getcentroidList());
		Centroid c=preCenter.get(0);
		
		while(km.gettimes() <= km.getMaxClusterTimes() ) {
			km.clustering(preCenter);		
			km.setcentroidList2();
			//judge if the centroid moves, if moves, end the clustering; or next round
			if(c.CentroidChange(preCenter, km.getcentroidList())) {
				preCenter=List.copyOf(km.getcentroidList());
				}
			else {
			    break;
			}
    	}
    	
		/**The coordinates of centroids are printed out */
		System.out.println(km.gettimes()+"times");	
		for(int i=0;i<km.getcentroidList().size();i++) {
			System.out.println(km.getcentroidList().get(i).getcoordinates()[0]+" , "+km.getcentroidList().get(i).getcoordinates()[1]);
		} 
		
		/**To see the fitness of Kmeans*/	
		Fitness f=new Fitness();
		System.out.println("Kmeans: "+f.InnerDistSum(km.getclusterList()));
		System.out.println("Kmeans: "+f.OuterCenDist(km.getcentroidList()));
		km.OptimalDistSum();
		
		/**Draw the coordinates of points and centroids */	
		km.draw();
		


	
	}
    
}
