import java.util.*;

/**
 * Represents a city in the graph.
 */
class City {
    String name;		// the name of the city.
    List<Edge> edges;	// roads that connect this city to other cities.

    /**
     * Creates a new city with the given name.
     * @param name the name of the city
     */
    public City(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }
}

/**
 * Edge class that represents a connection between two cities in the graph
 */
class Edge {
    City dest;		// destination city of the edge
    int weight;		// weights, i.e., distance
    public Edge(City dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

class NavigationSystem {
    List<City> cities;
    
    public NavigationSystem() {
        cities = new ArrayList<>();
    }
    
    public void addCity(String name) {
        cities.add(new City(name));
    }
    
    public void addConnection(String source, String dest, int weight) {
        City src = null, dst = null;
        for (City c : cities) {
            if (c.name.equals(source)) {
                src = c;
            } else if (c.name.equals(dest)) {
                dst = c;
            }
        }
        if (src == null || dst == null) {
            throw new IllegalArgumentException("City not found");
        }
        src.edges.add(new Edge(dst, weight));
    }
    
    public int shortestPath(String start, String end) {
        Map<City, Integer> dist = new HashMap<>();
        Map<City, City> prev = new HashMap<>();
        Set<City> visited = new HashSet<>();
        PriorityQueue<City> pq = new PriorityQueue<>(Comparator.comparing(dist::get));
        
        City startCity = null, endCity = null;
        for (City c : cities) {
            if (c.name.equals(start)) {
                startCity = c;
                dist.put(c, 0);
                pq.offer(c);
            } else {
                dist.put(c, Integer.MAX_VALUE);
            }
            prev.put(c, null);
        }
        
        while (!pq.isEmpty()) {
            City curr = pq.poll();
            if (curr.name.equals(end)) {
                endCity = curr;
                break;
            }
            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);
            for (Edge e : curr.edges) {
                int alt = dist.get(curr) + e.weight;
                if (alt < dist.get(e.dest)) {
                    dist.put(e.dest, alt);
                    prev.put(e.dest, curr);
                    pq.offer(e.dest);
                }
            }
        }
        
        if (endCity == null) {
            throw new IllegalArgumentException("Destination not found");
        }
        
        int totalDist = dist.get(endCity);
        return totalDist;
    }
}

public class Main {
    public static void main(String[] args) {
        NavigationSystem nav = new NavigationSystem();
        nav.addCity("New York");
        nav.addCity("Chicago");
        nav.addCity("Los Angeles");
        nav.addCity("San Francisco");
        
        nav.addConnection("New York", "Chicago", 800);
        nav.addConnection("New York", "Los Angeles", 2800);
        nav.addConnection("Chicago", "San Francisco", 2200);
        nav.addConnection("Los Angeles", "San Francisco", 400);
        
        int dist = nav.shortestPath("New York", "San Francisco");
        System.out.println("Shortest distance: " + dist + " miles");
    }
}
