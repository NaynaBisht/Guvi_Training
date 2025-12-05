package com.app.features;

public sealed class InsuranceProcessing permits HealthInsuranceProcessing{

	public void processInsurance() {
		System.out.println("process insurance");
	}
}
