package pro.kinect.decisiontables;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import pro.kinect.decisiontables.model.Application;

import java.io.*;
import java.util.Arrays;


public class DroolTest {

    public final static String XLS_STANDART_PATH = "src/main/resources/rules/investors-brands.xls";
    public final static String DRL_STANDART_PATH = "src/main/resources/investors-brands-rule-template.drl";

	public static void main(String[] args) {
		try {
            convert_xls_to_drl(XLS_STANDART_PATH, DRL_STANDART_PATH);

			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rule");
			FactHandle fact1;

			Application application = new Application();
			application.setBrand("Google");

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

    public static void convert_xls_to_drl(String xlsPath, String drlPath) {
        try {
            InputStream inputStream = null;

            try {
                inputStream = new FileInputStream(xlsPath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            SpreadsheetCompiler sc = new SpreadsheetCompiler();

            String drl = sc.compile(inputStream, InputType.XLS);

            final OutputStream os = new FileOutputStream(drlPath);
            final PrintStream printStream = new PrintStream(os);

            printStream.print(drl);
            printStream.close();

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
