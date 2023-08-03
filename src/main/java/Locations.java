import java.util.Vector;

public class Locations {

    private String roomTitle;
    private String roomDescription;
    private Vector vecExits;

    public Locations() {
        roomTitle = new String();
        roomDescription = new String();
        vecExits = new Vector();
    }

    public Locations(String roomTitle) {
        this.roomTitle = roomTitle;
        roomDescription = new String();
        vecExits = new Vector();
    }

    public Locations(String roomTitle, String roomDescription) {
        this.roomTitle = roomTitle;
        this.roomDescription = roomDescription;
        vecExits = new Vector();
    }
    public String toString() {
        return roomTitle;
    }
    public String getDescription() {
        return roomDescription;
    }
    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }
    public void addExit(Exits exit) {
        vecExits.addElement(exit);
    }
    public void removeExit(Exits exit) {
        if(vecExits.contains(exit)) {
            vecExits.removeElement(exit);
        }
    }
    public Vector getExits() {
        return (Vector)vecExits.clone();
    }

}
