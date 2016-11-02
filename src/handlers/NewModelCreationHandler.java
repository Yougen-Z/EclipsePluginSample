package handlers;

import org.eclipse.jface.wizard.IWizard;

import zafinplugintest.NewModelWizard;

public class NewModelCreationHandler extends AbstractNewArtifactCreationHandler {

	@Override
	protected final IWizard getWizard() {
		return new NewModelWizard();
	}
}
