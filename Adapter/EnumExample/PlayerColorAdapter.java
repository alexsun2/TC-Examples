package Adapter.EnumExample;

/**
 * A two-way adapter class for converting between the application's PlayerColor
 * enum and
 * the provider's PlayerColor enum.
 */
public class PlayerColorAdapter {

    /**
     * Converts this application's PlayerColor enum to the provider's PlayerColor
     * enum.
     *
     * @param color our PlayerColor implementation to convert
     * @return the corresponding provider-compatible PlayerColor
     * @throws IllegalArgumentException if the provided color is unknown or null
     */
    public static PlayerColor2 toProviderPlayerColor(PlayerColor color) {
        if (color == null) {
            throw new IllegalArgumentException("The player color cannot be null.");
        }

        switch (color) {
            case RED:
                return PlayerColor2.RED;
            case BLUE:
                return PlayerColor2.BLUE;
            default:
                throw new IllegalArgumentException("Unknown PlayerColor: " + color);
        }
    }

    /**
     * Converts the provider's PlayerColor enum to this application's PlayerColor
     * enum.
     *
     * @param color the provider's PlayerColor enum to convert
     * @return the corresponding application-compatible PlayerColor
     * @throws IllegalArgumentException if the provided color is unknown or null
     */
    public static PlayerColor toBasePlayerColor(
            Adapter.EnumExample.PlayerColor color) {
        if (color == null) {
            throw new IllegalArgumentException("The player color cannot be null.");
        }

        switch (color) {
            case RED:
                return PlayerColor.RED;
            case BLUE:
                return PlayerColor.BLUE;
            default:
                throw new IllegalArgumentException("Unknown PlayerColor: " + color);
        }
    }
}
