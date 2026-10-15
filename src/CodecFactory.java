import java.util.Map;

public class CodecFactory {

    private final Map<String, String> codecNames = Map.of("mp3", "LAME MP3", "ogg", "Vorbis", "aac", "AAC-LC");
    private final Map<String, Integer> maxBitrates = Map.of("mp3", 320, "ogg", 256, "aac", 256);

    public boolean isSupported(String format) {
        return codecNames.containsKey(format);
    }

    public String codecNameFor(String format) {
        return codecNames.get(format);
    }

    public int fitBitrateKbps(String format, int sourceBitrateKbps) {
        return Math.min(sourceBitrateKbps, maxBitrates.get(format));
    }
}
