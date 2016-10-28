package zafinplugintest;

public class NewViewWizard extends AbstractNewArtifactCreationWizard {
	private ViewWizardPage page1;
	
	@Override
	public String getWindowTitle() {
		return "New View Creation Wizard";
	}

	@Override
	public void addPages() {
		super.addPages();
		
		page1 = new ViewWizardPage("Basic View Info");
		addPage(page1);
	}

	@Override
	public boolean performFinish() {
		
		return true;
	}
}
