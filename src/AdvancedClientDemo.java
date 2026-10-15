public class AdvancedClientDemo {

    public static void main(String[] args) {
        MetadataReader reader = new MetadataReader();
        CodecFactory codecs = new CodecFactory();

        System.out.println("song.wav channels: " + reader.readChannels("song.wav"));
        System.out.println("ogg codec: " + codecs.codecNameFor("ogg"));
    }
}
