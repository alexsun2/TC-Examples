package Adapter.EnumExample;

/**
 * Represents the possible Players in a game of ThreeTrios by the color
 * associated with them.
 */
public enum PlayerColor2 {
    RED("RED"),
    BLUE("BLUE");

    private final String name;

    PlayerColor2(String name) {
        this.name = name;
    }

    /**
     * Returns the opposite PlayerColor of this PlayerColor.
     *
     * @return the opposite PlayerColor.
     */
    public PlayerColor2 getOtherColor() {
        if (this == RED) {
            return BLUE;
        } else {
            return RED;
        }
    }

    public String toString() {
        return name;
    }
}
