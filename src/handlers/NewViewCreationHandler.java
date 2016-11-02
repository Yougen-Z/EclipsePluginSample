package handlers;

import org.eclipse.jface.wizard.IWizard;
import zafinplugintest.NewViewWizard;

public class NewViewCreationHandler extends AbstractNewArtifactCreationHandler {
	
	@Override
	protected final IWizard getWizard() {
		return new NewViewWizard();
	}
}
