public class AudioMixer {

    private static final int MAX_OUTPUT_CHANNELS = 2;

    public int mixChannels(int sourceChannels) {
        return Math.min(sourceChannels, MAX_OUTPUT_CHANNELS);
    }
}
