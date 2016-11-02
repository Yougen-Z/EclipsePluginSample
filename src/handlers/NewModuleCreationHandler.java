package handlers;

import org.eclipse.jface.wizard.IWizard;

import zafinplugintest.NewModuleWizard;

public class NewModuleCreationHandler extends AbstractNewArtifactCreationHandler {

	@Override
	protected final IWizard getWizard() {
		return new NewModuleWizard();
	}
}
