package util;

/**
 * Used to check the loading status.
 */
public interface ProcessListener {
    boolean isProcessing();
    void jobDone();
}
