public class CPU extends Player{
    int winCount;
    int loseCount;
    /**
     * Constructor for the Player object
     *
     * @param name   is the name
     * @param marker is the players Marker
     */
    public CPU(String name, char marker) {
        super(name, marker);


    }
    /**
     * Method to get the winCount
     * @return the Value of winCount
     */
    public int getWinCount() {
        return winCount;
    }

    /**
     * Method to set the winCount
     * @param winCount is the new WinCount
     */
    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    /**
     * Method to get the LoseCount
     * @return value of LoseCount
     */
    public int getLoseCount() {
        return loseCount;
    }

    /**
     * Method to Set loseCount
     * @param loseCount is the New Value of LoseCount
     */
    public void setLoseCount(int loseCount) {
        this.loseCount = loseCount;
    }
}
