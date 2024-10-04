public class Player {
    String name;
    char marker;
    int loseCount;
    int winCount;


    /**
     * Constructor for the Player object
     * @param name is the name
     * @param marker is the players Marker
     */
    public Player(String name, char marker) {
        this.name = name;
        this.marker = marker;
    }

    /**
     * Method to return the value of name
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the value of name
     * @param name is the name of the object
     */


    public void setName(String name) {
        this.name = name;
    }

    public char getMarker() {
        return marker;
    }

    public void setMarker(char marker) {
        this.marker = marker;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public void setLoseCount(int loseCount) {
        this.loseCount = loseCount;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }
}
