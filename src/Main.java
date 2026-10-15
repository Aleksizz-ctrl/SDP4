public class Main {

    public static void main(String[] args) {
        MediaConversionFacade converter = new MediaConversionFacade();

        System.out.println(converter.convert("song.wav", "mp3"));
        System.out.println(converter.convert("podcast.mp3", "ogg"));
        System.out.println(converter.convert("surround.wav", "AAC"));
        System.out.println(converter.convert("song.wav", "xyz"));
        System.out.println(converter.convert("missing.wav", "mp3"));
    }
}