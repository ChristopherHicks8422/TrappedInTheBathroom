
public class Exits {

    public static final int UNDEFINED = 0;
    public static final int NORTH = 1;
    public static final int SOUTH = 2;
    public static final int EAST = 3;
    public static final int WEST = 4;
    public static final int UP = 5;
    public static final int DOWN = 6;
    public static final int NORTHEAST = 7;
    public static final int NORTHWEST = 8;
    public static final int SOUTHEAST = 9;
    public static final int SOUTHWEST = 10;
    public static final int IN = 11;
    public static final int OUT = 12;

    public static final String[] dirName = {"UNDEFINED", "NORTH", "SOUTH", "EAST", "WEST", "UP", "DOWN", "NORTHEAST",
            "NORTHWEST", "SOUTHEAST", "SOUTHWEST", "IN", "OUT"};

    public static final String[] shortDirName = {"NULL", "N", "S", "E", "W", "U", "D", "NE", "NW", "SE", "SW", "I", "O"};

    private Locations varLeadsTo = null;
    private int varDirection;
    private String varDirectionName;
    private String varShortDirectionName;

    public Exits() {
        varDirection = Exits.UNDEFINED;
        varLeadsTo = null;
        varDirectionName = dirName[UNDEFINED];
        varShortDirectionName = shortDirName[UNDEFINED];
    }

    public Exits(int direction, Locations leadsTo) {
        varDirection = direction;
        if (direction <= dirName.length) {
            varDirectionName = dirName[varDirection];
            if (direction <= shortDirName.length) {
                varShortDirectionName = shortDirName[varDirection];
            }
            varLeadsTo = leadsTo;
        }
    }

    public String toString() {
        return varDirectionName;
    }

    public void setDirectionName(String dirName) {
        varDirectionName = dirName;
    }

    public String getDirectionName() {
        return varDirectionName;
    }
    public void setShortDirectionName(String shortName) {
        varShortDirectionName = shortName;
    }

    public String getShortDirectionName() {
        return varShortDirectionName;
    }

    public void setLeadsTo(Locations leadsTo) {
        varLeadsTo = leadsTo;
    }

    public Locations getLeadsTo(){
        return varLeadsTo;
    }
}