package handlers

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.jface.wizard.IWizard
import org.eclipse.jface.wizard.WizardDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.ui.handlers.HandlerUtil

abstract class AbstractNewArtifactCreationHandler extends AbstractHandler {
	override Object execute(ExecutionEvent event) throws ExecutionException {
		openWizard(getShell(event), getWizard())
		null
	}

	def protected void openWizard(Shell shell, IWizard wizard) {
		new WizardDialog(shell, wizard).open()
	}

	def protected Shell getShell(ExecutionEvent event) {
		HandlerUtil.getActiveShell(event)
	}

	def protected IWizard getWizard() {
		null
	}

}
