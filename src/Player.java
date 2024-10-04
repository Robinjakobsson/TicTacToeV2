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

    /**
     * Method to return the value of marker
     * @return marker
     */
    public char getMarker() {
        return marker;
    }

    /**
     * Method to set the value of marker
     * @param marker is the marker
     */
    public void setMarker(char marker) {
        this.marker = marker;
    }

    /**
     * Method to get the value of loseCount
     * @return LoseCount
     */
    public int getLoseCount() {
        return loseCount;
    }

    /**
     * Method to set the value of loseCount
     * @param loseCount is the LoseCount
     */
    public void setLoseCount(int loseCount) {
        this.loseCount = loseCount;
    }

    /**
     * Method to get the value of winCount
     * @return value of WinCount
     */
    public int getWinCount() {
        return winCount;
    }

    /**
     * Method to set the value of winCount
     * @param winCount is the WinCount
     */
    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }
}
