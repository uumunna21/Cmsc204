import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Graph.
 */
public class Graph implements GraphInterface<Town, Road> {
    
    /** The towns. */
    private Set<Town> towns;
    
    /** The roads. */
    private Set<Road> roads;

    /**
     * Instantiates a new graph.
     */
    public Graph() {
        towns = new HashSet<>();
        roads = new HashSet<>();
    }

    /**
     * Adds the vertex.
     *
     * @param town the town
     * @return true, if successful
     */
    public boolean addVertex(Town town) {
        return towns.add(town);
    }

    /**
     * Contains vertex.
     *
     * @param town the town
     * @return true, if successful
     */
    public boolean containsVertex(Town town) {
        return towns.contains(town);
    }

    /**
     * Removes the vertex.
     *
     * @param town the town
     * @return true, if successful
     */
    public boolean removeVertex(Town town) {
        if (!towns.contains(town)) return false;
        roads.removeIf(road -> road.contains(town));
        return towns.remove(town);
    }

    /**
     * Vertex set.
     *
     * @return the sets the
     */
    public Set<Town> vertexSet() {
        return towns;
    }

    /**
     * Adds the edge.
     *
     * @param source the source
     * @param destination the destination
     * @param weight the weight
     * @param name the name
     * @return the road
     */
    public Road addEdge(Town source, Town destination, int weight, String name) {
        if (!towns.contains(source)) towns.add(source);
        if (!towns.contains(destination)) towns.add(destination);
        Road road = new Road(source, destination, weight, name);
        roads.add(road);
        return road;
    }

    /**
     * Removes the edge.
     *
     * @param source the source
     * @param destination the destination
     * @param weight the weight
     * @param name the name
     * @return the road
     */
    public Road removeEdge(Town source, Town destination, int weight, String name) {
        Road road = new Road(source, destination, weight, name);
        if (roads.remove(road)) return road;
        return null;
    }

    /**
     * Gets the edge.
     *
     * @param source the source
     * @param destination the destination
     * @return the edge
     */
    public Road getEdge(Town source, Town destination) {
        for (Road road : roads) {
            if (road.contains(source) && road.contains(destination)) {
                return road;
            }
        }
        return null;
    }

    /**
     * Edge set.
     *
     * @return the sets the
     */
    public Set<Road> edgeSet() {
        return roads;
    }

    /**
     * Shortest path.
     *
     * @param source the source
     * @param destination the destination
     * @return the array list
     */
    public ArrayList<String> shortestPath(Town source, Town destination) {
        Map<Town, Integer> distances = new HashMap<>();
        Map<Town, Town> previous = new HashMap<>();
        PriorityQueue<Town> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (Town town : towns) {
            distances.put(town, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Town current = pq.poll();
            for (Road road : roads) {
                Town neighbor = null;
                if (road.getSource().equals(current)) {
                    neighbor = road.getDestination();
                } else if (road.getDestination().equals(current)) {
                    neighbor = road.getSource();
                }
                if (neighbor != null) {
                    int newDist = distances.get(current) + road.getWeight();
                    if (newDist < distances.get(neighbor)) {
                        distances.put(neighbor, newDist);
                        previous.put(neighbor, current);
                        pq.add(neighbor);
                    }
                }
            }
        }

        ArrayList<String> path = new ArrayList<>();
        if (!previous.containsKey(destination)) return path;

        for (Town at = destination; at != null; at = previous.get(at)) {
            path.add(0, at.getName());
        }

        ArrayList<String> pathOutput = new ArrayList<>();
        for (int i = 0; i < path.size() - 1; i++) {
            Road road = getEdge(new Town(path.get(i)), new Town(path.get(i + 1)));
            if (road != null) {
                pathOutput.add(path.get(i) + " via " + road.getName() + " to " + path.get(i + 1) + " " + road.getWeight() + " mi");
            }
        }
        return pathOutput;
    }

    /**
     * Contains edge.
     *
     * @param sourceVertex the source vertex
     * @param destinationVertex the destination vertex
     * @return true, if successful
     */
    @Override
    public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
        for (Road road : roads) {
            if (road.contains(sourceVertex) && road.contains(destinationVertex)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Edges of.
     *
     * @param vertex the vertex
     * @return the sets the
     */
    @Override
    public Set<Road> edgesOf(Town vertex) {
        Set<Road> result = new HashSet<>();
        for (Road road : roads) {
            if (road.contains(vertex)) {
                result.add(road);
            }
        }
        return result;
    }

    /**
     * Dijkstra shortest path.
     *
     * @param sourceVertex the source vertex
     */
    @Override
    public void dijkstraShortestPath(Town sourceVertex) {
        // Prepares distances and predecessors for shortestPath()
        // This method is useful only if you plan to expose the result of Dijkstra separately

        Map<Town, Integer> distances = new HashMap<>();
        Map<Town, Town> previous = new HashMap<>();
        PriorityQueue<Town> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (Town town : towns) {
            distances.put(town, Integer.MAX_VALUE);
        }
        distances.put(sourceVertex, 0);
        pq.add(sourceVertex);

        while (!pq.isEmpty()) {
            Town current = pq.poll();
            for (Road road : edgesOf(current)) {
                Town neighbor = road.getSource().equals(current) ? road.getDestination() : road.getSource();
                int newDist = distances.get(current) + road.getWeight();
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
}
}