import java.io.File;
import java.io.IOException;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class TownGraphManager.
 */
public class TownGraphManager implements TownGraphManagerInterface {
    
    /** The graph. */
    private Graph graph;

    /**
     * Instantiates a new town graph manager.
     */
    public TownGraphManager() {
        graph = new Graph();
    }

    /**
     * Adds the town.
     *
     * @param name the name
     * @return true, if successful
     */
    public boolean addTown(String name) {
        return graph.addVertex(new Town(name));
    }

    /**
     * Adds the road.
     *
     * @param town1 the town 1
     * @param town2 the town 2
     * @param weight the weight
     * @param name the name
     * @return true, if successful
     */
    public boolean addRoad(String town1, String town2, int weight, String name) {
        return graph.addEdge(new Town(town1), new Town(town2), weight, name) != null;
    }

    /**
     * Gets the road.
     *
     * @param town1 the town 1
     * @param town2 the town 2
     * @return the road
     */
    public String getRoad(String town1, String town2) {
        Road road = graph.getEdge(new Town(town1), new Town(town2));
        return road != null ? road.getName() : null;
    }

    /**
     * All towns.
     *
     * @return the array list
     */
    public ArrayList<String> allTowns() {
        ArrayList<String> list = new ArrayList<>();
        for (Town town : graph.vertexSet()) {
            list.add(town.getName());
        }
        Collections.sort(list);
        return list;
    }

    /**
     * All roads.
     *
     * @return the array list
     */
    public ArrayList<String> allRoads() {
        ArrayList<String> list = new ArrayList<>();
        for (Road road : graph.edgeSet()) {
            list.add(road.getName());
        }
        Collections.sort(list);
        return list;
    }

    /**
     * Contains town.
     *
     * @param name the name
     * @return true, if successful
     */
    public boolean containsTown(String name) {
        return graph.containsVertex(new Town(name));
    }

    /**
     * Delete road.
     *
     * @param town1 the town 1
     * @param town2 the town 2
     * @param name the name
     * @return true, if successful
     */
    public boolean deleteRoad(String town1, String town2, String name) {
        return graph.removeEdge(new Town(town1), new Town(town2), 0, name) != null;
    }

    /**
     * Delete town.
     *
     * @param name the name
     * @return true, if successful
     */
    public boolean deleteTown(String name) {
        return graph.removeVertex(new Town(name));
    }

    /**
     * Gets the path.
     *
     * @param town1 the town 1
     * @param town2 the town 2
     * @return the path
     */
    public ArrayList<String> getPath(String town1, String town2) {
        return graph.shortestPath(new Town(town1), new Town(town2));
    }

    /**
     * Gets the town.
     *
     * @param name the name
     * @return the town
     */
    @Override
    public Town getTown(String name) {
        for (Town town : graph.vertexSet()) {
            if (town.getName().equals(name)) {
                return town;
            }
        }
        return null; // Not found
    }

    /**
     * Contains road connection.
     *
     * @param town1 the town 1
     * @param town2 the town 2
     * @return true, if successful
     */
    @Override
    public boolean containsRoadConnection(String town1, String town2) {
        Road road = graph.getEdge(new Town(town1), new Town(town2));
        return road != null;
    }

    /**
     * Delete road connection.
     *
     * @param town1 the town 1
     * @param town2 the town 2
     * @param roadName the road name
     * @return true, if successful
     */
    @Override
    public boolean deleteRoadConnection(String town1, String town2, String roadName) {
        return graph.removeEdge(new Town(town1), new Town(town2), 0, roadName) != null;
    }


    
    /**
     * Populate town graph.
     *
     * @param selectedFile the selected file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void populateTownGraph(File selectedFile) throws IOException {
        Scanner scanner = new Scanner(selectedFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Format: "RoadName,Weight;Town1;Town2"
            // Example: "I-95,20;Baltimore;Washington"
            String[] parts = line.split(";");
            if (parts.length == 3) {
                String[] roadInfo = parts[0].split(",");
                String roadName = roadInfo[0];
                int weight = Integer.parseInt(roadInfo[1]);
                String town1 = parts[1];
                String town2 = parts[2];

                addTown(town1);
                addTown(town2);
                addRoad(town1, town2, weight, roadName);
            }
        }
        scanner.close();
    }
}