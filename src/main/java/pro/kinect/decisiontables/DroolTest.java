package pro.kinect.decisiontables;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import pro.kinect.decisiontables.model.Application;

import java.util.Arrays;


public class DroolTest {

	public static void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rule");
			FactHandle fact1;

			Application application = new Application();
			application.setBrand("Lendwise");

			fact1 = kSession.insert(application);

			kSession.fireAllRules();

			System.out.println("Application");
			System.out.println("  Brand: " + application.getBrand());

			System.out.println(
					"Investors " + Arrays.toString(application.getDecisionInvestors().toArray()));

		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

}
