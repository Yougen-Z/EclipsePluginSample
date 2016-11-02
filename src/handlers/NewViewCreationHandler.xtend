package handlers

import org.eclipse.jface.wizard.IWizard
import zafinplugintest.NewViewWizard

class NewViewCreationHandler extends AbstractNewArtifactCreationHandler {
	override protected final IWizard getWizard() {
		new NewViewWizard()
	}

}
