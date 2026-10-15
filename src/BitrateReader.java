public class BitrateReader {

    public int readBitrateKbps(String format) {
        return switch (format) {
            case "wav" -> 1411;
            case "mp3" -> 192;
            default -> 128;
        };
    }
}
