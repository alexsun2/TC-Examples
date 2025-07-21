package Adapter.EnumExample;

/**
 * Enum representing the possible colors assigned to players in the Three Trios
 * game.
 * Each PlayerColor has a unique name and a single-character identifier.
 * The enum includes the colors RED and BLUE for players and an UNASSIGNED color
 * used for cases when no player color is specified.
 */
public enum PlayerColor {
    RED("RED"),
    BLUE("BLUE");

    private final String colorName;

    /**
     * Creates an instance of a PlayerColor with the specified color name.
     *
     * @param colorName the name of the color, used for display and identification.
     */
    PlayerColor(String colorName) {
        this.colorName = colorName;
    }

    /**
     * Returns the color name as a string.
     *
     * @return the name of the color.
     */
    @Override
    public String toString() {
        return this.colorName;
    }

    /**
     * Returns the first letter of the color name, used as an abbreviated
     * identifier.
     *
     * @return a single character representing the first letter of the color name.
     */
    public char getColorLetter() {
        return this.colorName.charAt(0);
    }
}
