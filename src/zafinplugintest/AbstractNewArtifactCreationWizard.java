package zafinplugintest;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public abstract class AbstractNewArtifactCreationWizard  extends Wizard implements INewWizard {

	private IWorkbench workbench;
	private IStructuredSelection selection;
	
	public AbstractNewArtifactCreationWizard() {
		super();
		setNeedsProgressMonitor(false);
	}
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}
	
	public IWorkbench getWorkbench() {
		return workbench;
	}

	public IStructuredSelection getSelection() {
		return selection;
	}
}
