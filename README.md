# Assignment 4 — Facade Pattern

**Name:** Borovikov Vyacheslav
**Group:** SE-2528
**Topic:** Option A — Media Conversion Facade

## What it is

A simple Java project that shows the Facade pattern. Converting an audio file takes several steps (read metadata, read bitrate, choose a codec, mix channels). Instead of calling each step by hand, the client calls one method: `convert(fileName, targetFormat)`.

## Classes

| Role | Class | What it does |
|---|---|---|
| Facade | `MediaConversionFacade` | Calls the subsystem classes in the right order |
| Subsystem | `MetadataReader` | Reads format, duration and channels of the file |
| Subsystem | `BitrateReader` | Reads the bitrate of the source format |
| Subsystem | `CodecFactory` | Checks the target format, gives the codec and limits the bitrate |
| Subsystem | `AudioMixer` | Mixes the channels down to stereo |
| Client | `Main` | Uses only the facade |
| Advanced client | `AdvancedClientDemo` | Uses subsystem classes directly, without the facade |

Subsystem classes do not know about the facade, so they can also be used on their own.

## How to run

Open the project in IntelliJ IDEA (JDK 17) and run `Main.main()`.

Expected output:

```
OK: song.wav -> song.mp3 [LAME MP3, 320 kbps, 2 ch, 180 s]
OK: podcast.mp3 -> podcast.ogg [Vorbis, 192 kbps, 1 ch, 1800 s]
OK: surround.wav -> surround.aac [AAC-LC, 256 kbps, 2 ch, 120 s]
FAILED: unsupported format: xyz
FAILED: file not found: missing.wav
```