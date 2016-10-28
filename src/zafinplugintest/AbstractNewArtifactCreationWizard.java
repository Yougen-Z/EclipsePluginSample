package zafinplugintest;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public abstract class AbstractNewArtifactCreationWizard  extends Wizard implements INewWizard {

	public AbstractNewArtifactCreationWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public String getWindowTitle() {
		return "New Artifact Creation";
	}
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		
	}
}
