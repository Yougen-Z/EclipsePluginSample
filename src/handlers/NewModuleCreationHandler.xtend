package handlers

import org.eclipse.jface.wizard.IWizard
import zafinplugintest.NewModuleWizard

class NewModuleCreationHandler extends AbstractNewArtifactCreationHandler {
	override protected final IWizard getWizard() {
		new NewModuleWizard()
	}

}
