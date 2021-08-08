package com.main;

import java.util.concurrent.SubmissionPublisher;

/**
 * 
 * @author nanda
 *
 */
public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
		publisher.subscribe(new PrintSubscriber());
		System.out.println("Submitting items...");
		for (int i = 0; i < Long.MAX_VALUE; i++) {
			publisher.submit(i);
			Thread.sleep(1000);
		}
		Thread.sleep(1000000000); 
		publisher.close();
	}
}