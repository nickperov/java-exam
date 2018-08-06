package com.nickperov.oca_1Z0_803.ch1_packaging;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;

/**
 *
 * Task: Change statements from implicit to explicit. 
 *
 */

public class StudExamPack002 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public static void main(String[] args) throws SecurityException, IOException {
		/* Creation of file directory */
		new File( "logs" ).mkdir();
		
		/* Get the date to be used in the filename */
		DateFormat df = new SimpleDateFormat( "yyyyMMddhhmmss" );
		Date now = new Date();
		String date =  df.format( now );
		
		/* Set up file name in the logs directory */
		String logFileName = "logs\\testlog-" + date + ".txt";
		
		
		/* Set up logger */
		FileHandler myFileHandler = new FileHandler( logFileName );
		myFileHandler.setFormatter( new SimpleFormatter() );
		Logger ocajLogger = Logger.getLogger( "OCAJ Logger" );
		ocajLogger.setLevel( Level.ALL );
		ocajLogger.addHandler( myFileHandler );
		
		/* Log Message */
		ocajLogger.info( "\nMessage" );
		
		/* Clouse file */
		myFileHandler.close();
	}
}