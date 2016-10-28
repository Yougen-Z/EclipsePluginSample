package zafinplugintest;

public class NewViewWizard extends AbstractNewWizard {

	private ViewWizardPage page1;
	
	public String getWindowTitle() {
		return "New View Creation Wizard";
	}

	public void addPages() {
		super.addPages();
		
		page1 = new ViewWizardPage("Basic View Info");
		addPage(page1);
	}

}
