package pro.kinect.decisiontables.model;

import java.util.HashSet;

public class InvestorSet {
    HashSet<String> investors = new HashSet<String>();

    public void add(String investor) {
        investors.add(investor);
    }

    public HashSet<String> getInvestors() {
        return investors;
    }

    public void setInvestors(HashSet<String> investors) {
        this.investors = investors;
    }
}
