package com.main;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class PrintSubscriber implements Subscriber<Integer> {

	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		System.out.println("Subscribed"); 
		this.subscription = subscription;
		System.out.println("i am runing indepen");
		this.subscription.request(1);
		System.out.println("THis shoudl nver be execcute"); 
	}

	@Override
	public void onNext(Integer item) {
		System.out.println("Received item: " + item);
		subscription.request(1);
	//	throw new NullPointerException();
	}

	@Override
	public void onError(Throwable error) {
		System.out.println("Error occurred: " + error.getMessage());
	}

	@Override
	public void onComplete() {
		System.out.println("PrintSubscriber is complete");
	}
}
