package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
	private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

	// ANSI escape codes
	private static final String RESET = "\u001B[0m";
	private static final String RED = "\u001B[31m";
	private static final String GREEN = "\u001B[32m";
	private static final String YELLOW = "\u001B[33m";
	private static final String BLUE = "\u001B[34m";
	private static final String PURPLE = "\u001B[35m";

	public static void info(String message) {
		logger.info(GREEN + message + RESET);
	}

	public static void title(String message) {
		logger.info(PURPLE + message + RESET);
	}

	public static void warn(String message) {
		logger.warn(YELLOW + message + RESET);
	}

	public static void error(String message) {
		logger.error(RED + message + RESET);
	}

	public static void debug(String message) {
		logger.debug(BLUE + message + RESET);
	}

	public static void critical(String message) {
		logger.fatal(PURPLE + message + RESET);
	}
}