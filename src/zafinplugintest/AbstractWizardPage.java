package zafinplugintest;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

public abstract class AbstractWizardPage extends WizardPage {
//    private String pageName;
//    private String title;
//    private String description;

	public AbstractWizardPage(String pageName) {
		super(pageName);
	}

	@Override
	public void createControl(Composite parent) {
		
	}

}
