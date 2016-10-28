package zafinplugintest;

public class NewModelWizard extends AbstractNewArtifactCreationWizard {
	private ModelWizardPage page1;
	private NewDescriptionPage page2;
	
	@Override
	public String getWindowTitle() {
		return "New Model Creation Wizard";
	}

	@Override
	public void addPages() {
		super.addPages();
		
		page1 = new ModelWizardPage("Basic Info");
		page2 = new NewDescriptionPage("Description");
		addPage(page1);
		addPage(page2);
	}

	@Override
	public boolean performFinish() {		
		page1.displayResult();
		
		return true;
	}
}
