package com.baesystems.environmentinfrastructure.application;

public class ProgressMonitor {

	private int numberOfItemsProcessed;
	private int numberOfItemsToProcess;
	private int progressStep = 0;
	private String thingBeingProcessed;

	public ProgressMonitor(String thingBeingProcessed, int numberOfItemsToProcess) {
		this.numberOfItemsToProcess = numberOfItemsToProcess;
		this.thingBeingProcessed = thingBeingProcessed;
	}

	public void itemProcessed() {
		numberOfItemsProcessed++;
		double progress = 100 * numberOfItemsProcessed/numberOfItemsToProcess;
		if(progress > progressStep && (int)progress != 100)
		{
			showProgress(" " + thingBeingProcessed + " progress " + (int)progress + "%");
			progressStep = (int)progress + 5;
		}
	}

	public void startedProcessing() {
		if(numberOfItemsToProcess > 0) {
			showProgress("Started processing " + thingBeingProcessed + " (" + numberOfItemsToProcess + " items)");
		} else {
			showProgress("No items to process for " + thingBeingProcessed);
		}
	}

	public void completedProcessing() {
		if(numberOfItemsToProcess > 0) {
			showProgress("Completed processing " + thingBeingProcessed);
		} else {
			
		}
	}

	private void showProgress(String string) {
		if(numberOfItemsToProcess > 100) {
			Logger.log(string);
		}
	}
}
