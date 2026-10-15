public class MediaConversionFacade {

    private final MetadataReader metadataReader = new MetadataReader();
    private final BitrateReader bitrateReader = new BitrateReader();
    private final CodecFactory codecFactory = new CodecFactory();
    private final AudioMixer audioMixer = new AudioMixer();

    public String convert(String fileName, String targetFormat) {
        String format = targetFormat.toLowerCase();
        if (!metadataReader.exists(fileName)) {
            return "FAILED: file not found: " + fileName;
        }
        if (!codecFactory.isSupported(format)) {
            return "FAILED: unsupported format: " + targetFormat;
        }

        int sourceBitrate = bitrateReader.readBitrateKbps(metadataReader.readFormat(fileName));
        int targetBitrate = codecFactory.fitBitrateKbps(format, sourceBitrate);
        int channels = audioMixer.mixChannels(metadataReader.readChannels(fileName));
        int duration = metadataReader.readDurationSeconds(fileName);

        return String.format("OK: %s -> %s [%s, %d kbps, %d ch, %d s]",
                fileName, outputName(fileName, format), codecFactory.codecNameFor(format),
                targetBitrate, channels, duration);
    }

    private String outputName(String fileName, String format) {
        return fileName.substring(0, fileName.lastIndexOf('.')) + "." + format;
    }
}
