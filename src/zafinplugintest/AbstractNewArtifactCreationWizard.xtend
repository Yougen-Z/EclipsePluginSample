package zafinplugintest

import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.wizard.Wizard
import org.eclipse.ui.INewWizard
import org.eclipse.ui.IWorkbench
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors abstract class AbstractNewArtifactCreationWizard extends Wizard implements INewWizard {
	IWorkbench workbench
	IStructuredSelection selection

	new() {
		super()
		setNeedsProgressMonitor(false)
	}

	override void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench
		this.selection = selection
	}

	override boolean performFinish() {
		true
	}
}
