package pro.kinect.decisiontables.model;

import java.util.HashSet;

public class Application {

	private String brand;

	private HashSet<String> decisionInvestors = new HashSet<String>();

	public void addDecisionInvestor(String investor) {
		decisionInvestors.add(investor);
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public HashSet<String> getDecisionInvestors() {
		return decisionInvestors;
	}

	public void setDecisionInvestors(HashSet<String> decisionInvestors) {
		this.decisionInvestors = decisionInvestors;
	}

}