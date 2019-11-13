package assignment1;
import java.util.LinkedList;
import java.util.List;

public class Main2 {	

	public static void main(String[] args) throws Exception {
		int K=500;
		int nrows=100;
		int maxClusterTimes=100;
		int nump=20;
		List<Point> dataArray= new LinkedList<Point>();
		for (int i=0;i<nrows;i++) {
			for (int j=0;j<nrows;j++) {
				double[] coordinates = {i,j};
				Point p=new Point(coordinates);
				dataArray.add(p);
			}		
		}
				
		/**Kmeans2*/
		Kmeans2 km=new Kmeans2(K, maxClusterTimes, dataArray);
		km.settimes(1);
		//assign the centroids randomly for the first time
		km.setcentroidList();
		List<Centroid> firstCenter = km.getcentroidList();	
		
		km.clustering2(firstCenter,nump);
		//assign new centroids after calculating the distance
	    km.setcentroidList2();
		
		List<Centroid> preCenter=List.copyOf(km.getcentroidList());
		Centroid c=preCenter.get(0);
	
		while(km.gettimes() <= km.getMaxClusterTimes() ) {
			km.clustering2(preCenter,nump);		
			km.setcentroidList2();
			//judge if the centroid moves, if moves, end the clustering; or next round
			if(c.CentroidChange(preCenter, km.getcentroidList())) {
				preCenter=List.copyOf(km.getcentroidList());
				}
			else {break;}
		}

		/**The coordinates of centroids are printed out */
		System.out.println(km.gettimes()+"times");	
		for(int i=0;i<km.getcentroidList().size();i++) {
			System.out.println(km.getcentroidList().get(i).getcoordinates()[0]+" , "+km.getcentroidList().get(i).getcoordinates()[1]);
		} 
		
		/**To see the fitness of Kmeans*/	
		Fitness f=new Fitness();
		System.out.println("Kmeans2: "+f.InnerDistSum(km.getclusterList()));
		System.out.println("Kmeans2: "+f.OuterCenDist(km.getcentroidList()));
		
		/**Draw the coordinates of points and centroids */	
		km.draw();
	
	}

}
