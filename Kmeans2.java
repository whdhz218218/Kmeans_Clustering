package assignment1;
import java.util.*;

public class Kmeans2 extends Kmeans{
		
		public Kmeans2(int K, int maxClusterTimes, List<Point> dataArray) throws Exception {
			super(K, maxClusterTimes, dataArray);
		}
		
		//test_vSEv54 - Success
		public LinkedHashMap<Point,Double> sortMapValues(Map<Point,Double> unSortedMap) {
			LinkedHashMap<Point,Double> sortedMap = new LinkedHashMap<>();
			unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
	                   .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
			return sortedMap;
		}	
		
		/** for clustering processes, calculate the distance of these points and each centroid, 
		 * then put every point into the cluster the centroid locates.
		 * @param preCenter
		 * @param nump
		 * @throws Exception
		 */	
		//test_e8aWC3 - Success
		public void clustering2 (List<Centroid> preCenter,int nump) throws Exception{	
			//difference here since we want centroid to find points 
			HashMap<Point,Double> disMap=new HashMap<>();
			//put all points into map key, put all 0 into map values
			for(Point p:getdataArray()) {
				disMap.put(p, 0.0);
			}
			//cluster list haven't been created for the first time
			setclusterList(preCenter);
			for (int j=0;j<preCenter.size();j++) {
				for (Point point:disMap.keySet()) {
					double Dis =preCenter.get(j).distancesq(preCenter.get(j), point);
					//put all the distance into a map as values for one centroid 
					disMap.put(point,Dis);				
				}		
				//And then sort the Map values, and get the first 20 points.
				LinkedHashMap<Point,Double> sortmap= sortMapValues(disMap);
				int i=0;
				for(Point key:sortmap.keySet()) {
					setclusterList2(j, key);
					i++;
					//drop all the points that are already been selected by the centroids from dataArray in case of being divided into two groups
					disMap.remove(key);
					//test_UHU2dc - Success
					if(i==nump) {break;}
				}
			}
			settimes(gettimes()+1);
		}			
	}	

