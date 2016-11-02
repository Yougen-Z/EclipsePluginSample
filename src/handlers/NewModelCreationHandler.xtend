package handlers

import org.eclipse.jface.wizard.IWizard
import zafinplugintest.NewModelWizard

class NewModelCreationHandler extends AbstractNewArtifactCreationHandler {
	override protected final IWizard getWizard() {
		new NewModelWizard()
	}

}
