package utilities;

import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class ScreenRecorderUtil extends ScreenRecorder {
    private static ScreenRecorder screenRecorder;
    private String fileName;

    public ScreenRecorderUtil(GraphicsConfiguration gc, Rectangle captureArea, Format fileFormat,
                              Format screenFormat, Format mouseFormat, Format audioFormat, File outputFolder, String fileName)
            throws IOException, AWTException {
        super(gc, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, outputFolder);
        this.fileName = fileName;
    }

    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        if (!movieFolder.exists()) {
            movieFolder.mkdirs();
        }
        return new File(movieFolder, fileName + "." + Registry.getInstance().getExtension(fileFormat));
    }

    public static void startRecording(String testName) {
        try {
            File file = new File("./target/recordings/");
            GraphicsConfiguration gc = GraphicsEnvironment
                    .getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice()
                    .getDefaultConfiguration();

            screenRecorder = new ScreenRecorderUtil(gc, gc.getBounds(),
                    new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_QUICKTIME),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_QUICKTIME_JPEG,
                            CompressorNameKey, ENCODING_QUICKTIME_JPEG, DepthKey, 24, FrameRateKey,
                            Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                    null, file, testName);

            screenRecorder.start();
        } catch (Exception e) {
            System.err.println("Could not start video recording: " + e.getMessage());
        }
    }

    public static void stopRecording() {
        try {
            if (screenRecorder != null) {
                screenRecorder.stop();
            }
        } catch (Exception e) {
            System.err.println("Could not stop video recording cleanly: " + e.getMessage());
        }
    }
}