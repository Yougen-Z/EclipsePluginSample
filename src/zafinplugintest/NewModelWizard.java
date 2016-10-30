package zafinplugintest;

public class NewModelWizard extends AbstractNewArtifactCreationWizard {
	private ModelWizardPage page1;
	private DescriptionWizardPage page2;
	
	@Override
	public String getWindowTitle() {
		return "New Model Creation Wizard";
	}

	@Override
	public void addPages() {
		super.addPages();
		page1 = new ModelWizardPage();
		page2 = new DescriptionWizardPage();
		addPage(page1);
		addPage(page2);
	}

	@Override
	public boolean performFinish() {		
		page1.displayResult();
		
		return true;
	}
}
