package zafinplugintest;

public class NewModelWizard extends AbstractNewArtifactCreationWizard {
	private ModelWizardPage modelWizardPage;
	private DescriptionWizardPage descriptionWizardPage;
	
	@Override
	public String getWindowTitle() {
		return "New Model Creation Wizard";
	}

	@Override
	public void addPages() {
		super.addPages();
		modelWizardPage = new ModelWizardPage();
		addPage(modelWizardPage);
		descriptionWizardPage = new DescriptionWizardPage();
		addPage(descriptionWizardPage);
	}

	@Override
	public boolean performFinish() {		
		modelWizardPage.displayResult();
		
		return true;
	}
}
