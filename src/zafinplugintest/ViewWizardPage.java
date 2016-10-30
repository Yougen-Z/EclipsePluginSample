package zafinplugintest;

import org.eclipse.swt.widgets.Composite;

public class ViewWizardPage extends AbstractArtifactWizardPage {

	public ViewWizardPage() {
		super(Messages.ViewWizardPage_Name
				, Messages.ViewWizardPage_Description
				, Messages.ViewWizardPage_Type);
    }
	
	@Override
	protected void addCustomControls(Composite container) {     
        addDescriptionControl(container);
	}
}
