package zafinplugintest;


public class NewModelWizard extends AbstractNewWizard {
	private ModelWizardPage page1;
	private NewDescriptionPage page2;
	
	public String getWindowTitle() {
		return "New Model Creation Wizard";
	}

	public void addPages() {
		super.addPages();
		
		page1 = new ModelWizardPage("Basic Info");
		page2 = new NewDescriptionPage("Description");
		addPage(page1);
		addPage(page2);
	}
	
	public boolean performFinish() {		
		page1.displayResult();
		
		return true;
	}
}
