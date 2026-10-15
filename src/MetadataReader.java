import java.util.Map;

public class MetadataReader {

    private final Map<String, Integer> durations = Map.of("song.wav", 180, "podcast.mp3", 1800, "surround.wav", 120);
    private final Map<String, Integer> channels = Map.of("song.wav", 2, "podcast.mp3", 1, "surround.wav", 6);

    public boolean exists(String fileName) {
        return durations.containsKey(fileName);
    }

    public String readFormat(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }

    public int readDurationSeconds(String fileName) {
        return durations.get(fileName);
    }

    public int readChannels(String fileName) {
        return channels.get(fileName);
    }
}
